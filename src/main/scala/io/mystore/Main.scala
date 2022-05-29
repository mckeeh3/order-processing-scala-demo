package io.mystore

import io.mystore.cart.entity.ShoppingCart
import io.mystore.cart.view.CartsByCustomerByDateView
import io.mystore.cart.view.CartsByCustomerView
import io.mystore.cart.view.CartsByDateView
import io.mystore.order.action.CartToOrderAction
import io.mystore.order.action.OrderToOrderItemAction
import io.mystore.order.action.ShippingToOrderAction
import io.mystore.order.entity.Order
import io.mystore.order.entity.OrderItemApi
import io.mystore.order.view.OrderedItemsByCustomerByDateView
import io.mystore.order.view.OrderedItemsByDateView
import io.mystore.order.view.OrderedItemsBySkuByDateView
import io.mystore.order.view.OrdersByCustomerByDateView
import io.mystore.order.view.OrdersByDateView
import io.mystore.shipping.action.OrderSkuItemToShippingAction
import io.mystore.shipping.action.OrderToShippingAction
import io.mystore.shipping.action.ShippingToOrderSkuItemAction
import io.mystore.shipping.action.StockSkuItemToOrderSkuItemAction
import io.mystore.shipping.entity.OrderSkuItemApi
import io.mystore.shipping.entity.Shipping
import io.mystore.shipping.view.OrderSkuItemsBackOrderedBySkuView
import io.mystore.shipping.view.OrderSkuItemsByOrderView
import io.mystore.shipping.view.OrderSkuItemsNotShippedBySkuView
import io.mystore.shipping.view.OrderSkuItemsShippedBySkuView
import io.mystore.shipping.view.ShippingByCustomerByDateView
import io.mystore.shipping.view.ShippingByDateView
import io.mystore.stock.action.OrderSkuItemToStockSkuItemAction
import io.mystore.stock.action.StockOrderToStockSkuItemAction
import io.mystore.stock.action.StockSkuItemToStockOrderAction
import io.mystore.stock.entity.StockOrder
import io.mystore.stock.entity.StockSkuItemApi
import io.mystore.stock.view.StockOrdersAvailableView
import io.mystore.stock.view.StockOrdersShippedView
import io.mystore.stock.view.StockSkuItemsAvailableView
import io.mystore.stock.view.StockSkuItemsShippedView
import kalix.scalasdk.Kalix
import org.slf4j.LoggerFactory

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

object Main {

  private val log = LoggerFactory.getLogger("io.mystore.Main")

  def createKalix(): Kalix = {
    // The KalixFactory automatically registers any generated Actions, Views or Entities,
    // and is kept up-to-date with any changes in your protobuf definitions.
    // If you prefer, you may remove this and manually register these components in a
    // `Kalix()` instance.
    KalixFactory.withComponents(
      new Order(_),
      new OrderItemApi(_),
      new OrderSkuItemApi(_),
      new Shipping(_),
      new ShoppingCart(_),
      new StockOrder(_),
      new StockSkuItemApi(_),
      new CartToOrderAction(_),
      new CartsByCustomerView(_),
      new CartsByCustomerByDateView(_),
      new CartsByDateView(_),
      new OrderSkuItemToShippingAction(_),
      new OrderSkuItemToStockSkuItemAction(_),
      new OrderSkuItemsBackOrderedBySkuView(_),
      new OrderSkuItemsByOrderView(_),
      new OrderSkuItemsNotShippedBySkuView(_),
      new OrderSkuItemsShippedBySkuView(_),
      new OrderToOrderItemAction(_),
      new OrderToShippingAction(_),
      new OrderedItemsByCustomerByDateView(_),
      new OrderedItemsByDateView(_),
      new OrderedItemsBySkuByDateView(_),
      new OrdersByCustomerByDateView(_),
      new OrdersByDateView(_),
      new ShippingByCustomerByDateView(_),
      new ShippingByDateView(_),
      new ShippingToOrderAction(_),
      new ShippingToOrderSkuItemAction(_),
      new StockOrderToStockSkuItemAction(_),
      new StockOrdersAvailableView(_),
      new StockOrdersShippedView(_),
      new StockSkuItemToOrderSkuItemAction(_),
      new StockSkuItemToStockOrderAction(_),
      new StockSkuItemsAvailableView(_),
      new StockSkuItemsShippedView(_))
  }

  def main(args: Array[String]): Unit = {
    log.info("starting the Kalix service")
    createKalix().start()
  }
}
