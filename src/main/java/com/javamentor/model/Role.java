package com.javamentor.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role extends AbstractModel implements GrantedAuthority {

    private static final long serialVersionUID = 3034557457004657465L;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinTable(name = "permissions",
                joinColumns = {@JoinColumn(name = "role_id")},
                inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 47 * name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Role other = (Role) obj;
        return this.name.equals(other.name);

    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
