package com.tamrakar.api_gateway_server.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private Long orderLineItemsId;
    private String orderLineItemsName;
    private BigDecimal orderLineItemsPrice;
    private int orderLineItemsQuantity;
}
