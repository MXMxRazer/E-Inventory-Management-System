package com.tamrakar.api_gateway_server.inventory_service.service;

import com.tamrakar.api_gateway_server.inventory_service.model.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> checkForAvalItems(List<String> itemName);
}
