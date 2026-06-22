package com.lucas.gofpokedex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {
    @Id
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private int height;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = false)
    private List<String> types;
    @Column(nullable = false)
    private List<String> abilities;
    @Column(nullable = false)
    private int attack;
    @Column(nullable = false)
    private int defense;
    @Column(nullable = false)
    private int speed;
    @Column(name = "base_experience", nullable = false)
    private int baseXP;
}
