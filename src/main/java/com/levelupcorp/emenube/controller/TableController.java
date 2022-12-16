package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Table;
import com.levelupcorp.emenube.domain.entity.TableSession;
import com.levelupcorp.emenube.domain.request.TableRequest;
import com.levelupcorp.emenube.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/table")
public class TableController {
    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService){
        this.tableService = tableService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Table>> getTables() {
        return ResponseEntity.ok(tableService.getAll());
    }

    @GetMapping("/get-by-table-id/{table-id}")
    public ResponseEntity<Table> getTableByTableId(@PathVariable("table-id") Long tableId) {
        return ResponseEntity.ok(tableService.getById(tableId));
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<List<Table>> getTableByestaurantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(tableService.getByRestaurantId(restaurantId));
    }

    @PostMapping("/create")
    public ResponseEntity<Table> createTable(@RequestBody @Valid TableRequest tableRequest) {
        Table createdTable = tableService.createTable(tableRequest);
        return ResponseEntity.ok(createdTable);
    }

    @PatchMapping("/update/{table-id}")
    public ResponseEntity<Table> updateTable(@RequestBody @Valid TableRequest tableRequest, @PathVariable("table-id") Long tableId) {
        Table updatedTable = tableService.updateTable(tableRequest, tableId);
        return ResponseEntity.ok(updatedTable);
    }

    @DeleteMapping("/delete/{table-id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("table-id") @Valid Long tableId) {
        return ResponseEntity.ok(tableService.deleteTable(tableId));
    }
    @PatchMapping("/open/{table-id}")
    public ResponseEntity<Table> openTable(@RequestBody @Valid TableRequest tableRequest, @PathVariable("table-id") Long tableId) {
        Table openedTable = tableService.openTable(tableRequest, tableId);
        return ResponseEntity.ok(openedTable);
    }

    @PatchMapping("/close/{table-id}")
    public ResponseEntity<Table> closeTable(@RequestBody @Valid TableRequest tableRequest, @PathVariable("table-id") Long tableId) {
        Table closedTable = tableService.closeTable(tableRequest, tableId);
        return ResponseEntity.ok(closedTable);
    }

    @GetMapping("/get-table-session/{table-id}/{restaurant-id}/{table-code}")
    public ResponseEntity<TableSession> getTableSession(@PathVariable("table-id") Long tableId, @PathVariable("restaurant-id") Long restaurantId, @PathVariable("table-code") String tableCode) {
        TableSession table = tableService.getTableSession(restaurantId, tableId, tableCode);
        return ResponseEntity.ok(table);
    }
}
