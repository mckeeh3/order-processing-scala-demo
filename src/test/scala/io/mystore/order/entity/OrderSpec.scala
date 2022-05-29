package io.mystore.order.entity

import com.google.protobuf.empty.Empty
import io.mystore.order.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.testkit.EventSourcedResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderSpec extends AnyWordSpec with Matchers {
  "The Order" should {
    "have example test that can be removed" in {
      val testKit = OrderTestKit(new Order(_))
      pending
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
    }

    "correctly process commands of type CreateOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createOrder(api.CreateOrderCommand(...))
    }

    "correctly process commands of type ShippedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.shippedOrder(api.ShippedOrderCommand(...))
    }

    "correctly process commands of type ReleasedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.releasedOrder(api.ReleasedOrderCommand(...))
    }

    "correctly process commands of type ShippedOrderItem" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.shippedOrderItem(api.ShippedOrderSkuCommand(...))
    }

    "correctly process commands of type ReleasedOrderItem" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.releasedOrderItem(api.ReleasedOrderSkuCommand(...))
    }

    "correctly process commands of type DeliveredOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.deliveredOrder(api.DeliveredOrderCommand(...))
    }

    "correctly process commands of type ReturnedOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.returnedOrder(api.ReturnedOrderCommand(...))
    }

    "correctly process commands of type CanceledOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.canceledOrder(api.CanceledOrderCommand(...))
    }

    "correctly process commands of type GetOrder" in {
      val testKit = OrderTestKit(new Order(_))
      pending
      // val result: EventSourcedResult[api.Order] = testKit.getOrder(api.GetOrderRequest(...))
    }
  }
}
