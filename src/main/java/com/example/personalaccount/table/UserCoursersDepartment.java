package com.example.personalaccount.table;


import javax.persistence.*;

@Entity
@Table(name="user_cour_department")
public class UserCoursersDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ucdId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private UserLK userL;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="cources_id")
    private CourcesLK courcesLK;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="department_id")
    private Department departmentL;

    public UserCoursersDepartment(UserLK userL, CourcesLK courcesLK, Department departmentL) {
        this.userL = userL;
        this.courcesLK = courcesLK;
        this.departmentL = departmentL;
    }

    public UserCoursersDepartment() {

    }

    public UserLK getUserL() {
        return userL;
    }

    public void setUserL(UserLK userL) {
        this.userL = userL;
    }

    public CourcesLK getCourcesLK() {
        return courcesLK;
    }

    public void setCourcesLK(CourcesLK courcesLK) {
        this.courcesLK = courcesLK;
    }

    public Department getDepartmentL() {
        return departmentL;
    }

    public void setDepartmentL(Department departmentL) {
        this.departmentL = departmentL;
    }
}
