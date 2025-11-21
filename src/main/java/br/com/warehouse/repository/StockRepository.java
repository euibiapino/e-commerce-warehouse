package br.com.warehouse.repository;

import br.com.warehouse.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<StockEntity, UUID> {
}
