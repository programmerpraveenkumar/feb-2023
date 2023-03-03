package com.feb2023.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name="country")
public class CountryModel {
    @Id
    Integer id;
    String name;
}
