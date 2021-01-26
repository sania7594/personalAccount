package com.example.personalaccount.table;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userIdR;

    @OneToMany(mappedBy="roleUser",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserRoleDepartment> role;

    @Column
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role() {

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
