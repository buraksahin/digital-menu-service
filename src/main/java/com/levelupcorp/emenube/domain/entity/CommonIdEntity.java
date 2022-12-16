package com.levelupcorp.emenube.domain.entity;

import lombok.Data;
import lombok.Generated;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@Audited
@MappedSuperclass
@Generated
public class CommonIdEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    private Long id;
}