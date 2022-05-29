package io.mystore.stock.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.stock.entity.StockOrderCreated
import io.mystore.stock.entity.StockSkuItemReleased
import io.mystore.stock.entity.StockSkuItemShipped
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockOrdersAvailableView(context: ViewContext) extends AbstractStockOrdersAvailableView {

  override def emptyState: StockOrder =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onStockOrderCreated(
    state: StockOrder, stockOrderCreated: StockOrderCreated): UpdateEffect[StockOrder] =
    throw new UnsupportedOperationException("Update handler for 'OnStockOrderCreated' not implemented yet")

  override def onStockSkuItemShipped(
    state: StockOrder, stockSkuItemShipped: StockSkuItemShipped): UpdateEffect[StockOrder] =
    throw new UnsupportedOperationException("Update handler for 'OnStockSkuItemShipped' not implemented yet")

  override def onStockSkuItemReleased(
    state: StockOrder, stockSkuItemReleased: StockSkuItemReleased): UpdateEffect[StockOrder] =
    throw new UnsupportedOperationException("Update handler for 'OnStockSkuItemReleased' not implemented yet")

  override def ignoreOtherEvents(
    state: StockOrder, any: ScalaPbAny): UpdateEffect[StockOrder] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
