package com.trainWise.app.repository;

import com.trainWise.app.model.TrainingUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingUnitRepository extends JpaRepository<TrainingUnit, Long> {
}
