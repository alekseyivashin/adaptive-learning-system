package ru.ifmo.alekseyivashin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    private String description;

    private Float rating;

    private Integer userCount;

    @ManyToMany
    @JoinTable(name = "courses_keywords",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private List<Keyword> keywords;

    @OneToMany(mappedBy = "course")
    private List<UserCourse> courseUsers;

    @OneToMany(mappedBy = "course")
    private List<Theme> themes;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<UserCourse> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(List<UserCourse> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
}
