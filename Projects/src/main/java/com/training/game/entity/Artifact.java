package com.training.game.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Artifact {
    private String name;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "inventory_id")
    private Inventory inventory;

}
