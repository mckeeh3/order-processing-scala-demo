package io.mystore.stock.action

import com.google.protobuf.any.{Any => ScalaPbAny}
import com.google.protobuf.empty.Empty
import io.mystore.shipping.entity.OrderRequestedJoinToStock
import io.mystore.shipping.entity.OrderRequestedJoinToStockRejected
import io.mystore.shipping.entity.StockRequestedJoinToOrderAccepted
import io.mystore.shipping.entity.StockRequestedJoinToOrderRejected
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderSkuItemToStockSkuItemAction(creationContext: ActionCreationContext) extends AbstractOrderSkuItemToStockSkuItemAction {

  override def onOrderRequestedJoinToStock(orderRequestedJoinToStock: OrderRequestedJoinToStock): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderRequestedJoinToStock` is not implemented, yet")
  }

  override def onOrderRequestedJoinToStockRejected(orderRequestedJoinToStockRejected: OrderRequestedJoinToStockRejected): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderRequestedJoinToStockRejected` is not implemented, yet")
  }

  override def onStockRequestedJoinToOrderAccepted(stockRequestedJoinToOrderAccepted: StockRequestedJoinToOrderAccepted): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnStockRequestedJoinToOrderAccepted` is not implemented, yet")
  }

  override def onStockRequestedJoinToOrderRejected(stockRequestedJoinToOrderRejected: StockRequestedJoinToOrderRejected): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnStockRequestedJoinToOrderRejected` is not implemented, yet")
  }

  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    effects.reply(Empty.defaultInstance)
  }
}
