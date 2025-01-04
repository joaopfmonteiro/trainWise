package com.trainWise.app.repository;

import com.trainWise.app.model.MesoCicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesoCicleRepository extends JpaRepository<MesoCicle, Long> {
}
