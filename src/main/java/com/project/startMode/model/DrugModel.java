package com.project.startMode.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class DrugModel {
    @Id
    private int id;
    private String drugName;
    private double price;
    private String manName;
    private String packSizeLabel;
    private String shortCom1;
    private String shortCom2;

}
