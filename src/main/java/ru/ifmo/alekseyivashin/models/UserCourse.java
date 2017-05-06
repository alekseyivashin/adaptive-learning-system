package ru.ifmo.alekseyivashin.models;

import lombok.Data;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.models.User;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Data
@Entity
@Table(name = "users_courses")
public class UserCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull
    private Date startDate;

    private Date endDate;

    private double startScore;

    private double endScore;

    @Min(1)
    @Max(10)
    private int rating;

    private float passValue;
}
