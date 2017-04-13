package ru.ifmo.alekseyivashin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Creator: aleks
 * Date:    13.04.17.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 200)
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
