package ru.ifmo.alekseyivashin.dto;

import ru.ifmo.alekseyivashin.models.Keyword;

import java.util.List;

/**
 * Created on : 10.05.2017
 * Author     : aliv0816
 */

public class UserDTO {

    private Integer id;
    private String name;
    private String password;
    private List<Keyword> keywords;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", keywords=" + keywords +
                '}';
    }
}
