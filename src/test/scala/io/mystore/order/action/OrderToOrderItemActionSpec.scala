package io.mystore.order.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.order.entity.OrderCreated
import io.mystore.order.entity.OrderItemShipped
import kalix.scalasdk.action.Action
import kalix.scalasdk.testkit.ActionResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class OrderToOrderItemActionSpec
    extends AnyWordSpec
    with Matchers {

  "OrderToOrderItemAction" must {

    "have example test that can be removed" in {
      val service = OrderToOrderItemActionTestKit(new OrderToOrderItemAction(_))
      pending
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = service.someOperation(SomeRequest)
      // verify the reply
      // result.reply shouldBe expectedReply
    }

    "handle command OnOrderCreated" in {
      val service = OrderToOrderItemActionTestKit(new OrderToOrderItemAction(_))
          pending
      // val result = service.onOrderCreated(OrderCreated(...))
    }

    "handle command OnOrderItemShipped" in {
      val service = OrderToOrderItemActionTestKit(new OrderToOrderItemAction(_))
          pending
      // val result = service.onOrderItemShipped(OrderItemShipped(...))
    }

    "handle command IgnoreOtherEvents" in {
      val service = OrderToOrderItemActionTestKit(new OrderToOrderItemAction(_))
          pending
      // val result = service.ignoreOtherEvents(ScalaPbAny(...))
    }

  }
}
