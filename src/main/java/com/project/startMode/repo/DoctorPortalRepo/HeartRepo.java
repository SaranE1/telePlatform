package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.DoctorData;
import com.project.startMode.model.DoctorPortalModel.HeartDataModel;

public interface HeartRepo extends JpaRepository<HeartDataModel, String> {

}
