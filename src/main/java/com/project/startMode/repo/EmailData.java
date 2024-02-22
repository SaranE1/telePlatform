package com.project.startMode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.startMode.model.PatientSentData;

// All the patient records and details
@Repository
public interface EmailData extends JpaRepository<PatientSentData, String> {

}
