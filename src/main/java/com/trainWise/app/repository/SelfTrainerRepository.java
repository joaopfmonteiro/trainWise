package com.trainWise.app.repository;

import com.trainWise.app.dto.BmiDto;
import com.trainWise.app.model.SelfTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SelfTrainerRepository extends JpaRepository<SelfTrainer, Long> {
    Optional<SelfTrainer> findByEmail(String email);

    @Query(value = """ 
            Select self_trainer.height AS height,
            self_trainer.weight AS weight,
            self_trainer.gender AS gender
            FROM self_trainer
            WHERE self_trainer.id = :id
            """, nativeQuery = true)
    BmiDto getPersonalInfoForBmi(@Param("id") Long id);

}
