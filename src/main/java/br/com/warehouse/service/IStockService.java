package br.com.warehouse.service;

import br.com.warehouse.entity.StockEntity;
import br.com.warehouse.entity.StockStatus;

import java.util.UUID;

public interface IStockService {

    StockEntity save(final StockEntity entity);

    void release(final UUID id);

    void incative(final UUID id);

    void changeStatus(final UUID id, final StockStatus status);

}
