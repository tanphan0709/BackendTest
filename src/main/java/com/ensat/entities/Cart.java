//package com.ensat.entities;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Data
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer cartId;
//    @OneToOne
//    @JoinColumn(name = "uID")
//    @JsonIgnore
//    private Account account;
//    private Double totalPrice;
//    @OneToMany(mappedBy = "cart")
//    private List<CartItem> cartItems;
//}
