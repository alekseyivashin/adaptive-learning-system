package ru.ifmo.alekseyivashin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Entity
@Table(name = "users_courses")
public class UserCourse implements Serializable {

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

    private Float startScore;

    private Float endScore;

    @Min(1)
    @Max(5)
    private Integer rating;

    private Float progress;

    @OneToMany(mappedBy = "userCourse")
    private List<UserTheme> userThemes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getStartScore() {
        return startScore;
    }

    public void setStartScore(Float startScore) {
        this.startScore = startScore;
    }

    public Float getEndScore() {
        return endScore;
    }

    public void setEndScore(Float endScore) {
        this.endScore = endScore;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Float getProgress() {
        return progress;
    }

    public void setProgress(Float progress) {
        this.progress = progress;
    }

    public List<UserTheme> getUserThemes() {
        return userThemes;
    }

    public void setUserThemes(List<UserTheme> userThemes) {
        this.userThemes = userThemes;
    }
}
