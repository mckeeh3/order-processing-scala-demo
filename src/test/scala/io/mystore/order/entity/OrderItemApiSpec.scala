package io.mystore.order.entity

import io.mystore.order.api
import io.mystore.TimeTo
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OrderItemApiSpec extends AnyWordSpec with Matchers {

  "OrderItemApi" should {

    // "have example test that can be removed" in {
    // val service = OrderItemApiTestKit(new OrderItemApi(_))
    // pending
    // use the testkit to execute a command
    // and verify final updated state:
    // val result = service.someOperation(SomeRequest)
    // verify the reply
    // val reply = result.getReply()
    // reply shouldBe expectedReply
    // verify the final state after the command
    // service.currentState() shouldBe expectedState
    // }

    "handle command CreateOrderItem" in {
      val testKit = OrderItemApiTestKit(new OrderItemApi(_))
      val result = testKit.createOrderItem(
        api.CreateOrderItemCommand(
          customerId = "customer-1",
          orderId = "cart-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1,
          orderedUtc = TimeTo.now()
        )
      )
      assert(result.isReply)

      val state = testKit.currentState()
      assert(state.customerId == "customer-1")
      assert(state.orderId == "cart-1")
      assert(state.skuId == "sku-1")
      assert(state.skuName == "sku-name-1")
      assert(state.quantity == 1)
      assert(state.orderedUtc.isDefined)
      assert(state.shippedUtc.isEmpty)
    }

    "handle command ShippedOrderItem" in {
      val testKit = OrderItemApiTestKit(new OrderItemApi(_))
      testKit.createOrderItem(
        api.CreateOrderItemCommand(
          customerId = "customer-1",
          orderId = "cart-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1,
          orderedUtc = TimeTo.now()
        )
      )
      val result = testKit.shippedOrderItem(
        api.ShippedOrderItemCommand(
          orderId = "cart-1",
          skuId = "sku-1",
          shippedUtc = TimeTo.now()
        )
      )
      assert(result.isReply)

      val state = testKit.currentState()
      assert(state.customerId == "customer-1")
      assert(state.orderId == "cart-1")
      assert(state.skuId == "sku-1")
      assert(state.skuName == "sku-name-1")
      assert(state.quantity == 1)
      assert(state.orderedUtc.isDefined)
      assert(state.shippedUtc.isDefined)
    }

    "handle command GetOrderItem" in {
      val testKit = OrderItemApiTestKit(new OrderItemApi(_))
      testKit.createOrderItem(
        api.CreateOrderItemCommand(
          customerId = "customer-1",
          orderId = "cart-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1,
          orderedUtc = TimeTo.now()
        )
      )
      val result = testKit.getOrderItem(
        api.GetOrderItemRequest(
          orderId = "order-1",
          skuId = "sku-1"
        )
      )
      val response = result.reply
      assert(response.customerId == "customer-1")
      assert(response.skuId == "sku-1")
      assert(response.skuName == "sku-name-1")
      assert(response.quantity == 1)
      assert(response.orderedUtc.isDefined)
      assert(response.shippedUtc.isEmpty)
    }
  }
}
