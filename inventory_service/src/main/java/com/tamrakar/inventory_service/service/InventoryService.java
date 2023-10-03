package com.tamrakar.inventory_service.service;

import com.tamrakar.inventory_service.model.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> checkForAvalItems(List<String> itemName);
}
