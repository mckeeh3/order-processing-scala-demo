package io.mystore.shipping.action

import com.google.protobuf.any.{ Any => ScalaPbAny }
import com.google.protobuf.empty.Empty
import io.mystore.shipping.entity.OrderCreated
import kalix.scalasdk.action.Action
import kalix.scalasdk.testkit.ActionResult
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShippingToOrderSkuItemActionSpec
    extends AnyWordSpec
    with Matchers {

  "ShippingToOrderSkuItemAction" must {

    "have example test that can be removed" in {
      val service = ShippingToOrderSkuItemActionTestKit(new ShippingToOrderSkuItemAction(_))
      pending
      // use the testkit to execute a command
      // and verify final updated state:
      // val result = service.someOperation(SomeRequest)
      // verify the reply
      // result.reply shouldBe expectedReply
    }

    "handle command OnOrderCreated" in {
      val service = ShippingToOrderSkuItemActionTestKit(new ShippingToOrderSkuItemAction(_))
          pending
      // val result = service.onOrderCreated(OrderCreated(...))
    }

    "handle command IgnoreOtherEvents" in {
      val service = ShippingToOrderSkuItemActionTestKit(new ShippingToOrderSkuItemAction(_))
          pending
      // val result = service.ignoreOtherEvents(ScalaPbAny(...))
    }

  }
}
