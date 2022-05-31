package io.mystore.order.action

import com.google.protobuf.any.{Any => ScalaPbAny}
import com.google.protobuf.empty.Empty
import io.mystore.cart.entity.CartCheckedOut
import kalix.scalasdk.action.Action
import kalix.scalasdk.action.ActionCreationContext
import io.mystore.order.api.CreateOrderCommand
import io.mystore.order.api.OrderItem
import io.mystore.cart.entity.CartState

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CartToOrderAction(creationContext: ActionCreationContext) extends AbstractCartToOrderAction {

  override def onCartCheckedOut(cartCheckedOut: CartCheckedOut): Action.Effect[Empty] = {
    effects.forward(components.order.createOrder(toCreateOrderCommand(cartCheckedOut.cartState.get)))
  }

  override def ignoreOtherEvents(any: ScalaPbAny): Action.Effect[Empty] = {
    effects.reply(Empty.defaultInstance)
  }

  private def toCreateOrderCommand(cartState: CartState) = {
    CreateOrderCommand(
      orderId = cartState.cartId,
      customerId = cartState.customerId,
      orderedUtc = cartState.checkedOutUtc,
      orderItems = cartState.lineItems.map(lineItem =>
        OrderItem(
          skuId = lineItem.skuId,
          skuName = lineItem.skuName,
          quantity = lineItem.quantity
        )
      )
    )
  }
}
