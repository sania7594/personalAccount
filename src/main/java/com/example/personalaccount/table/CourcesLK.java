package com.example.personalaccount.table;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="courcesLK")
public class CourcesLK {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courcesId;

    @Column
    private String courcesName;

    @OneToMany(mappedBy = "courcesLK",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserCoursersDepartment> userCoursersDepartments;

    @OneToMany(mappedBy = "courcesSLK",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<UserSpecialCourse> userSpecialCourses;

    public CourcesLK(String courcesName) {
        this.courcesName = courcesName;
    }

    public CourcesLK() {

    }

    public String getCourcesName() {
        return courcesName;
    }

    public void setCourcesName(String courcesName) {
        this.courcesName = courcesName;
    }
}
