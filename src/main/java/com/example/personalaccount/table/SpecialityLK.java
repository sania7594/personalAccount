package com.example.personalaccount.table;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name="speciality")
public class SpecialityLK {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialityId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="department_id")
    private Department departmentS;

    @OneToMany(mappedBy = "specialityLK", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserSpecialCourse> userSpecialCourses;

    @Column
    @NotEmpty(message = "Please your speciality name")
    private String specialityName;

    public SpecialityLK(Department departmentS, String specialityName) {
        this.departmentS = departmentS;
        this.specialityName = specialityName;
    }

    public SpecialityLK() {

    }

    public Department getDepartmentS() {
        return departmentS;
    }

    public void setDepartmentS(Department departmentS) {
        this.departmentS = departmentS;
    }

    public Set<UserSpecialCourse> getUserSpecialCourses() {
        return userSpecialCourses;
    }

    public void setUserSpecialCourses(Set<UserSpecialCourse> userSpecialCourses) {
        this.userSpecialCourses = userSpecialCourses;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }
}
