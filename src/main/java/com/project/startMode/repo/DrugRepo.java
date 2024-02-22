package com.project.startMode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.startMode.model.DrugModel;

@Repository
public interface DrugRepo extends JpaRepository<DrugModel, Integer> {

}
