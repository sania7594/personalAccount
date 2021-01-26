package com.example.personalaccount.table;


import javax.persistence.*;
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
    private String departmentName;

    public SpecialityLK(Department departmentS, String departmentName) {
        this.departmentS = departmentS;
        this.departmentName = departmentName;
    }

    public SpecialityLK() {

    }
}
