package com.example.personalaccount.table;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_special_course")
public class UserSpecialCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uscId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private UserLK userSLK;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="special_id")
    private SpecialityLK specialityLK;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="course_id")
    private CourcesLK courcesSLK;

    public UserSpecialCourse(UserLK userSLK, SpecialityLK specialityLK, CourcesLK courcesSLK) {
        this.userSLK = userSLK;
        this.specialityLK = specialityLK;
        this.courcesSLK = courcesSLK;
    }

    public UserSpecialCourse() {

    }

    public UserLK getUserSLK() {
        return userSLK;
    }

    public void setUserSLK(UserLK userSLK) {
        this.userSLK = userSLK;
    }

    public SpecialityLK getSpecialityLK() {
        return specialityLK;
    }

    public void setSpecialityLK(SpecialityLK specialityLK) {
        this.specialityLK = specialityLK;
    }

    public CourcesLK getCourcesSLK() {
        return courcesSLK;
    }

    public void setCourcesSLK(CourcesLK courcesSLK) {
        this.courcesSLK = courcesSLK;
    }
}
