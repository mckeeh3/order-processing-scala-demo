package io.mystore.shipping.entity

import com.google.protobuf.empty.Empty
import io.mystore.shipping.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderSkuItemApi(context: EventSourcedEntityContext) extends AbstractOrderSkuItemApi {
  override def emptyState: OrderSkuItemState =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def createOrderSkuItem(currentState: OrderSkuItemState, createOrderSkuItemCommand: api.CreateOrderSkuItemCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `CreateOrderSkuItem` is not implemented, yet")

  override def stockRequestsJoinToOrder(currentState: OrderSkuItemState, stockRequestsJoinToOrderCommand: api.StockRequestsJoinToOrderCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `StockRequestsJoinToOrder` is not implemented, yet")

  override def stockRequestsJoinToOrderRejected(currentState: OrderSkuItemState, stockRequestsJoinToOrderRejectedCommand: api.StockRequestsJoinToOrderRejectedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `StockRequestsJoinToOrderRejected` is not implemented, yet")

  override def orderRequestedJoinToStockAccepted(currentState: OrderSkuItemState, orderRequestedJoinToStockAcceptedCommand: api.OrderRequestedJoinToStockAcceptedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `OrderRequestedJoinToStockAccepted` is not implemented, yet")

  override def orderRequestedJoinToStockRejected(currentState: OrderSkuItemState, orderRequestedJoinToStockRejectedCommand: api.OrderRequestedJoinToStockRejectedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `OrderRequestedJoinToStockRejected` is not implemented, yet")

  override def backOrderOrderSkuItem(currentState: OrderSkuItemState, backOrderOrderSkuItemCommand: api.BackOrderOrderSkuItemCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `BackOrderOrderSkuItem` is not implemented, yet")

  override def getOrderSkuItem(currentState: OrderSkuItemState, getOrderSkuItemRequest: api.GetOrderSkuItemRequest): EventSourcedEntity.Effect[api.GetOrderSkuItemResponse] =
    effects.error("The command handler for `GetOrderSkuItem` is not implemented, yet")

  override def orderSkuItemCreated(currentState: OrderSkuItemState, orderSkuItemCreated: OrderSkuItemCreated): OrderSkuItemState =
    throw new RuntimeException("The event handler for `OrderSkuItemCreated` is not implemented, yet")

  override def stockRequestedJoinToOrderAccepted(currentState: OrderSkuItemState, stockRequestedJoinToOrderAccepted: StockRequestedJoinToOrderAccepted): OrderSkuItemState =
    throw new RuntimeException("The event handler for `StockRequestedJoinToOrderAccepted` is not implemented, yet")

  override def stockRequestedJoinToOrderRejected(currentState: OrderSkuItemState, stockRequestedJoinToOrderRejected: StockRequestedJoinToOrderRejected): OrderSkuItemState =
    throw new RuntimeException("The event handler for `StockRequestedJoinToOrderRejected` is not implemented, yet")

  override def orderRequestedJoinToStock(currentState: OrderSkuItemState, orderRequestedJoinToStock: OrderRequestedJoinToStock): OrderSkuItemState =
    throw new RuntimeException("The event handler for `OrderRequestedJoinToStock` is not implemented, yet")

  override def orderRequestedJoinToStockAccepted(currentState: OrderSkuItemState, orderRequestedJoinToStockAccepted: OrderRequestedJoinToStockAccepted): OrderSkuItemState =
    throw new RuntimeException("The event handler for `OrderRequestedJoinToStockAccepted` is not implemented, yet")

  override def orderRequestedJoinToStockRejected(currentState: OrderSkuItemState, orderRequestedJoinToStockRejected: OrderRequestedJoinToStockRejected): OrderSkuItemState =
    throw new RuntimeException("The event handler for `OrderRequestedJoinToStockRejected` is not implemented, yet")

  override def backOrderedOrderSkuItem(currentState: OrderSkuItemState, backOrderedOrderSkuItem: BackOrderedOrderSkuItem): OrderSkuItemState =
    throw new RuntimeException("The event handler for `BackOrderedOrderSkuItem` is not implemented, yet")

}
