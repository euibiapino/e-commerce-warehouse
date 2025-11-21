package br.com.warehouse.service;

import br.com.warehouse.dto.StockStatusMessage;

public interface IProductChangeAvailabilityProducer {

    void notifyStatusChange(final StockStatusMessage message);

}
