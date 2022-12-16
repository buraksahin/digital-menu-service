package com.levelupcorp.emenube.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Data
@Generated
@EqualsAndHashCode(callSuper = true)
@Audited
@AuditTable(value = "TABLE_SESSION_LOG")
@Entity
@javax.persistence.Table(name = "TABLE_SESSION", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "TABLE_SESSION_SEQ", allocationSize = 1)
public class TableSession extends CommonTimeEntity {
    @Column(name="SESSION_CODE")
    private String sessionCode;
    @Column(name="RESTAURANT_ID")
    private Long restaurantId;
    @Column(name="TABLE_ID")
    private Long tableId;
    @Column(name="TABLE_CODE")
    private String tableCode;
    @Column(name="PROCESS")
    private String process;
}
