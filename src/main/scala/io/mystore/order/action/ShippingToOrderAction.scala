package io.mystore.order.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.shipping.entity.OrderItemReleased
import io.mystore.shipping.entity.OrderItemShipped
import io.mystore.shipping.entity.OrderReleased
import io.mystore.shipping.entity.OrderShipped
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingToOrderAction(creationContext: ActionCreationContext) extends AbstractShippingToOrderAction {

  override def onOrderShipped(orderShipped: OrderShipped): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderShipped` is not implemented, yet")
  }
  override def onOrderReleased(orderReleased: OrderReleased): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderReleased` is not implemented, yet")
  }
  override def onOrderItemShipped(orderItemShipped: OrderItemShipped): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderItemShipped` is not implemented, yet")
  }
  override def onOrderItemReleased(orderItemReleased: OrderItemReleased): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderItemReleased` is not implemented, yet")
  }
  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `IgnoreOtherEvents` is not implemented, yet")
  }
}

