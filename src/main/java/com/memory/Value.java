package com.memory;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "values")
@Getter
@Setter
@NoArgsConstructor
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;

    public Value(String value) {
        this.value = value;
    }

}
