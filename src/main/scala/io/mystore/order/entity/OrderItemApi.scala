package io.mystore.order.entity

import com.google.protobuf.empty.Empty
import io.mystore.TimeTo
import io.mystore.order.api
import kalix.scalasdk.valueentity.ValueEntity
import kalix.scalasdk.valueentity.ValueEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderItemApi(context: ValueEntityContext) extends AbstractOrderItemApi {
  private val log = org.slf4j.LoggerFactory.getLogger(classOf[OrderItemApi])

  override def emptyState: OrderItemState = OrderItemState()

  override def createOrderItem(state: OrderItemState, command: api.CreateOrderItemCommand): ValueEntity.Effect[Empty] =
    handle(state, command)

  override def shippedOrderItem(state: OrderItemState, command: api.ShippedOrderItemCommand): ValueEntity.Effect[Empty] =
    handle(state, command)

  override def getOrderItem(state: OrderItemState, request: api.GetOrderItemRequest): ValueEntity.Effect[api.GetOrderItemResponse] =
    effects.reply(toApi(state))

  def handle(state: OrderItemState, command: api.CreateOrderItemCommand): ValueEntity.Effect[Empty] = {
    log.info("State {}\nCreateOrderItemCommand {}", state, command)

    effects
      .updateState(updateState(state, command))
      .thenReply(Empty.defaultInstance)
  }

  def handle(state: OrderItemState, command: api.ShippedOrderItemCommand): ValueEntity.Effect[Empty] = {
    log.info("State {}\nShippedOrderItemCommand {}", state, command)

    effects
      .updateState(updateState(state, command))
      .thenReply(Empty.defaultInstance)
  }

  private def updateState(state: OrderItemState, command: api.CreateOrderItemCommand): OrderItemState = {
    OrderItemState(
      customerId = command.customerId,
      orderId = command.orderId,
      skuId = command.skuId,
      skuName = command.skuName,
      quantity = command.quantity,
      orderedUtc = command.orderedUtc
    )
  }

  private def updateState(state: OrderItemState, command: api.ShippedOrderItemCommand): OrderItemState = {
    state.copy(shippedUtc = Some(TimeTo.now()))
  }

  private def toApi(state: OrderItemState): api.GetOrderItemResponse = {
    api.GetOrderItemResponse(
      customerId = state.customerId,
      orderId = state.orderId,
      skuId = state.skuId,
      skuName = state.skuName,
      quantity = state.quantity,
      orderedUtc = state.orderedUtc,
      shippedUtc = state.shippedUtc
    )
  }
}
