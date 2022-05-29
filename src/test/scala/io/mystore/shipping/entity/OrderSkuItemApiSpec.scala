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

class OrderSkuItemApiSpec extends AnyWordSpec with Matchers {
  "The OrderSkuItemApi" should {
    "have example test that can be removed" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
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

    "correctly process commands of type CreateOrderSkuItem" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createOrderSkuItem(api.CreateOrderSkuItemCommand(...))
    }

    "correctly process commands of type StockRequestsJoinToOrder" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.stockRequestsJoinToOrder(api.StockRequestsJoinToOrderCommand(...))
    }

    "correctly process commands of type StockRequestsJoinToOrderRejected" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.stockRequestsJoinToOrderRejected(api.StockRequestsJoinToOrderRejectedCommand(...))
    }

    "correctly process commands of type OrderRequestedJoinToStockAccepted" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.orderRequestedJoinToStockAccepted(api.OrderRequestedJoinToStockAcceptedCommand(...))
    }

    "correctly process commands of type OrderRequestedJoinToStockRejected" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.orderRequestedJoinToStockRejected(api.OrderRequestedJoinToStockRejectedCommand(...))
    }

    "correctly process commands of type BackOrderOrderSkuItem" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.backOrderOrderSkuItem(api.BackOrderOrderSkuItemCommand(...))
    }

    "correctly process commands of type GetOrderSkuItem" in {
      val testKit = OrderSkuItemApiTestKit(new OrderSkuItemApi(_))
      pending
      // val result: EventSourcedResult[api.GetOrderSkuItemResponse] = testKit.getOrderSkuItem(api.GetOrderSkuItemRequest(...))
    }
  }
}
