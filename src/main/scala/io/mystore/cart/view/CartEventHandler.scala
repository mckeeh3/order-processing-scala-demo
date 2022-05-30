package io.mystore.cart.view

import io.mystore.cart.entity.ItemAdded
import io.mystore.cart.entity.ItemChanged
import io.mystore.cart.entity.ItemRemoved
import io.mystore.cart.entity.CartCheckedOut
import io.mystore.cart.entity.CartDeleted

object CartEventHandler {
  def handle(state: Cart, event: ItemAdded): Cart = {
    state
      .copy(
        cartId = event.cartId,
        customerId = event.customerId
      )
      .withLineItems(updateLineItems(state, event))
  }

  def handle(state: Cart, event: ItemChanged): Cart = {
    state
      .copy(
        cartId = event.cartId
      )
      .withLineItems(updateLineItems(state, event))
  }

  def handle(state: Cart, event: ItemRemoved): Cart = {
    state
      .copy(
        cartId = event.cartId
      )
      .withLineItems(updateLineItems(state, event))
  }

  def handle(state: Cart, event: CartCheckedOut) = {
    state
      .copy(
        checkedOutUtc = event.cartState.get.checkedOutUtc
      )
  }

  def handle(state: Cart, event: CartDeleted) = {
    state
      .copy(
        deletedUtc = event.deletedUtc
      )
  }

  private def updateLineItems(state: Cart, event: ItemAdded): Seq[LineItem] = {
    val lineItem = event.lineItem.get
    val lineItems = state.lineItems
    if (lineItems.exists(li => li.skuId == lineItem.skuId))
      lineItems.map(li => if (li.skuId == lineItem.skuId) li.copy(quantity = li.quantity + lineItem.quantity) else li)
    else
      lineItems :+ LineItem(
        skuId = lineItem.skuId,
        skuName = lineItem.skuName,
        quantity = lineItem.quantity
      )
  }

  private def updateLineItems(state: Cart, event: ItemChanged): Seq[LineItem] = {
    val lineItems = state.lineItems
    if (lineItems.exists(li => li.skuId == event.skuId))
      lineItems.map(li => if (li.skuId == event.skuId) li.copy(quantity = event.quantity) else li)
    else
      lineItems
  }

  private def updateLineItems(state: Cart, event: ItemRemoved): Seq[LineItem] = {
    state.lineItems.filterNot(li => li.skuId == event.skuId)
  }
}
