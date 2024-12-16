package com.ensat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uID;

    private String user;

    private String pass;

    private String name;
    private String phone;

    private String address;
    private String gmail;
    @ManyToOne
    @JoinColumn(name = "rID")
    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setrID(Integer rID) {
        this.role.setrID(rID);
    }

    public Role getrID() {
        return role;
    }

}
