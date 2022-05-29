package io.mystore.order.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.cart.entity.CartCheckedOut
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CartToOrderAction(creationContext: ActionCreationContext) extends AbstractCartToOrderAction {

  override def onCartCheckedOut(cartCheckedOut: CartCheckedOut): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `OnCartCheckedOut` is not implemented, yet")
  }
  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    throw new RuntimeException("The command handler for `IgnoreOtherEvents` is not implemented, yet")
  }
}

