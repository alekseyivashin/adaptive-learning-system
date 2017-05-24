package ru.ifmo.alekseyivashin.dto;

/**
 * Creator: aleks
 * Date:    24.05.17
 */
public class KeywordDTO {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return "KeywordDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
