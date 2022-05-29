package io.mystore.shipping.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.shipping.entity.OrderCreated
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingToOrderSkuItemAction(creationContext: ActionCreationContext) extends AbstractShippingToOrderSkuItemAction {

  override def onOrderCreated(orderCreated: OrderCreated): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnOrderCreated` is not implemented, yet")
  }
  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `IgnoreOtherEvents` is not implemented, yet")
  }
}

