package com.project.startMode.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.startMode.model.HomeIndex;

public interface JavaRepo extends JpaRepository<HomeIndex, Integer> {

    List<HomeIndex> findByFnameContainingOrLnameContaining(String fname, String lname);

    List<HomeIndex> findByFname(String keyWord);
}
