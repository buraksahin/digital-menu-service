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
@AuditTable(value = "RESTAURANT_LOG")
@Entity
@Table(name = "RESTAURANT", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "RESTAURANT_SEQ", allocationSize = 1)
public class Restaurant extends CommonTimeEntity {
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="TABLE_LIMIT")
    private Integer tableLimit;
    @Column(name="PHONE")
    private String phone;
    @Column(name="mail")
    private String mail;
}
