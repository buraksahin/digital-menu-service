package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Table;
import com.levelupcorp.emenube.domain.entity.TableSession;
import com.levelupcorp.emenube.domain.request.TableRequest;

import java.util.List;

public interface TableService {
    List<Table> getAll();
    Table getById(Long tableId);
    List<Table> getByRestaurantId(Long rsestaurantId);
    Table createTable(TableRequest tableRequest);
    Table updateTable(TableRequest tableRequest, Long tableId);
    Boolean deleteTable(Long tableId);
    Table openTable(TableRequest tableRequest, Long tableId);
    Table closeTable(TableRequest tableRequest, Long tableId);
    TableSession getTableSession(Long restaurantId, Long tableId, String tableCode);
}
