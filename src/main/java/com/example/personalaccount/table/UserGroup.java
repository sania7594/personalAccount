package com.example.personalaccount.table;


import javax.persistence.*;

@Entity
@Table(name="user_group")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="user_id")
    private UserLK userGroupLK;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="group_id")
    private GroupLK groupLK;

    public UserGroup(UserLK userGroupLK, GroupLK groupLK) {
        this.userGroupLK = userGroupLK;
        this.groupLK = groupLK;
    }

    public UserLK getUserGroupLK() {
        return userGroupLK;
    }

    public void setUserGroupLK(UserLK userGroupLK) {
        this.userGroupLK = userGroupLK;
    }

    public GroupLK getGroupLK() {
        return groupLK;
    }

    public void setGroupLK(GroupLK groupLK) {
        this.groupLK = groupLK;
    }
}
