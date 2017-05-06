package ru.ifmo.alekseyivashin.models;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(name = "users_keywords",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords;

    @OneToMany(mappedBy = "user")
    private Set<UserCourse> userCourses;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
