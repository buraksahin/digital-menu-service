package com.levelupcorp.emenube.domain.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Generated
@EqualsAndHashCode(callSuper = true)
@Audited
@AuditTable(value = "RATE_LOG")
@Entity
@Table(name = "RATE", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "RATE_SEQ", allocationSize = 1)
public class Rate extends CommonIdEntity {
    private Long orderId;
    private Integer rate;
}
