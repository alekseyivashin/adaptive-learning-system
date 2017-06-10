package ru.ifmo.alekseyivashin.models;

import javax.persistence.*;

/**
 * Creator: aleks
 * Date:    10.06.17
 */

@Entity
@Table(name = "recommendations_useful")
public class RecommendationUseful {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
