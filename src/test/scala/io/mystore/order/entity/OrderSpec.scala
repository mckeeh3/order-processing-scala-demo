package io.mystore.order.entity

import io.mystore.order.api
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import io.mystore.TimeTo

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderSpec extends AnyWordSpec with Matchers {
  "The Order" should {
    // "have example test that can be removed" in {
    // val testKit = OrderTestKit(new Order(_))
    // pending
    // use the testkit to execute a command:
    // val result: EventSourcedResult[R] = testKit.someOperation(SomeRequest("id"));
    // verify the emitted events
    // val actualEvent: ExpectedEvent = result.nextEventOfType[ExpectedEvent]
    // actualEvent shouldBe expectedEvent
    // verify the final state after applying the events
    // testKit.state() shouldBe expectedState
    // verify the reply
    // result.reply shouldBe expectedReply
    // verify the final state after the command
    // }

    "correctly process commands of type CreateOrder" in {
      val testKit = OrderTestKit(new Order(_))
      val result = testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      assert(result.isReply)

      val state = testKit.currentState
      assert(state.orderId == "order-1")
      assert(state.customerId == "customer-1")
      assert(state.orderedUtc.isDefined)
      assert(state.orderItems.size == 1)
      assert(state.orderItems.head.skuId == "sku-1")
      assert(state.orderItems.head.skuName == "sku-name-1")
      assert(state.orderItems.head.quantity == 1)
    }

    "correctly process commands of type ShippedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      val result = testKit.shippedOrder(
        api.ShippedOrderCommand(
          orderId = "order-1",
          shippedUtc = TimeTo.now()
        )
      )
      assert(result.isReply)

      val state = testKit.currentState
      assert(state.shippedUtc.isDefined)
    }

    "correctly process commands of type ReleasedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      testKit.shippedOrder(
        api.ShippedOrderCommand(
          orderId = "order-1",
          shippedUtc = TimeTo.now()
        )
      )
      val result = testKit.releasedOrder(
        api.ReleasedOrderCommand(
          orderId = "order-1"
        )
      )
      assert(result.isReply)

      val state = testKit.currentState
      assert(state.shippedUtc.isEmpty)
    }

    "correctly process commands of type ShippedOrderItem" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            ),
            api.OrderItem(
              skuId = "sku-2",
              skuName = "sku-name-2",
              quantity = 2
            ),
            api.OrderItem(
              skuId = "sku-3",
              skuName = "sku-name-3",
              quantity = 3
            )
          )
        )
      )
      val result = testKit.shippedOrderItem(
        api.ShippedAllOrderSkusCommand(
          orderId = "order-1",
          skuId = "sku-2",
          shippedUtc = TimeTo.now()
        )
      )
      assert(result.isReply)

      val state = testKit.currentState
      assert(state.orderItems.size == 3)
      state.orderItems.foreach { item =>
        if (item.skuId == "sku-2") {
          assert(item.shippedUtc.isDefined)
        } else {
          assert(item.shippedUtc.isEmpty)
        }
      }
      state.orderItems.filter(_.skuId == "sku-2").head.shippedUtc.isDefined shouldBe true
    }

    "correctly process commands of type ReleasedOrderItem" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            ),
            api.OrderItem(
              skuId = "sku-2",
              skuName = "sku-name-2",
              quantity = 2
            ),
            api.OrderItem(
              skuId = "sku-3",
              skuName = "sku-name-3",
              quantity = 3
            )
          )
        )
      )
      testKit.shippedOrderItem(
        api.ShippedAllOrderSkusCommand(
          orderId = "order-1",
          skuId = "sku-2",
          shippedUtc = TimeTo.now()
        )
      )
      val result = testKit.releasedOrderItem(
        api.ReleasedOrderItemCommand(
          orderId = "order-1",
          skuId = "sku-2"
        )
      )
      assert(result.isReply)
      val state = testKit.currentState
      assert(state.orderItems.size == 3)
      assert(3 == state.orderItems.count(item => item.shippedUtc.isEmpty || item.shippedUtc.get.seconds == 0))
    }

    "correctly process commands of type DeliveredOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      val result = testKit.deliveredOrder(
        api.DeliveredOrderCommand(
          orderId = "order-1"
        )
      )
      assert(!result.isReply)
    }

    "correctly process commands of type ReturnedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      val result = testKit.returnedOrder(
        api.ReturnedOrderCommand(
          orderId = "order-1"
        )
      )
      assert(!result.isReply)

      testKit.shippedOrder(
        api.ShippedOrderCommand(
          orderId = "order-1",
          shippedUtc = TimeTo.now()
        )
      )
      testKit.deliveredOrder(
        api.DeliveredOrderCommand(
          orderId = "order-1"
        )
      )
      val result2 = testKit.returnedOrder(
        api.ReturnedOrderCommand(
          orderId = "order-1"
        )
      )
      assert(result2.isReply)
      val state = testKit.currentState
      assert(state.returnedUtc.isDefined)
    }

    "correctly process commands of type CanceledOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            )
          )
        )
      )
      val result = testKit.canceledOrder(
        api.CanceledOrderCommand(
          orderId = "order-1"
        )
      )
      assert(!result.isReply)

      testKit.shippedOrder(
        api.ShippedOrderCommand(
          orderId = "order-1",
          shippedUtc = TimeTo.now()
        )
      )
      val result2 = testKit.canceledOrder(
        api.CanceledOrderCommand(
          orderId = "order-1"
        )
      )
      assert(result2.isReply)
      val state = testKit.currentState
      assert(state.canceledUtc.isDefined)
    }

    "correctly process commands of type GetOrder" in {
      val testKit = OrderTestKit(new Order(_))
      testKit.createOrder(
        api.CreateOrderCommand(
          orderId = "order-1",
          customerId = "customer-1",
          orderedUtc = TimeTo.now(),
          orderItems = Seq(
            api.OrderItem(
              skuId = "sku-1",
              skuName = "sku-name-1",
              quantity = 1
            ),
            api.OrderItem(
              skuId = "sku-2",
              skuName = "sku-name-2",
              quantity = 2
            )
          )
        )
      )
      val result = testKit.getOrder(
        api.GetOrderRequest(
          orderId = "order-1"
        )
      )
      assert(result.isReply)
      val response = result.reply
      assert(response.orderId == "order-1")
      assert(response.customerId == "customer-1")
      assert(response.orderedUtc.isDefined)
      assert(response.orderItems.size == 2)
      assert(response.orderItems.head.skuId == "sku-1")
      assert(response.orderItems.head.skuName == "sku-name-1")
      assert(response.orderItems.head.quantity == 1)
      assert(response.orderItems.last.skuId == "sku-2")
      assert(response.orderItems.last.skuName == "sku-name-2")
      assert(response.orderItems.last.quantity == 2)
    }
  }
}
