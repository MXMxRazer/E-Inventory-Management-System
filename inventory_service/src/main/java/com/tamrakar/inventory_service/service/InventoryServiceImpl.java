package com.tamrakar.inventory_service.service;

import com.tamrakar.inventory_service.model.InventoryResponse;
import com.tamrakar.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    @Override
    public List<InventoryResponse> checkForAvalItems(List<String> itemName) {
        log.info("Checking Inventory");
        return inventoryRepository.findByItemNameIn(itemName).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .itemName(inventory.getItemName())
                                .isAval(inventory.getItem_quantity() > 0)
                                .build()
                ).toList();
    }
}
