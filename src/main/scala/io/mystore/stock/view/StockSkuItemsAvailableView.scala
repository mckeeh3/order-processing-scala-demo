package io.mystore.stock.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.stock.entity.OrderRequestedJoinToStockAccepted
import io.mystore.stock.entity.OrderRequestedJoinToStockRejected
import io.mystore.stock.entity.StockRequestedJoinToOrderAccepted
import io.mystore.stock.entity.StockRequestedJoinToOrderRejected
import io.mystore.stock.entity.StockSkuItemCreated
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockSkuItemsAvailableView(context: ViewContext) extends AbstractStockSkuItemsAvailableView {

  override def emptyState: StockSkuItem =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onStockSkuItemCreated(
    state: StockSkuItem, stockSkuItemCreated: StockSkuItemCreated): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'OnStockSkuItemCreated' not implemented yet")

  override def onOrderRequestedJoinToStockAccepted(
    state: StockSkuItem, orderRequestedJoinToStockAccepted: OrderRequestedJoinToStockAccepted): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderRequestedJoinToStockAccepted' not implemented yet")

  override def onOrderRequestedJoinToStockRejected(
    state: StockSkuItem, orderRequestedJoinToStockRejected: OrderRequestedJoinToStockRejected): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderRequestedJoinToStockRejected' not implemented yet")

  override def onStockRequestedJoinToOrderAccepted(
    state: StockSkuItem, stockRequestedJoinToOrderAccepted: StockRequestedJoinToOrderAccepted): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'OnStockRequestedJoinToOrderAccepted' not implemented yet")

  override def onStockRequestedJoinToOrderRejected(
    state: StockSkuItem, stockRequestedJoinToOrderRejected: StockRequestedJoinToOrderRejected): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'OnStockRequestedJoinToOrderRejected' not implemented yet")

  override def ignoreOtherEvents(
    state: StockSkuItem, any: ScalaPbAny): UpdateEffect[StockSkuItem] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
