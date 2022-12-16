package com.levelupcorp.emenube.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BillVO {
    private String tableName;
    private List<String> customerNames;
    private List<BigDecimal> prices;
}
