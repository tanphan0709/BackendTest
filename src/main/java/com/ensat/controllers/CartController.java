//package com.ensat.controllers;
//
//import com.ensat.entities.Account;
//import com.ensat.entities.Cart;
//import com.ensat.entities.CartItem;
//import com.ensat.services.CartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.math.BigDecimal;
//
//@RestController
//@RequestMapping("/cart") // http://localhost:8083/cart
//public class CartController {
//
//    @Autowired
//    private CartService cartService;
//
//    @PostMapping("/")
//    public ResponseEntity<Cart> createCart(HttpServletRequest request, @RequestBody Account account) {
//        Cart cart = cartService.createCart(account);
//        HttpSession session = request.getSession();
//        session.setAttribute("cartId", cart.getCartId());
//        return ResponseEntity.ok(cart);
//    }
//
//    @GetMapping("/")
//    public ResponseEntity<Cart> getCart(HttpServletRequest request) {
//        Cart cart = cartService.getCart(request);
//        if (cart == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(cart);
//    }
//
//    @PostMapping("/addCartItem")
//    public ResponseEntity<CartItem> addCartItem(HttpServletRequest request, @RequestParam Integer pID, @RequestParam int amount, @RequestParam Integer cartId) {
//        CartItem cartItem = cartService.addCartItem(request, pID, amount, cartId);
//        if (cartItem == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(cartItem);
//    }
//
//
//    @PutMapping("/updateCartItem/{cartItemId}")
//    public ResponseEntity<?> updateCartItem(HttpServletRequest request, @PathVariable Integer cartItemId, @RequestParam int amount) {
//        cartService.updateCartItem(request, cartItemId, amount);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/delete/{cartItemId}")
//    public ResponseEntity<?> deleteCartItem(HttpServletRequest request, @PathVariable Integer cartItemId) {
//        cartService.deleteCartItem(request, cartItemId);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/totalPrice")
//    public ResponseEntity<BigDecimal> calculateTotalPrice(HttpServletRequest request) {
//        BigDecimal totalPrice = cartService.calculateTotalPrice(request);
//        return ResponseEntity.ok(totalPrice);
//    }
//
//}
//
