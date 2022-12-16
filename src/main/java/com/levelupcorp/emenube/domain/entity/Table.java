package com.levelupcorp.emenube.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@AuditTable(value = "TABLE_LOG")
@Entity
@javax.persistence.Table(name = "TABLE", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "TABLE_SEQ", allocationSize = 1)
public class Table extends CommonTimeEntity {
    @Column(name="NAME")
    private String name;
    @Column(name="RESTAURANT_ID")
    private Long restaurantId;
    @Column(name="TABLE_CODE")
    private String tableCode;
    @Column(name="TABLE_STATUS")
    private String tableStatus;
    @Column(name="SESSION_ID")
    private Long sessionId;
    @Column(name="SESSION_CODE")
    private String sessionCode;
}
