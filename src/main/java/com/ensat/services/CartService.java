//package com.ensat.services;
//import com.ensat.entities.Account;
//import com.ensat.entities.Cart;
//import com.ensat.entities.CartItem;
//import com.ensat.entities.Product;
//import com.ensat.repositories.CartItemRepository;
//import com.ensat.repositories.CartRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class  CartService {
//
//    @Autowired
//    private CartRepository cartRepository;
//
//    @Autowired
//    private CartItemRepository cartItemRepository;
//
//    @Autowired
//    private ProductService repo;
//
//
////    public Cart createCart(Account account) {
////        Cart cart = new Cart();
////        cart.setAccount(account);
////        cart.setTotalPrice(BigDecimal.ZERO);
////        return cartRepository.save(cart);
////    }
//
//
//    public Cart getCart(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Integer cartId = (Integer) session.getAttribute("cartId");
//        if (cartId != null) {
//            Optional<Cart> optionalCart = cartRepository.findById(cartId);
//            if (optionalCart.isPresent()) {
//                return optionalCart.get();
//            }
//        }
//        return null;
//    }
//
//
//    public CartItem addCartItem(HttpServletRequest request, Integer pID, int amount, Integer cartId) {
//        Cart cart = getCart(request);
//        if (cart == null) {
//            cart = createCart(null);
//            HttpSession session = request.getSession();
//            session.setAttribute("cartId", cart.getCartId());
//        }
//        Product product = repo.getProductById(pID);
//        if (product == null) {
//            return null;
//        }
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(product);
//        cartItem.setAmount(amount);
//        cartItem.setCart(cart);
//        List<CartItem> cartItems = cart.getCartItems();
//        for (CartItem ci : cartItems) {
//            if (ci.getProduct().getPID().equals(pID)) {
//                ci.setAmount(ci.getAmount() + amount);
//                cartItemRepository.save(ci);
//                return ci;
//            }
//        }
//        cartItems.add(cartItem);
//        cart.setCartItems(cartItems);
//        cartRepository.save(cart);
//        return cartItem;
//    }
//
//
//    public void updateCartItem(HttpServletRequest request, Integer cartItemId, int amount) {
//        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
//        if (optionalCartItem.isPresent()) {
//            CartItem cartItem = optionalCartItem.get();
//            cartItem.setAmount(amount);
//            cartItemRepository.save(cartItem);
//        }
//    }
//    public void deleteCartItem(HttpServletRequest request, Integer cartItemId) {
//        Optional<CartItem> optionalCartItem = cartItemRepository.findById(cartItemId);
//        if (optionalCartItem.isPresent()) {
//            CartItem cartItem = optionalCartItem.get();
//            Cart cart = cartItem.getCart();
//            List<CartItem> cartItems = cart.getCartItems();
//            cartItems.remove(cartItem);
//            cart.setCartItems(cartItems);
//            cartRepository.save(cart);
//            cartItemRepository.delete(cartItem);
//        }
//    }
//
//    public BigDecimal calculateTotalPrice(HttpServletRequest request) {
//        Cart cart = getCart(request);
//        if (cart == null) {
//            return BigDecimal.ZERO;
//        }
//        List<CartItem> cartItems = cart.getCartItems();
//        BigDecimal totalPrice = BigDecimal.ZERO;
//        for (CartItem ci : cartItems) {
//            BigDecimal price = ci.getProduct().getPrice();
//            BigDecimal amount = new BigDecimal(ci.getAmount());
//            totalPrice = totalPrice.add(price.multiply(amount));
//        }
//        cart.setTotalPrice(totalPrice);
//        cartRepository.save(cart);
//        return totalPrice;
//    }
//}
