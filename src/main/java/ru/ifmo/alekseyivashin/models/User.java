package ru.ifmo.alekseyivashin.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Size(min = 5, max = 200)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_keywords",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id", referencedColumnName = "id"))
    private Set<Keyword> keywords;

    @OneToMany(mappedBy = "user")
    private Set<UserCourse> userCourses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Set<UserCourse> getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(Set<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", keywords=" + keywords +
                ", userCourses=" + userCourses +
                '}';
    }
}
