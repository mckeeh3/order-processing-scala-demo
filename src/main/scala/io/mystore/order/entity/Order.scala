package io.mystore.order.entity

import com.google.protobuf.empty.Empty
import io.mystore.order.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext
import io.mystore.TimeTo

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class Order(context: EventSourcedEntityContext) extends AbstractOrder {
  private val log = org.slf4j.LoggerFactory.getLogger(classOf[Order])

  override def emptyState: OrderState = OrderState()

  override def createOrder(state: OrderState, command: api.CreateOrderCommand): EventSourcedEntity.Effect[Empty] =
    handle(state, command)

  override def shippedOrder(state: OrderState, command: api.ShippedOrderCommand): EventSourcedEntity.Effect[Empty] =
    handle(state, command)

  override def releasedOrder(state: OrderState, command: api.ReleasedOrderCommand): EventSourcedEntity.Effect[Empty] =
    handle(state, command)

  override def shippedOrderItem(state: OrderState, command: api.ShippedOrderSkuCommand): EventSourcedEntity.Effect[Empty] =
    handle(state, command)

  override def releasedOrderItem(state: OrderState, command: api.ReleasedOrderSkuCommand): EventSourcedEntity.Effect[Empty] =
    handle(state, command)

  override def deliveredOrder(state: OrderState, command: api.DeliveredOrderCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def returnedOrder(state: OrderState, command: api.ReturnedOrderCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def canceledOrder(state: OrderState, command: api.CanceledOrderCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def getOrder(state: OrderState, request: api.GetOrderRequest): EventSourcedEntity.Effect[api.Order] =
    handle(state, request)

  override def orderCreated(state: OrderState, event: OrderCreated): OrderState =
    updateState(state, event)

  override def orderShipped(state: OrderState, event: OrderShipped): OrderState =
    updateState(state, event)

  override def orderReleased(state: OrderState, event: OrderReleased): OrderState =
    updateState(state, event)

  override def orderDelivered(state: OrderState, event: OrderDelivered): OrderState =
    updateState(state, event)

  override def orderReturned(state: OrderState, event: OrderReturned): OrderState =
    updateState(state, event)

  override def orderCancelled(state: OrderState, event: OrderCancelled): OrderState =
    updateState(state, event)

  override def orderItemShipped(state: OrderState, event: OrderItemShipped): OrderState =
    updateState(state, event)

  override def orderItemReleased(state: OrderState, event: OrderItemReleased): OrderState =
    updateState(state, event)

  private def reject(state: OrderState, command: api.DeliveredOrderCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    None
  }

  private def reject(state: OrderState, command: api.ReturnedOrderCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    None
  }

  private def reject(state: OrderState, command: api.CanceledOrderCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    None
  }

  private def handle(state: OrderState, command: api.CreateOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nCreateOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.ShippedOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nShippedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.ReleasedOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.ShippedOrderSkuCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.ReleasedOrderSkuCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.DeliveredOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.ReturnedOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, command: api.CanceledOrderCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nReleasedOrderCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: OrderState, request: api.GetOrderRequest): EventSourcedEntity.Effect[api.Order] = {
    effects.reply(toApi(state))
  }

  private def updateState(state: OrderState, event: OrderCreated) = {
    state.copy(
      orderId = event.orderId,
      customerId = event.customerId,
      orderedUtc = event.orderedUtc,
      orderItems = event.orderItems.map(item => OrderItem(item.skuId, item.skuName, item.quantity, item.shippedUtc))
    )
  }

  private def updateState(state: OrderState, event: OrderShipped) = {
    state
  }

  private def updateState(state: OrderState, event: OrderReleased) = {
    state
  }

  private def updateState(state: OrderState, event: OrderDelivered) = {
    state
  }

  private def updateState(state: OrderState, event: OrderReturned) = {
    state
  }

  private def updateState(state: OrderState, event: OrderCancelled) = {
    state
  }

  private def updateState(state: OrderState, event: OrderItemShipped) = {
    state
  }

  private def updateState(state: OrderState, event: OrderItemReleased) = {
    state
  }

  private def eventFor(state: OrderState, command: api.CreateOrderCommand) = {
    OrderCreated(
      orderId = command.orderId,
      customerId = command.customerId,
      orderedUtc = command.orderedUtc,
      orderItems = command.orderItems.map(item =>
        OrderItem(
          skuId = item.skuId,
          skuName = item.skuName,
          quantity = item.quantity
        )
      )
    )
  }

  private def eventFor(state: OrderState, command: api.ShippedOrderCommand) = {
    OrderShipped(
      orderId = command.orderId,
      shippedUtc = Some(TimeTo.now())
    )
  }

  private def eventFor(state: OrderState, command: api.ReleasedOrderCommand) = {
    OrderReleased(
      orderId = command.orderId
    )
  }

  private def eventFor(state: OrderState, command: api.ShippedOrderSkuCommand) = {
    OrderItemShipped(
      orderId = command.orderId,
      skuId = command.skuId,
      shippedUtc = Some(TimeTo.now())
    )
  }

  private def eventFor(state: OrderState, command: api.ReleasedOrderSkuCommand) = {
    OrderItemReleased(
      orderId = command.orderId,
      skuId = command.skuId,
      shippedUtc = Some(TimeTo.zero())
    )
  }

  private def eventFor(state: OrderState, command: api.DeliveredOrderCommand) = {
    OrderDelivered(
      orderId = command.orderId,
      deliveredUtc = Some(TimeTo.now())
    )
  }

  private def eventFor(state: OrderState, command: api.ReturnedOrderCommand) = {
    OrderReturned(
      orderId = command.orderId,
      returnedUtc = Some(TimeTo.now())
    )
  }

  private def eventFor(state: OrderState, command: api.CanceledOrderCommand) = {
    OrderCancelled(
      orderId = command.orderId,
      canceledUtc = Some(TimeTo.now())
    )
  }

  private def toApi(state: OrderState): api.Order = {
    api.Order(
      orderId = state.orderId,
      customerId = state.customerId,
      orderedUtc = state.orderedUtc,
      shippedUtc = state.shippedUtc,
      deliveredUtc = state.deliveredUtc,
      returnedUtc = state.returnedUtc,
      canceledUtc = state.canceledUtc,
      orderItems = state.orderItems.map(item =>
        api.OrderItem(
          skuId = item.skuId,
          skuName = item.skuName,
          quantity = item.quantity,
          shippedUtc = item.shippedUtc
        )
      )
    )
  }
}
