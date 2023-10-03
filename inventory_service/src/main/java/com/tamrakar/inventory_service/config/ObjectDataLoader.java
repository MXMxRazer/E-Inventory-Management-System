package com.tamrakar.inventory_service.config;

import com.tamrakar.inventory_service.entity.Inventory;
import com.tamrakar.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObjectDataLoader implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Inventory inventory = new Inventory();
        inventory.setItemName("iphone_13");
        inventory.setItem_quantity(100);

        Inventory inventory1 = new Inventory();
        inventory1.setItemName("iphone_13_red");
        inventory1.setItem_quantity(0);

        inventoryRepository.save(inventory);
        inventoryRepository.save(inventory1);
    }
}