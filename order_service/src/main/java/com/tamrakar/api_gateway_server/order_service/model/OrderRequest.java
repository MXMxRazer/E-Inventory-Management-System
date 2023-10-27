package com.tamrakar.api_gateway_server.order_service.model;

import com.tamrakar.api_gateway_server.order_service.dto.OrderLineItemsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDto;
}
