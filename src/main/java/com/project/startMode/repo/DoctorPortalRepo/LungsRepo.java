package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.LungsDataModel;

public interface LungsRepo extends JpaRepository<LungsDataModel, String> {

}
