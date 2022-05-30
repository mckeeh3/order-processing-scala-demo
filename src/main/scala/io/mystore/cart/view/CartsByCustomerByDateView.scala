package io.mystore.cart.view

import io.mystore.cart.entity.CartCheckedOut
import io.mystore.cart.entity.CartDeleted
import io.mystore.cart.entity.ItemAdded
import io.mystore.cart.entity.ItemChanged
import io.mystore.cart.entity.ItemRemoved
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class CartsByCustomerByDateView(context: ViewContext) extends AbstractCartsByCustomerByDateView {

  override def emptyState: Cart = Cart.defaultInstance

  override def onItemAdded(state: Cart, event: ItemAdded): UpdateEffect[Cart] =
    effects.updateState(CartEventHandler.handle(state, event))

  override def onItemChanged(state: Cart, event: ItemChanged): UpdateEffect[Cart] =
    effects.updateState(CartEventHandler.handle(state, event))

  override def onItemRemoved(state: Cart, event: ItemRemoved): UpdateEffect[Cart] =
    effects.updateState(CartEventHandler.handle(state, event))

  override def onCartCheckedOut(state: Cart, event: CartCheckedOut): UpdateEffect[Cart] =
    effects.updateState(CartEventHandler.handle(state, event))

  override def onCartDeleted(state: Cart, event: CartDeleted): UpdateEffect[Cart] =
    effects.updateState(CartEventHandler.handle(state, event))
}
