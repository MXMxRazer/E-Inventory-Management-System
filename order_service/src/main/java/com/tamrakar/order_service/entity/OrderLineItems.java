package com.tamrakar.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity()
@Table( name = "t_order_line_items" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long order_detail_id;
    private String item_name;
    private BigDecimal item_price;
    private int item_quantity;
}
