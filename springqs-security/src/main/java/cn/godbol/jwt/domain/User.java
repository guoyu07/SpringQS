package cn.godbol.jwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Li on 2016/10/14.
 */
@Entity
@Getter @Setter
public class User extends BaseModel{

    @Column(length = 50)
    private String username;

    @JsonIgnore
    @Column(length = 50)
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "tb_users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Collection<Group> groups;



}
