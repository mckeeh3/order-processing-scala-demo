package io.mystore.shipping.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.shipping.entity.OrderCreated
import io.mystore.shipping.entity.OrderItemShipped
import io.mystore.shipping.entity.OrderShipped
import io.mystore.shipping.entity.OrderSkuItemShipped
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingByCustomerByDateView(context: ViewContext) extends AbstractShippingByCustomerByDateView {

  override def emptyState: Shipping =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onOrderCreated(
    state: Shipping, orderCreated: OrderCreated): UpdateEffect[Shipping] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderCreated' not implemented yet")

  override def onOrderShipped(
    state: Shipping, orderShipped: OrderShipped): UpdateEffect[Shipping] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderShipped' not implemented yet")

  override def onOrderItemShipped(
    state: Shipping, orderItemShipped: OrderItemShipped): UpdateEffect[Shipping] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderItemShipped' not implemented yet")

  override def onOrderSkuItemShipped(
    state: Shipping, orderSkuItemShipped: OrderSkuItemShipped): UpdateEffect[Shipping] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderSkuItemShipped' not implemented yet")

  override def ignoreOtherEvents(
    state: Shipping, any: ScalaPbAny): UpdateEffect[Shipping] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
