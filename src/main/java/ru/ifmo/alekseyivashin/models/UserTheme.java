package ru.ifmo.alekseyivashin.models;

import javax.persistence.*;

/**
 * Creator: aleks
 * Date:    21.05.17
 */

@Entity
@Table(name = "user_themes")
public class UserTheme {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_course_id")
    private UserCourse userCourse;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    private Double userLevel;

    private Integer count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserCourse getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(UserCourse userCourse) {
        this.userCourse = userCourse;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Double getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Double userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
