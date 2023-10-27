package com.tamrakar.api_gateway_server.inventory_service.repository;

import com.tamrakar.api_gateway_server.inventory_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByItemNameIn(List<String> itemName);

}
