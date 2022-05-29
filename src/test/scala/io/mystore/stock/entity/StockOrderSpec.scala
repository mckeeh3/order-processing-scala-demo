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

class StockOrderSpec extends AnyWordSpec with Matchers {
  "The StockOrder" should {
    "have example test that can be removed" in {
      val testKit = StockOrderTestKit(new StockOrder(_))
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

    "correctly process commands of type CreateStockOrder" in {
      val testKit = StockOrderTestKit(new StockOrder(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.createStockOrder(api.CreateStockOrderCommand(...))
    }

    "correctly process commands of type ShippedStockSkuItem" in {
      val testKit = StockOrderTestKit(new StockOrder(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.shippedStockSkuItem(api.ShippedStockSkuItemToStockOrderCommand(...))
    }

    "correctly process commands of type ReleaseStockSkuItem" in {
      val testKit = StockOrderTestKit(new StockOrder(_))
      pending
      // val result: EventSourcedResult[Empty] = testKit.releaseStockSkuItem(api.ReleaseStockSkuItemFromStockOrderCommand(...))
    }

    "correctly process commands of type GetStockOrder" in {
      val testKit = StockOrderTestKit(new StockOrder(_))
      pending
      // val result: EventSourcedResult[api.StockOrder] = testKit.getStockOrder(api.GetStockOrderRequest(...))
    }
  }
}
