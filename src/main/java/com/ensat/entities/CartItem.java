//package com.ensat.entities;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//import javax.persistence.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Data
//public class CartItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = " cartItemID")
//    private Integer cartItemId;
//
//    @ManyToOne(targetEntity = Product.class)
//    @JoinColumn(name = "pID", referencedColumnName = "pID")
//    private Product product;
//
//    @ManyToOne(targetEntity = Cart.class)
//    @JoinColumn(name = "cartID", referencedColumnName = "cartID")
//    @JsonBackReference("cart_cart_item")
//    private Cart cart;
//
//    @Column(name = "amount")
//    private Integer amount;
//}
