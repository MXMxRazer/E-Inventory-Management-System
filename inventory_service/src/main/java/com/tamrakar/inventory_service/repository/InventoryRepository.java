package com.tamrakar.inventory_service.repository;

import com.tamrakar.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByItemNameIn(List<String> itemName);

}
