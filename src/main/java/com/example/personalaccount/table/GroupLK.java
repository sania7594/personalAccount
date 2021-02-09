package com.example.personalaccount.table;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name="grouplk")
public class GroupLK {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;

    @OneToMany(mappedBy = "groupLK", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<UserGroup> userGroups;

    @Column
    @NotEmpty(message = "Please your group name")
    private String groupName;

    public GroupLK(String groupName) {
        this.groupName = groupName;
    }

    public GroupLK() {

    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
