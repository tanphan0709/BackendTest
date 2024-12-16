//package com.ensat.services;
//
//import com.ensat.entities.Cart;
//import com.ensat.entities.CartItem;
//import com.ensat.entities.Product;
//import com.ensat.repositories.CartItemRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//
//@Service
//public class CartItemService {
//    @Autowired
//    private CartItemRepository cartItemRepository;
//
//    public List<CartItem> getAllCartItems() {
//        return cartItemRepository.findAll();
//    }
//
//    public CartItem getCartItemById(Integer cartItemID) {
//        CartItem cartItem = cartItemRepository.findById(cartItemID).orElse(null);
//        if (cartItem == null) {
//            System.out.println("Không tìm khấy sản phẩm trong giỏ");
//        }
//        return cartItem;
//    }
//
//    public CartItem saveCartItem(CartItem cartItem) {
//        return cartItemRepository.save(cartItem);
//    }
//
//    public void deleteCartItemById(Integer cartItemID) {
//        cartItemRepository.deleteById(cartItemID);
//    }
//    public CartItemService(CartItemRepository cartItemRepository) {
//        this.cartItemRepository = cartItemRepository;
//    }
//
//    public CartItem createOrUpdateCartItem(CartItem cartItem) {
//        return cartItemRepository.save(cartItem);
//    }
////    public int save(int amount, Integer cartId, Integer pID) {
////        return cartItemRepository.save(amount, cartId, pID);
////    }
////    public int update(Integer cartItemID, int amount) {
////        return cartItemRepository.update(cartItemID, amount);
//    }
//}
