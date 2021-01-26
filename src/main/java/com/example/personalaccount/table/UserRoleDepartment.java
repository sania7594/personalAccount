package com.example.personalaccount.table;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_role_department")
public class UserRoleDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long urdId;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private UserLK userLK;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="role_id")
    private Role roleUser;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="department_id")
    private Department department;

    public UserRoleDepartment(UserLK userLK, Role role, Department department) {
        this.userLK = userLK;
        this.roleUser = role;
        this.department = department;
    }

    public UserRoleDepartment() {

    }

    public UserLK getUserLK() {
        return userLK;
    }

    public void setUserLK(UserLK userLK) {
        this.userLK = userLK;
    }

    public Role getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role roleUser) {
        this.roleUser = roleUser;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
