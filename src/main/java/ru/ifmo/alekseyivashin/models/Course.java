package ru.ifmo.alekseyivashin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(1)
    @Max(2)
    private Integer level;

    private Float rating;

    private Integer userCount;

    @ManyToMany
    @JoinTable(name = "courses_keywords",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id"))
    private Set<Keyword> keywords;

    @OneToMany(mappedBy = "course")
    private Set<UserCourse> courseUsers;

    @OneToMany(mappedBy = "course")
    private Set<Theme> themes;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @JsonIgnore
    public Set<UserCourse> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(Set<UserCourse> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", rating=" + rating +
                ", userCount=" + userCount +
                ", keywords=" + keywords +
                ", courseUsers=" + courseUsers +
                ", themes=" + themes +
                '}';
    }
}
