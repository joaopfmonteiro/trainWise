package com.trainWise.app.repository;

import com.trainWise.app.model.SelfTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SelfTrainerRepository extends JpaRepository<SelfTrainer, Long> {
    Optional<SelfTrainer> findByEmail(String email);
}
