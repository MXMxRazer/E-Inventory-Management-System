package com.tamrakar.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "t_inventory" )
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long inventory_id;
    private String itemName;
    private int item_quantity;
}
