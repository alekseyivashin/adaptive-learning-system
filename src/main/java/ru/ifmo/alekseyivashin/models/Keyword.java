package ru.ifmo.alekseyivashin.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Creator: aleks
 * Date:    06.05.17
 */

@Entity
@Data
@Table(name = "keywords")
public class Keyword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

}
