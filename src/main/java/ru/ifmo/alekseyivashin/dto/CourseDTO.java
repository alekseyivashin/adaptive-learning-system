package ru.ifmo.alekseyivashin.dto;

import ru.ifmo.alekseyivashin.models.Keyword;

import java.util.Set;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

public class CourseDTO {

    private Integer id;
    private String name;
    private Integer level;
    private Set<Keyword> keywords;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", keywords=" + keywords +
                '}';
    }
}
