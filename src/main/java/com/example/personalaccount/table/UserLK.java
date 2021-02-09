package com.example.personalaccount.table;
/*Дата рождения маску сделать
* Телефон номер
* емейл
* */


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="userlk")
//public class UserLK implements Serializable {
  public class UserLK{
    //private static final long serialVersionUID = -2343243243242432341L;

    //DTO
    //@Data
    //моя пометка по логину можно искать
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @OneToMany(mappedBy = "userLK",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserRoleDepartment> userRoleDepartments;

    @OneToMany(mappedBy = "userGroupLK",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserGroup> userGroups;

    @OneToMany(mappedBy = "userL",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserCoursersDepartment> userCoursersDepartments;

    @OneToMany(mappedBy = "userSLK",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserSpecialCourse> userSpecialCourses;

    @Column
    @NotEmpty(message = "Please your first name")
    private String firstName;


    @Column
    @NotEmpty(message = "Please your last name")
    private String lastName;

    @Email
    @Column
    @NotBlank(message="{register.email.invalid}")
    @Size(min=6, max=80)
    private String email;


    @Column(unique = true)
    @NotBlank(message="{register.phone.invalid}")
    @Size(min=6, max=12)
    private String phone;

    @Column
    @NotEmpty(message = "Please your birthday")
    private String birthday;

    @Column
    @NotEmpty(message = "Please your login")
    private String login;


    @Column
    @NotEmpty(message = "Please your password")
    private String password;


    public UserLK(String firstName, String lastName, String email, String phone, String birthday, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
    }

    public UserLK() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
