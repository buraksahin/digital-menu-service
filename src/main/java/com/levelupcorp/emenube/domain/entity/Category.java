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

@Data
@Generated
@EqualsAndHashCode(callSuper = true)
@Audited
@AuditTable(value = "CATEGORY_LOG")
@Entity
@Table(name = "CATEGORY", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "CATEGORY_SEQ", allocationSize = 1)
public class Category extends CommonTimeEntity{
    @Column(name = "NAME")
    private String name;
    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;
    @Column(name = "LIST_ORDER")
    private Integer listOrder;
}
