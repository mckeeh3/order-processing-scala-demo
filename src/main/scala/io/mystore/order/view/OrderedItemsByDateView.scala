package io.mystore.order.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.order.entity.OrderItemState
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderedItemsByDateView(context: ViewContext) extends AbstractOrderedItemsByDateView {

  override def emptyState: OrderedItem =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onOrdered(
    state: OrderedItem, orderItemState: OrderItemState): UpdateEffect[OrderedItem] =
    throw new UnsupportedOperationException("Update handler for 'OnOrdered' not implemented yet")

  override def ignoreOtherEvents(
    state: OrderedItem, any: ScalaPbAny): UpdateEffect[OrderedItem] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
