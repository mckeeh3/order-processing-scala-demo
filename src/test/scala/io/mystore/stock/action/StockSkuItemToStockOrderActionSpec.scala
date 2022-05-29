package io.mystore.stock.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.stock.entity.OrderRequestedJoinToStockAccepted
import io.mystore.stock.entity.OrderRequestedJoinToStockRejected
import io.mystore.stock.entity.StockRequestedJoinToOrderAccepted
import io.mystore.stock.entity.StockRequestedJoinToOrderRejected
import kalix.scalasdk.action.Action
import kalix.scalasdk.testkit.ActionResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class StockSkuItemToStockOrderActionSpec
    extends AnyWordSpec
    with Matchers {

  "StockSkuItemToStockOrderAction" must {

    "have example test that can be removed" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
      pending
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = service.someOperation(SomeRequest)
      // verify the reply
      // result.reply shouldBe expectedReply
    }

    "handle command OnOrderRequestedJoinToStockAccepted" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
          pending
      // val result = service.onOrderRequestedJoinToStockAccepted(OrderRequestedJoinToStockAccepted(...))
    }

    "handle command OnOrderRequestedJoinToStockRejected" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
          pending
      // val result = service.onOrderRequestedJoinToStockRejected(OrderRequestedJoinToStockRejected(...))
    }

    "handle command OnStockRequestedJoinToOrderAccepted" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
          pending
      // val result = service.onStockRequestedJoinToOrderAccepted(StockRequestedJoinToOrderAccepted(...))
    }

    "handle command OnStockRequestedJoinToOrderRejected" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
          pending
      // val result = service.onStockRequestedJoinToOrderRejected(StockRequestedJoinToOrderRejected(...))
    }

    "handle command IgnoreOtherEvents" in {
      val service = StockSkuItemToStockOrderActionTestKit(new StockSkuItemToStockOrderAction(_))
          pending
      // val result = service.ignoreOtherEvents(ScalaPbAny(...))
    }

  }
}
