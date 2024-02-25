package com.project.startMode.repo.DoctorPortalRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.DoctorPortalModel.BrainDataModel;

public interface BrainRepo extends JpaRepository<BrainDataModel, String> {

}
