package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String pictureURL;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "hero_id")
    private Hero hero;

}
