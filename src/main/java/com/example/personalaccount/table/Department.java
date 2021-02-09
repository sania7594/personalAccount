package com.example.personalaccount.table;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserRoleDepartment> userRoleDepartments;

    @Column()
    @NotEmpty(message = "Please your department name")
    private String departmentName;

    //parent
    @ManyToOne(fetch = FetchType.LAZY)
    private Department parent;

    @OneToMany(mappedBy = "parent")
    private Set<Department> subParent;

    @OneToMany(mappedBy = "departmentL", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserCoursersDepartment> userCoursersDepartments;

    @OneToMany(mappedBy = "departmentS", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SpecialityLK> specialityLKS;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public Department() {

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }








}
