package ru.ifmo.alekseyivashin.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(1)
    @Max(5)
    private int level;

    @ManyToMany
    @JoinTable(name = "courses_keywords",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords;

    @OneToMany(mappedBy = "course")
    private Set<UserCourse> courseUsers;

    @OneToMany(mappedBy = "course")
    private Set<Theme> themes;
}
