package ru.ifmo.alekseyivashin.dto;

import ru.ifmo.alekseyivashin.models.Keyword;

import java.util.List;
import java.util.Set;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

public class CourseDTO {

    private Integer id;
    private String name;
    private Float rating;
    private Integer userCount;
    private List<Keyword> keywords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", userCount=" + userCount +
                ", keywords=" + keywords +
                '}';
    }
}
