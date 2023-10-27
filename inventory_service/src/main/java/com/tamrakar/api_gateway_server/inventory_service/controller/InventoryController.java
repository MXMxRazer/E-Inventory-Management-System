package com.tamrakar.api_gateway_server.inventory_service.controller;

import com.tamrakar.api_gateway_server.inventory_service.model.InventoryResponse;
import com.tamrakar.api_gateway_server.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> checkForItems(@RequestParam List<String> itemName) {
        return inventoryService.checkForAvalItems(itemName);
    }

}
