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
public class EmailDetails {
    @Id
    private String recipient;
    private String patientName;
    private String patientAge;
    private String gender;
    private String medicineName1;
    private String dosage1;
    private String dayNight1;
    private String medicineName2;
    private String dosage2;
    private String dayNight2;
}
