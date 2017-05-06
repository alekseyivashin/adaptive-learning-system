package ru.ifmo.alekseyivashin.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Data
@Entity
@Table(name = "tests_questions")
public class TestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
