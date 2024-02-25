package com.project.startMode.model.DoctorPortalModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeethDataModel {
    private String dName;
    @Id
    private String dMail;
    private String dPhone;
    private String dAddress;
    private String domain;
}
