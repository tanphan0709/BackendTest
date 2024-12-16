package com.ensat.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private Integer rID;
    private String roleName;

    public Integer getrID() {
        return rID;
    }

    public void setrID(Integer rID) {
        this.rID = rID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
