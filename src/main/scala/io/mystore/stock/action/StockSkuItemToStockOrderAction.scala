package io.mystore.stock.action

import com.google.protobuf.any.{Any => ScalaPbAny}
import com.google.protobuf.empty.Empty
import io.mystore.stock.entity.OrderRequestedJoinToStockAccepted
import io.mystore.stock.entity.OrderRequestedJoinToStockRejected
import io.mystore.stock.entity.StockRequestedJoinToOrderAccepted
import io.mystore.stock.entity.StockRequestedJoinToOrderRejected
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext
import io.mystore.stock.api.OrderRequestsJoinToStockRejectedCommand
import io.mystore.stock.api.StockRequestedJoinToOrderAcceptedCommand
import io.mystore.stock.api.StockRequestedJoinToOrderRejectedCommand
import io.mystore.stock.view.GetStockSkuItemsAvailableRequest
import io.mystore.shipping.api.BackOrderOrderSkuItemCommand
import io.mystore.stock.api.OrderRequestsJoinToStockCommand
import io.mystore.stock.view.StockSkuItem
import io.mystore.stock.view.GetStockSkuItemsAvailableResponse
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockSkuItemToStockOrderAction(creationContext: ActionCreationContext) extends AbstractStockSkuItemToStockOrderAction {
  private val random = new Random()

  override def onOrderRequestedJoinToStockAccepted(event: OrderRequestedJoinToStockAccepted): Action.Effect[Empty] = {
    effects.asyncReply(queryAvailableStockItems(event))
  }

  override def onOrderRequestedJoinToStockRejected(event: OrderRequestedJoinToStockRejected): Action.Effect[Empty] = {
    effects.forward(components.stockSkuItemApi.orderRequestsJoinToStockRejected(toOrderRequestsJoinToStockRejected(event)))
  }

  override def onStockRequestedJoinToOrderAccepted(event: StockRequestedJoinToOrderAccepted): Action.Effect[Empty] = {
    effects.forward(components.stockSkuItemApi.stockRequestedJoinToOrderAccepted(toStockRequestedJoinToOrderAcceptedCommand(event)))
  }

  override def onStockRequestedJoinToOrderRejected(event: StockRequestedJoinToOrderRejected): Action.Effect[Empty] = {
    effects.forward(components.stockSkuItemApi.stockRequestedJoinToOrderRejected(toStockRequestedJoinToOrderRejectedCommand(event)))
  }

  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    effects.reply(Empty.defaultInstance)
  }

  private def queryAvailableStockItems(event: OrderRequestedJoinToStockAccepted) = {
    components.stockSkuItemsAvailableView
      .getStockSkuItemsAvailable(
        GetStockSkuItemsAvailableRequest(
          skuId = event.skuId
        )
      )
      .execute()
      .flatMap(response => onAvailableStockItems(response, event))
  }

  private def onAvailableStockItems(response: GetStockSkuItemsAvailableResponse, event: OrderRequestedJoinToStockAccepted) = {
    if (response.stockSkuItems.isEmpty) {
      backOrderOrderSkuItem(event)
    } else {
      orderRequestedJoinToStock(event, response.stockSkuItems(random.nextInt(response.stockSkuItems.size)))
    }
  }

  private def orderRequestedJoinToStock(event: OrderRequestedJoinToStockAccepted, stockSkuItem: StockSkuItem) = {
    components.stockSkuItemApi
      .orderRequestsJoinToStock(
        OrderRequestsJoinToStockCommand(
          stockSkuItemId = stockSkuItem.stockOrderId,
          skuId = event.skuId,
          orderId = event.orderId,
          orderSkuItemId = event.orderSkuItemId,
          stockOrderId = stockSkuItem.stockOrderId
        )
      )
      .execute()
  }

  private def backOrderOrderSkuItem(event: OrderRequestedJoinToStockAccepted) = {
    components.orderSkuItemApi
      .backOrderOrderSkuItem(
        BackOrderOrderSkuItemCommand(
          orderId = event.orderId,
          orderSkuItemId = event.orderSkuItemId
        )
      )
      .execute()
  }

  private def toOrderRequestsJoinToStockRejected(event: OrderRequestedJoinToStockRejected): OrderRequestsJoinToStockRejectedCommand = {
    OrderRequestsJoinToStockRejectedCommand(
      orderId = event.orderId
    )
  }

  private def toStockRequestedJoinToOrderAcceptedCommand(event: StockRequestedJoinToOrderAccepted): StockRequestedJoinToOrderAcceptedCommand = {
    StockRequestedJoinToOrderAcceptedCommand(
      orderId = event.orderId
    )
  }

  private def toStockRequestedJoinToOrderRejectedCommand(event: StockRequestedJoinToOrderRejected): StockRequestedJoinToOrderRejectedCommand = {
    StockRequestedJoinToOrderRejectedCommand(
      orderId = event.orderId,
      orderSkuItemId = event.orderSkuItemId
    )
  }
}
