package io.mystore.stock.entity

import com.google.protobuf.empty.Empty
import io.mystore.stock.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockSkuItemApi(context: EventSourcedEntityContext) extends AbstractStockSkuItemApi {
  override def emptyState: StockSkuItemState =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def createStockSkuItem(currentState: StockSkuItemState, createStockSkuItemCommand: api.CreateStockSkuItemCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `CreateStockSkuItem` is not implemented, yet")

  override def orderRequestsJoinToStock(currentState: StockSkuItemState, orderRequestsJoinToStockCommand: api.OrderRequestsJoinToStockCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `OrderRequestsJoinToStock` is not implemented, yet")

  override def orderRequestsJoinToStockRejected(currentState: StockSkuItemState, orderRequestsJoinToStockRejectedCommand: api.OrderRequestsJoinToStockRejectedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `OrderRequestsJoinToStockRejected` is not implemented, yet")

  override def stockRequestedJoinToOrderAccepted(currentState: StockSkuItemState, stockRequestedJoinToOrderAcceptedCommand: api.StockRequestedJoinToOrderAcceptedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `StockRequestedJoinToOrderAccepted` is not implemented, yet")

  override def stockRequestedJoinToOrderRejected(currentState: StockSkuItemState, stockRequestedJoinToOrderRejectedCommand: api.StockRequestedJoinToOrderRejectedCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `StockRequestedJoinToOrderRejected` is not implemented, yet")

  override def getStockSkuItem(currentState: StockSkuItemState, getStockSKuItemRequest: api.GetStockSKuItemRequest): EventSourcedEntity.Effect[api.GetStockSKuItemResponse] =
    effects.error("The command handler for `GetStockSkuItem` is not implemented, yet")

  override def stockSkuItemCreated(currentState: StockSkuItemState, stockSkuItemCreated: StockSkuItemCreated): StockSkuItemState =
    throw new RuntimeException("The event handler for `StockSkuItemCreated` is not implemented, yet")

  override def orderRequestedJoinToStockAccepted(currentState: StockSkuItemState, orderRequestedJoinToStockAccepted: OrderRequestedJoinToStockAccepted): StockSkuItemState =
    throw new RuntimeException("The event handler for `OrderRequestedJoinToStockAccepted` is not implemented, yet")

  override def orderRequestedJoinToStockRejected(currentState: StockSkuItemState, orderRequestedJoinToStockRejected: OrderRequestedJoinToStockRejected): StockSkuItemState =
    throw new RuntimeException("The event handler for `OrderRequestedJoinToStockRejected` is not implemented, yet")

  override def stockRequestedJoinToOrder(currentState: StockSkuItemState, stockRequestedJoinToOrder: StockRequestedJoinToOrder): StockSkuItemState =
    throw new RuntimeException("The event handler for `StockRequestedJoinToOrder` is not implemented, yet")

  override def stockRequestedJoinToOrderAccepted(currentState: StockSkuItemState, stockRequestedJoinToOrderAccepted: StockRequestedJoinToOrderAccepted): StockSkuItemState =
    throw new RuntimeException("The event handler for `StockRequestedJoinToOrderAccepted` is not implemented, yet")

  override def stockRequestedJoinToOrderRejected(currentState: StockSkuItemState, stockRequestedJoinToOrderRejected: StockRequestedJoinToOrderRejected): StockSkuItemState =
    throw new RuntimeException("The event handler for `StockRequestedJoinToOrderRejected` is not implemented, yet")

}
