package com.project.startMode.model.DoctorPortalModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class DoctorData {
    private String dName;
    @Id
    private String dMail;
    private String dAddress;
    private String dPhone;
    private String domain;
}
