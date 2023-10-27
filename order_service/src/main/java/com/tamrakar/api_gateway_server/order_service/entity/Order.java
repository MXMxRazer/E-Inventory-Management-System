package com.tamrakar.api_gateway_server.order_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table( name = "t_order" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String order_number;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> order_line_items_list;
}

