package io.mystore.cart.entity

import io.mystore.cart.api
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

// This class was initially generated based on the .proto definition by Kalix tooling.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

class ShoppingCartSpec extends AnyWordSpec with Matchers {
  "The ShoppingCart" should {
    //"have example test that can be removed" in {
      //val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      //pending
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
    //}

    "correctly process commands of type AddItem" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      val result = testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      val event = result.nextEvent[ItemAdded]
      assert(event.cartId == "cart-1")
      assert(event.customerId == "customer-1")
      assert(event.lineItem.head.skuId == "sku-1")
      assert(event.lineItem.head.skuName == "sku-name-1")
      assert(event.lineItem.head.quantity == 1)

      val state = testKit.currentState
      assert(state.lineItems.size == 1)
      assert(state.cartId == "cart-1")
      assert(state.customerId == "customer-1")
      assert(state.lineItems.head.skuId == "sku-1")
      assert(state.lineItems.head.skuName == "sku-name-1")
      assert(state.lineItems.head.quantity == 1)
    }

    "correctly process commands of type ChangeItem" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      val result = testKit.changeItem(
        api.ChangeLineItemCommand(
          cartId = "cart-1",
          skuId = "sku-1",
          quantity = 2
        )
      )
      val event = result.nextEvent[ItemChanged]
      assert(event.cartId == "cart-1")
      assert(event.skuId == "sku-1")
      assert(event.quantity == 2)

      val state = testKit.currentState
      assert(state.lineItems.size == 1)
      assert(state.cartId == "cart-1")
      assert(state.customerId == "customer-1")
      assert(state.lineItems.head.skuId == "sku-1")
      assert(state.lineItems.head.skuName == "sku-name-1")
      assert(state.lineItems.head.quantity == 2)
    }

    "correctly process commands of type ChangeItem with multiple items" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-2",
          skuName = "sku-name-2",
          quantity = 2
        )
      )
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-3",
          skuName = "sku-name-3",
          quantity = 3
        )
      )
      testKit.changeItem(
        api.ChangeLineItemCommand(
          cartId = "cart-1",
          skuId = "sku-1",
          quantity = 10
        )
      )
      testKit.changeItem(
        api.ChangeLineItemCommand(
          cartId = "cart-1",
          skuId = "sku-2",
          quantity = 20
        )
      )
      testKit.changeItem(
        api.ChangeLineItemCommand(
          cartId = "cart-1",
          skuId = "sku-3",
          quantity = 30
        )
      )

      val state = testKit.currentState
      assert(state.lineItems.size == 3)
      assert(state.cartId == "cart-1")
      assert(state.customerId == "customer-1")
      assert(state.lineItems.head.skuId == "sku-1")
      assert(state.lineItems.head.skuName == "sku-name-1")
      assert(state.lineItems.head.quantity == 10)
      assert(state.lineItems.last.quantity == 30)
      assert(state.lineItems.map(_.quantity).sum == 60)
    }

    "correctly process commands of type RemoveItem" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-2",
          skuName = "sku-name-2",
          quantity = 2
        )
      )
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-3",
          skuName = "sku-name-3",
          quantity = 3
        )
      )
      val stateAdd = testKit.currentState
      assert(stateAdd.lineItems.size == 3)

      val result = testKit.removeItem(
        api.RemoveLineItemCommand(
          cartId = "cart-1",
          skuId = "sku-2"
        )
      )
      val event = result.nextEvent[ItemRemoved]
      assert(event.cartId == "cart-1")
      assert(event.skuId == "sku-2")

      val state = testKit.currentState
      assert(state.lineItems.size == 2)
      assert(state.cartId == "cart-1")
      assert(state.customerId == "customer-1")
      assert(state.lineItems.head.skuId == "sku-1")
      assert(state.lineItems.head.skuName == "sku-name-1")
      assert(state.lineItems.head.quantity == 1)
      assert(state.lineItems.last.skuId == "sku-3")
      assert(state.lineItems.last.skuName == "sku-name-3")
      assert(state.lineItems.last.quantity == 3)
    }

    "correctly process commands of type CheckoutCart" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      val result = testKit.checkoutCart(
        api.CheckoutShoppingCartCommand(
          cartId = "cart-1"
        )
      )
      val event = result.nextEvent[CartCheckedOut]
      val cartState = event.cartState.get
      val state = testKit.currentState
      assert(state.cartId == cartState.cartId)
      assert(state.customerId == cartState.customerId)
      assert(state.checkedOutUtc.isDefined)
      state.lineItems should equal (cartState.lineItems)
    }

    "correctly reject add item to checked out shopping cart" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      testKit.checkoutCart(
        api.CheckoutShoppingCartCommand(
          cartId = "cart-1"
        )
      )
      val result = testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-2",
          skuName = "sku-name-2",
          quantity = 2
        )
      )
      result.isError should be (true)
    }

    "correctly process commands of type DeleteCart" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      val result = testKit.deleteCart(
        api.DeleteShoppingCartCommand(
          cartId = "cart-1"
        )
      )
      result.nextEvent[CartDeleted]
      val state = testKit.currentState
      assert(state.deletedUtc.isDefined)
    }

    "correctly reject add item to deleted shopping cart" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      testKit.deleteCart(
        api.DeleteShoppingCartCommand(
          cartId = "cart-1"
        )
      )
      val result = testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-2",
          skuName = "sku-name-2",
          quantity = 2
        )
      )
      result.isError should be (true)
    }

    "correctly process commands of type GetCart" in {
      val testKit = ShoppingCartTestKit(new ShoppingCart(_))
      testKit.addItem(
        api.AddLineItemCommand(
          cartId = "cart-1",
          customerId = "customer-1",
          skuId = "sku-1",
          skuName = "sku-name-1",
          quantity = 1
        )
      )
      testKit.checkoutCart(
        api.CheckoutShoppingCartCommand(
          cartId = "cart-1"
        )
      )
      val result = testKit.getCart(
        api.GetShoppingCartRequest(
          cartId = "cart-1"
        )
      )
      val response = result.reply
      assert(response.cartId == "cart-1")
      assert(response.customerId == "customer-1")
      assert(response.lineItems.size == 1)
      assert(response.lineItems.head.skuId == "sku-1")
      assert(response.lineItems.head.skuName == "sku-name-1")
      assert(response.lineItems.head.quantity == 1)
      assert(response.checkedOutUtc.isDefined)
      assert(response.deletedUtc.isEmpty)
    }
  }
}
