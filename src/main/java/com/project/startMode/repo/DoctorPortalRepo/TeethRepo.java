package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.TeethDataModel;

public interface TeethRepo extends JpaRepository<TeethDataModel, String> {

}
