package com.project.startMode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.startMode.model.DrugModel;

@Repository
public interface DrugRepo extends JpaRepository<DrugModel, Integer> {

    List<DrugModel> findByDrugNameContainingOrShortCom1ContainingOrShortCom2Containing(String dString, String sc1,
            String sc2);

    List<DrugModel> findTop10ByDrugNameContainingOrShortCom1ContainingOrShortCom2Containing(String dString, String sc1,
            String sc2);
}
