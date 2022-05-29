package io.mystore.shipping.entity

import com.google.protobuf.empty.Empty
import io.mystore.shipping.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class Shipping(context: EventSourcedEntityContext) extends AbstractShipping {
  override def emptyState: OrderState =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state")

  override def createOrder(currentState: OrderState, createOrderCommand: api.CreateOrderCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `CreateOrder` is not implemented, yet")

  override def shippedOrderSkuItem(currentState: OrderState, shippedOrderSkuItemCommand: api.ShippedOrderSkuItemCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `ShippedOrderSkuItem` is not implemented, yet")

  override def releaseOrderSkuItem(currentState: OrderState, releaseOrderSkuItemCommand: api.ReleaseOrderSkuItemCommand): EventSourcedEntity.Effect[Empty] =
    effects.error("The command handler for `ReleaseOrderSkuItem` is not implemented, yet")

  override def getOrder(currentState: OrderState, getOrderRequest: api.GetOrderRequest): EventSourcedEntity.Effect[api.Order] =
    effects.error("The command handler for `GetOrder` is not implemented, yet")

  override def orderCreated(currentState: OrderState, orderCreated: OrderCreated): OrderState =
    throw new RuntimeException("The event handler for `OrderCreated` is not implemented, yet")

  override def orderShipped(currentState: OrderState, orderShipped: OrderShipped): OrderState =
    throw new RuntimeException("The event handler for `OrderShipped` is not implemented, yet")

  override def orderReleased(currentState: OrderState, orderReleased: OrderReleased): OrderState =
    throw new RuntimeException("The event handler for `OrderReleased` is not implemented, yet")

  override def orderItemShipped(currentState: OrderState, orderItemShipped: OrderItemShipped): OrderState =
    throw new RuntimeException("The event handler for `OrderItemShipped` is not implemented, yet")

  override def orderItemReleased(currentState: OrderState, orderItemReleased: OrderItemReleased): OrderState =
    throw new RuntimeException("The event handler for `OrderItemReleased` is not implemented, yet")

  override def orderSkuItemShipped(currentState: OrderState, orderSkuItemShipped: OrderSkuItemShipped): OrderState =
    throw new RuntimeException("The event handler for `OrderSkuItemShipped` is not implemented, yet")

  override def orderSkuItemReleased(currentState: OrderState, orderSkuItemReleased: OrderSkuItemReleased): OrderState =
    throw new RuntimeException("The event handler for `OrderSkuItemReleased` is not implemented, yet")

}
