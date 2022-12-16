package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Table;
import com.levelupcorp.emenube.domain.entity.TableSession;
import com.levelupcorp.emenube.domain.request.TableRequest;
import com.levelupcorp.emenube.repository.TableRepository;
import com.levelupcorp.emenube.repository.TableSessionRepository;
import com.levelupcorp.emenube.util.Util;
import com.levelupcorp.emenube.util.constant.ServiceConstant;
import com.levelupcorp.emenube.util.mapper.GenericMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService{
    private final TableRepository tableRepository;
    private final TableSessionRepository tableSessionRepository;
    private GenericMapper genericMapper;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository, TableSessionRepository tableSessionRepository, GenericMapper genericMapper){
        this.tableRepository = tableRepository;
        this.tableSessionRepository = tableSessionRepository;
        this.genericMapper = genericMapper;
    }

    @Override
    public List<Table> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table getById(Long tableId) {
        return tableRepository.findById(tableId).map(a -> a).orElse(null);
    }

    @Override
    public List<Table> getByRestaurantId(Long restaurantId) {
        return tableRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Table createTable(TableRequest tableRequest) {
        Table newTable = new Table();
        BeanUtils.copyProperties(tableRequest, newTable);
        Table savedTable = tableRepository.save(newTable);
        return savedTable;
    }

    @Override
    public Table updateTable(TableRequest tableRequest, Long tableId) {
        Table currentTable = getById(tableId);

        if(currentTable == null){
            return null;
        }
        try {
            genericMapper.<TableRequest, Table>copyProperties(tableRequest, currentTable);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Table updatedTable = tableRepository.save(currentTable);
        return updatedTable;
    }

    @Override
    public Boolean deleteTable(Long tableId) {
        try{
            tableRepository.deleteById(tableId);
            return true;
        }
        catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public Table openTable(TableRequest tableRequest, Long tableId) {
        Table currentTable = getById(tableId);

        if(currentTable != null){
            String tableCode = Util.getTableCode();
            TableSession tableSession = new TableSession();
            tableSession.setSessionCode(Util.getSessionCode(currentTable.getId(), currentTable.getRestaurantId(), currentTable.getTableStatus(), tableCode));
            tableSession.setProcess(ServiceConstant.OPEN);
            tableSession.setTableId(currentTable.getId());
            tableSession.setRestaurantId(currentTable.getRestaurantId());
            TableSession createdTableSession = tableSessionRepository.save(tableSession);
            currentTable.setTableStatus(ServiceConstant.OPEN);
            currentTable.setTableCode(tableCode);
            currentTable.setSessionCode(createdTableSession.getSessionCode());
            currentTable.setSessionId(createdTableSession.getId());
            Table updatedTable = tableRepository.save(currentTable);
            return updatedTable;
        }
        return null;
    }

    @Override
    public Table closeTable(TableRequest tableRequest, Long tableId) {
        Table currentTable = getById(tableId);

        if(currentTable != null){
            TableSession tableSession = new TableSession();
            tableSession.setSessionCode(Util.getSessionCode(currentTable.getId(), currentTable.getRestaurantId(), currentTable.getTableStatus(), ""));
            tableSession.setProcess(ServiceConstant.CLOSE);
            tableSession.setTableId(currentTable.getId());
            tableSession.setRestaurantId(currentTable.getRestaurantId());
            TableSession createdTableSession = tableSessionRepository.save(tableSession);
            currentTable.setTableStatus(ServiceConstant.CLOSE);
            currentTable.setTableCode("");
            currentTable.setSessionCode(createdTableSession.getSessionCode());
            currentTable.setSessionId(createdTableSession.getId());
            Table updatedTable = tableRepository.save(currentTable);
            return updatedTable;
        }
        return null;
    }

    @Override
    public TableSession getTableSession(Long tableId, Long restaurantId, String tableCode) {
        return tableSessionRepository.findByTableIdAndRestaurantIdAndTableCode(tableId, restaurantId, tableCode).map(a -> a).orElse(null);
    }
}
