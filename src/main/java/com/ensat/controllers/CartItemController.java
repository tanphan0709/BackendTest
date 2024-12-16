//package com.ensat.controllers;
//
//import com.ensat.entities.CartItem;
//import com.ensat.services.CartItemService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/CartItem")
//public class CartItemController {
//
//        private final CartItemService cartItemService;
//
//        public CartItemController(CartItemService cartItemService) {
//            this.cartItemService = cartItemService;
//        }
//
//        @GetMapping("/{cartItemID}")
//        public ResponseEntity<CartItem> getCartItemById(@PathVariable Integer cartItemID) {
//            CartItem cartItem = cartItemService.getCartItemById(cartItemID);
//            if (cartItem != null) {
//                return ResponseEntity.ok(cartItem);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//
//        @PostMapping("/")
//        public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
//            CartItem newCartItem = cartItemService.createOrUpdateCartItem(cartItem);
//            return ResponseEntity.ok(newCartItem);
//        }
//
//        @PutMapping("/{cartItemID}")
//        public ResponseEntity<CartItem> updateCartItem(@PathVariable Integer cartItemID, @RequestBody CartItem cartItem) {
//            CartItem updatedCartItem = cartItemService.getCartItemById(cartItemID);
//            if (updatedCartItem != null) {
//                updatedCartItem.setAmount(cartItem.getAmount());
//                updatedCartItem.setProduct(cartItem.getProduct());
//                updatedCartItem.setCart(cartItem.getCart());
//                updatedCartItem = cartItemService.createOrUpdateCartItem(updatedCartItem);
//                return ResponseEntity.ok(updatedCartItem);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//
//        @DeleteMapping("/{cartItemID}")
//        public ResponseEntity<Void> deleteCartItem(@PathVariable Integer cartItemId) {
//            cartItemService.deleteCartItemById(cartItemId);
//            return ResponseEntity.noContent().build();
//        }
//
//    }
//
