package io.mystore.shipping.entity

import com.google.protobuf.empty.Empty
import io.mystore.shipping.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.testkit.EventSourcedResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingSpec extends AnyWordSpec with Matchers {
  "The Shipping" should {
    "have example test that can be removed" in {
      val testKit = ShippingTestKit(new Shipping(_))
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
      val testKit = ShippingTestKit(new Shipping(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createOrder(api.CreateOrderCommand(...))
    }

    "correctly process commands of type ShippedOrderSkuItem" in {
      val testKit = ShippingTestKit(new Shipping(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.shippedOrderSkuItem(api.ShippedOrderSkuItemCommand(...))
    }

    "correctly process commands of type ReleaseOrderSkuItem" in {
      val testKit = ShippingTestKit(new Shipping(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.releaseOrderSkuItem(api.ReleaseOrderSkuItemCommand(...))
    }

    "correctly process commands of type GetOrder" in {
      val testKit = ShippingTestKit(new Shipping(_))
      pending
      // val result: EventSourcedResult[api.Order] = testKit.getOrder(api.GetOrderRequest(...))
    }
  }
}
