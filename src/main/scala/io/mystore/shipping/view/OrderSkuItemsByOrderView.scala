package io.mystore.shipping.view

import com.google.protobuf.any.{ Any => ScalaPbAny }
import io.mystore.shipping.entity.BackOrderedOrderSkuItem
import io.mystore.shipping.entity.OrderRequestedJoinToStockAccepted
import io.mystore.shipping.entity.OrderRequestedJoinToStockRejected
import io.mystore.shipping.entity.OrderSkuItemCreated
import io.mystore.shipping.entity.StockRequestedJoinToOrderAccepted
import io.mystore.shipping.entity.StockRequestedJoinToOrderRejected
import kalix.scalasdk.view.View.UpdateEffect
import kalix.scalasdk.view.ViewContext

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderSkuItemsByOrderView(context: ViewContext) extends AbstractOrderSkuItemsByOrderView {

  override def emptyState: OrderSkuItemRow =
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty view state")

  override def onOrderSkuItemCreated(
    state: OrderSkuItemRow, orderSkuItemCreated: OrderSkuItemCreated): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderSkuItemCreated' not implemented yet")

  override def onStockRequestedJoinToOrderAccepted(
    state: OrderSkuItemRow, stockRequestedJoinToOrderAccepted: StockRequestedJoinToOrderAccepted): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnStockRequestedJoinToOrderAccepted' not implemented yet")

  override def onStockRequestedJoinToOrderRejected(
    state: OrderSkuItemRow, stockRequestedJoinToOrderRejected: StockRequestedJoinToOrderRejected): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnStockRequestedJoinToOrderRejected' not implemented yet")

  override def onOrderRequestedJoinToStockAccepted(
    state: OrderSkuItemRow, orderRequestedJoinToStockAccepted: OrderRequestedJoinToStockAccepted): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderRequestedJoinToStockAccepted' not implemented yet")

  override def onOrderRequestedJoinToStockRejected(
    state: OrderSkuItemRow, orderRequestedJoinToStockRejected: OrderRequestedJoinToStockRejected): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnOrderRequestedJoinToStockRejected' not implemented yet")

  override def onBackOrderedOrderSkuItem(
    state: OrderSkuItemRow, backOrderedOrderSkuItem: BackOrderedOrderSkuItem): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'OnBackOrderedOrderSkuItem' not implemented yet")

  override def ignoreOtherEvents(
    state: OrderSkuItemRow, any: ScalaPbAny): UpdateEffect[OrderSkuItemRow] =
    throw new UnsupportedOperationException("Update handler for 'IgnoreOtherEvents' not implemented yet")
}
