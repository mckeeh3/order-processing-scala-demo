package io.mystore.order.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.shipping.entity.OrderItemReleased
import io.mystore.shipping.entity.OrderItemShipped
import io.mystore.shipping.entity.OrderReleased
import io.mystore.shipping.entity.OrderShipped
import kalix.scalasdk.action.Action
import kalix.scalasdk.testkit.ActionResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingToOrderActionSpec
    extends AnyWordSpec
    with Matchers {

  "ShippingToOrderAction" must {

    "have example test that can be removed" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
      pending
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = service.someOperation(SomeRequest)
      // verify the reply
      // result.reply shouldBe expectedReply
    }

    "handle command OnOrderShipped" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
          pending
      // val result = service.onOrderShipped(OrderShipped(...))
    }

    "handle command OnOrderReleased" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
          pending
      // val result = service.onOrderReleased(OrderReleased(...))
    }

    "handle command OnOrderItemShipped" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
          pending
      // val result = service.onOrderItemShipped(OrderItemShipped(...))
    }

    "handle command OnOrderItemReleased" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
          pending
      // val result = service.onOrderItemReleased(OrderItemReleased(...))
    }

    "handle command IgnoreOtherEvents" in {
      val service = ShippingToOrderActionTestKit(new ShippingToOrderAction(_))
          pending
      // val result = service.ignoreOtherEvents(ScalaPbAny(...))
    }

  }
}
