package io.mystore.stock.entity

import com.google.protobuf.empty.Empty
import io.mystore.stock.api
import kalix.scalasdk.eventsourcedentity.EventSourcedEntity
import kalix.scalasdk.testkit.EventSourcedResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockSkuItemApiSpec extends AnyWordSpec with Matchers {
  "The StockSkuItemApi" should {
    "have example test that can be removed" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
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

    "correctly process commands of type CreateStockSkuItem" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createStockSkuItem(api.CreateStockSkuItemCommand(...))
    }

    "correctly process commands of type OrderRequestsJoinToStock" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.orderRequestsJoinToStock(api.OrderRequestsJoinToStockCommand(...))
    }

    "correctly process commands of type OrderRequestsJoinToStockRejected" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.orderRequestsJoinToStockRejected(api.OrderRequestsJoinToStockRejectedCommand(...))
    }

    "correctly process commands of type StockRequestedJoinToOrderAccepted" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.stockRequestedJoinToOrderAccepted(api.StockRequestedJoinToOrderAcceptedCommand(...))
    }

    "correctly process commands of type StockRequestedJoinToOrderRejected" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.stockRequestedJoinToOrderRejected(api.StockRequestedJoinToOrderRejectedCommand(...))
    }

    "correctly process commands of type GetStockSkuItem" in {
      val testKit = StockSkuItemApiTestKit(new StockSkuItemApi(_))
      pending
      // val result: EventSourcedResult[api.GetStockSKuItemResponse] = testKit.getStockSkuItem(api.GetStockSKuItemRequest(...))
    }
  }
}
