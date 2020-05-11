package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Potion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String pictureURL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn//(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "shop_id")
    private Shop shop;

}
