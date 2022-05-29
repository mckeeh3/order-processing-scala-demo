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

  override def emptyState: Cart =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onItemAdded(
    state: Cart, itemAdded: ItemAdded): UpdateEffect[Cart] =
    throw new UnsupportedOperationException("Update handler for 'OnItemAdded' not implemented yet")

  override def onItemChanged(
    state: Cart, itemChanged: ItemChanged): UpdateEffect[Cart] =
    throw new UnsupportedOperationException("Update handler for 'OnItemChanged' not implemented yet")

  override def onItemRemoved(
    state: Cart, itemRemoved: ItemRemoved): UpdateEffect[Cart] =
    throw new UnsupportedOperationException("Update handler for 'OnItemRemoved' not implemented yet")

  override def onCartCheckedOut(
    state: Cart, cartCheckedOut: CartCheckedOut): UpdateEffect[Cart] =
    throw new UnsupportedOperationException("Update handler for 'OnCartCheckedOut' not implemented yet")

  override def onCartDeleted(
    state: Cart, cartDeleted: CartDeleted): UpdateEffect[Cart] =
    throw new UnsupportedOperationException("Update handler for 'OnCartDeleted' not implemented yet")
}
