package com.levelupcorp.emenube.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;

@Data
@Generated
@EqualsAndHashCode(callSuper = true)
@Audited
@AuditTable(value = "ORDER_LOG")
@Entity
@Table(name = "ORDER", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "ORDER_SEQ", allocationSize = 1)
public class Order extends CommonTimeEntity {
    @Column(name = "TABLE_ID")
    private Long tableId;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "LIST_ORDER")
    private Integer listOrder;
}
