package ru.ifmo.alekseyivashin.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Data
@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "learning_content_id")
    private LearningContent learningContent;

    @OneToMany(mappedBy = "test")
    private Set<TestQuestion> testQuestions;
}
