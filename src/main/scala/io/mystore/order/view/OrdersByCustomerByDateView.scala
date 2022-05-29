package io.mystore.order.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.order.entity.OrderCreated
import io.mystore.order.entity.OrderItemShipped
import io.mystore.order.entity.OrderShipped
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrdersByCustomerByDateView(context: ViewContext) extends AbstractOrdersByCustomerByDateView {

  override def emptyState: Order =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onOrdered(
    state: Order, orderCreated: OrderCreated): UpdateEffect[Order] =
    throw new UnsupportedOperationException("Update handler for 'OnOrdered' not implemented yet")

  override def onOrderShipped(
    state: Order, orderShipped: OrderShipped): UpdateEffect[Order] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderShipped' not implemented yet")

  override def onOrderItemShipped(
    state: Order, orderItemShipped: OrderItemShipped): UpdateEffect[Order] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderItemShipped' not implemented yet")

  override def ignoreOtherEvents(
    state: Order, any: ScalaPbAny): UpdateEffect[Order] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
