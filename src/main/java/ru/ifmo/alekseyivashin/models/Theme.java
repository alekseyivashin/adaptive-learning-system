package ru.ifmo.alekseyivashin.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Data
@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "theme")
    private Set<LearningContent> learningContents;

    @OneToMany(mappedBy = "theme")
    private Set<Question> questions;
}
