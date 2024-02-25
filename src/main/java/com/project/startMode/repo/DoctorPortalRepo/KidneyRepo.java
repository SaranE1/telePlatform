package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.KidneyDataModel;

public interface KidneyRepo extends JpaRepository<KidneyDataModel, String> {

}
