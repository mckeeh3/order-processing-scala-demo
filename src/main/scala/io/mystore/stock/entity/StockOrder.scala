package io.mystore.stock.entity

import com.google.protobuf.empty.Empty
import io.mystore.stock.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockOrder(context: EventSourcedEntityContext) extends AbstractStockOrder {
  override def emptyState: StockOrderState =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def createStockOrder(currentState: StockOrderState, createStockOrderCommand: api.CreateStockOrderCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `CreateStockOrder` is not implemented, yet")

  override def shippedStockSkuItem(currentState: StockOrderState, shippedStockSkuItemToStockOrderCommand: api.ShippedStockSkuItemToStockOrderCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `ShippedStockSkuItem` is not implemented, yet")

  override def releaseStockSkuItem(currentState: StockOrderState, releaseStockSkuItemFromStockOrderCommand: api.ReleaseStockSkuItemFromStockOrderCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `ReleaseStockSkuItem` is not implemented, yet")

  override def getStockOrder(currentState: StockOrderState, getStockOrderRequest: api.GetStockOrderRequest): EventSourcedEntity.Effect[api.StockOrder] =
    effects.error("The command handler for `GetStockOrder` is not implemented, yet")

  override def stockOrderCreated(currentState: StockOrderState, stockOrderCreated: StockOrderCreated): StockOrderState =
    throw new RuntimeException("The event handler for `StockOrderCreated` is not implemented, yet")

  override def stockSkuItemShipped(currentState: StockOrderState, stockSkuItemShipped: StockSkuItemShipped): StockOrderState =
    throw new RuntimeException("The event handler for `StockSkuItemShipped` is not implemented, yet")

  override def stockSkuItemReleased(currentState: StockOrderState, stockSkuItemReleased: StockSkuItemReleased): StockOrderState =
    throw new RuntimeException("The event handler for `StockSkuItemReleased` is not implemented, yet")

}
