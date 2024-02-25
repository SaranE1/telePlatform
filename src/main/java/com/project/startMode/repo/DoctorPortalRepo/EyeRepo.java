package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.EyeDataModel;

public interface EyeRepo extends JpaRepository<EyeDataModel, String> {

}
