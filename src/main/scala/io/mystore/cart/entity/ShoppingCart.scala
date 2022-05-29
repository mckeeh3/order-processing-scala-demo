package io.mystore.cart.entity

import com.google.protobuf.empty.Empty
import io.mystore.TimeTo
import io.mystore.cart.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.eventsourcedentity.EventSourcedEntityContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShoppingCart(context: EventSourcedEntityContext) extends AbstractShoppingCart {
  private val log = org.slf4j.LoggerFactory.getLogger(classOf[ShoppingCart])

  override def emptyState: CartState = CartState()

  override def addItem(state: CartState, command: api.AddLineItemCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def changeItem(state: CartState, command: api.ChangeLineItemCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def removeItem(state: CartState, command: api.RemoveLineItemCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def checkoutCart(state: CartState, command: api.CheckoutShoppingCartCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def deleteCart(state: CartState, command: api.DeleteShoppingCartCommand): EventSourcedEntity.Effect[Empty] =
    reject(state, command).getOrElse(handle(state, command))

  override def getCart(state: CartState, request: api.GetShoppingCartRequest): EventSourcedEntity.Effect[api.ShoppingCart] =
    handle(state, request)

  override def itemAdded(state: CartState, event: ItemAdded): CartState =
    updateState(state, event)

  override def itemChanged(state: CartState, event: ItemChanged): CartState =
    updateState(state, event)

  override def itemRemoved(state: CartState, event: ItemRemoved): CartState =
    updateState(state, event)

  override def cartCheckedOut(state: CartState, event: CartCheckedOut): CartState =
    updateState(state, event)

  override def cartDeleted(state: CartState, event: CartDeleted): CartState =
    updateState(state, event)

  private def reject(state: CartState, command: api.AddLineItemCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    if (state.checkedOutUtc.isDefined) {
      Some(effects.error("The cart is already checked out"))
    } else if (state.deletedUtc.isDefined) {
      Some(effects.error("The cart has been deleted"))
    } else if (command.cartId.isEmpty()) {
      Some(effects.error("The cart id is required"))
    } else if (command.skuId.isEmpty()) {
      Some(effects.error("The sku id is required"))
    } else if (command.skuName.isEmpty()) {
      Some(effects.error("The sku name is required"))
    } else if (command.quantity <= 0) {
      Some(effects.error("Quantity must be greater than 0"))
    } else {
      None
    }
  }

  private def reject(state: CartState, command: api.ChangeLineItemCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    if (state.checkedOutUtc.isDefined) {
      Some(effects.error("The cart is already checked out"))
    } else if (state.deletedUtc.isDefined) {
      Some(effects.error("The cart has been deleted"))
    } else if (command.cartId.isEmpty()) {
      Some(effects.error("The cart id is required"))
    } else if (command.skuId.isEmpty()) {
      Some(effects.error("The sku id is required"))
    } else if (command.quantity <= 0) {
      Some(effects.error("Quantity must be greater than 0"))
    } else {
      None
    }
  }

  private def reject(state: CartState, command: api.RemoveLineItemCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    if (state.checkedOutUtc.isDefined) {
      Some(effects.error("The cart is already checked out"))
    } else if (state.deletedUtc.isDefined) {
      Some(effects.error("The cart has been deleted"))
    } else if (command.cartId.isEmpty()) {
      Some(effects.error("The cart id is required"))
    } else if (command.skuId.isEmpty()) {
      Some(effects.error("The sku id is required"))
    } else {
      None
    }
  }

  private def reject(state: CartState, command: api.CheckoutShoppingCartCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    if (state.checkedOutUtc.isDefined) {
      Some(effects.error("The cart is already checked out"))
    } else if (state.deletedUtc.isDefined) {
      Some(effects.error("The cart has been deleted"))
    } else if (command.cartId.isEmpty()) {
      Some(effects.error("The cart id is required"))
    } else {
      None
    }
  }

  private def reject(state: CartState, command: api.DeleteShoppingCartCommand): Option[EventSourcedEntity.Effect[Empty]] = {
    if (state.checkedOutUtc.isDefined) {
      Some(effects.error("The cart is already checked out"))
    } else if (state.deletedUtc.isDefined) {
      Some(effects.error("The cart has been deleted"))
    } else if (command.cartId.isEmpty()) {
      Some(effects.error("The cart id is required"))
    } else {
      None
    }
  }

  private def handle(state: CartState, command: api.AddLineItemCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nAddLineItemCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: CartState, command: api.ChangeLineItemCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nChangeLineItemCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: CartState, command: api.RemoveLineItemCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nRemoveLineItemCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: CartState, command: api.CheckoutShoppingCartCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nCheckoutShoppingCartCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: CartState, command: api.DeleteShoppingCartCommand): EventSourcedEntity.Effect[Empty] = {
    log.info("state: {}\nDeleteShoppingCartCommand: {}", state, command)

    effects
      .emitEvent(eventFor(state, command))
      .thenReply(_ => Empty.defaultInstance)
  }

  private def handle(state: CartState, request: api.GetShoppingCartRequest): EventSourcedEntity.Effect[api.ShoppingCart] = {
    effects.reply(toApi(state))
  }

  private def updateState(state: CartState, event: ItemAdded): CartState = {
    state
      .copy(cartId = event.cartId, customerId = event.customerId)
      .withLineItems(updateLineItems(state, event))
  }

  private def updateState(state: CartState, event: ItemChanged): CartState = {
    state
      .copy(cartId = event.cartId)
      .withLineItems(updateLineItems(state, event))
  }

  private def updateState(state: CartState, event: ItemRemoved): CartState = {
    state
      .copy(cartId = event.cartId)
      .withLineItems(updateLineItems(state, event))
  }

  private def updateState(state: CartState, event: CartCheckedOut): CartState = {
    state
      .copy(checkedOutUtc = Some(TimeTo.now()))
  }

  private def updateState(state: CartState, event: CartDeleted): CartState = {
    state
      .copy(deletedUtc = Some(TimeTo.now()))
  }

  private def eventFor(state: CartState, command: api.AddLineItemCommand): ItemAdded = {
    ItemAdded(
      cartId = command.cartId,
      customerId = command.customerId,
      lineItem = Some(LineItem(
        skuId = command.skuId,
        skuName = command.skuName,
        quantity = command.quantity
      ))
    )
  }

  private def eventFor(state: CartState, command: api.ChangeLineItemCommand): ItemChanged = {
    ItemChanged(
      cartId = command.cartId,
      skuId = command.skuId,
      quantity = command.quantity
    )
  }

  private def eventFor(state: CartState, command: api.RemoveLineItemCommand): ItemRemoved = {
    ItemRemoved(
      cartId = command.cartId,
      skuId = command.skuId
    )
  }

  private def eventFor(state: CartState, command: api.CheckoutShoppingCartCommand): CartCheckedOut = {
    CartCheckedOut(
      cartState = Some(state)
    )
  }

  private def eventFor(state: CartState, command: api.DeleteShoppingCartCommand): CartDeleted = {
    CartDeleted(
      cartId = command.cartId
    )
  }

  private def updateLineItems(state: CartState, event: ItemAdded): Seq[LineItem] = {
    val lineItem = event.lineItem.get
    val lineItems = state.lineItems
    if (lineItems.exists(li => li.skuId == lineItem.skuId))
      lineItems.map(li => if (li.skuId == lineItem.skuId) li.copy(quantity = li.quantity + lineItem.quantity) else li)
    else
      lineItems :+ lineItem
  }

  private def updateLineItems(state: CartState, event: ItemChanged): Seq[LineItem] = {
    val lineItems = state.lineItems
    if (lineItems.exists(li => li.skuId == event.skuId))
      lineItems.map(li => if (li.skuId == event.skuId) li.copy(quantity = event.quantity) else li)
    else
      lineItems
  }

  private def updateLineItems(state: CartState, event: ItemRemoved): Seq[LineItem] = {
    state.lineItems.filterNot(li => li.skuId == event.skuId)
  }

  private def toApi(state: CartState): api.ShoppingCart = {
    api.ShoppingCart(
      cartId = state.cartId,
      customerId = state.customerId,
      lineItems = state.lineItems.map(item => api.LineItem(
        skuId = item.skuId,
        skuName = item.skuName,
        quantity = item.quantity
      )),
      checkedOutUtc = state.checkedOutUtc,
      deletedUtc = state.deletedUtc
    )
  }
}
