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
import java.math.BigDecimal;

@Data
@Generated
@EqualsAndHashCode(callSuper = true)
@Audited
@AuditTable(value = "PRODUCT_LOG")
@Entity
@Table(name = "PRODUCT", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "PRODUCT_SEQ", allocationSize = 1)
public class Product extends CommonTimeEntity {
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private BigDecimal price;
    @Column(name="CATEGORY_ID")
    private Long categoryId;
    @Column(name="RESTAURANT_ID")
    private Long restaurantId;
}
