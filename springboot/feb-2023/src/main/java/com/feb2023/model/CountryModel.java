package com.feb2023.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="country")
public class CountryModel implements Serializable {
    @Id
    Integer id;
    String name;
}
