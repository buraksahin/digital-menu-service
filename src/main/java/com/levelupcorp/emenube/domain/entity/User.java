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
@AuditTable(value = "USER_LOG")
@Entity
@Table(name = "USER", schema = "EMENU")
@SequenceGenerator(name = "idgen", sequenceName = "USER_SEQ", allocationSize = 1)
public class User extends CommonTimeEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "MAIL")
    private String mail;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "LAST_LOGIN")
    private Date lastLogin;
    @Column(name = "AUTH_CODE")
    private String authCode;
    @Column(name = "TYPE")
    private Integer type;
}
