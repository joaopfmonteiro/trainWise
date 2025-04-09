package com.trainWise.app.repository;

import com.trainWise.app.dto.BmiDto;
import com.trainWise.app.dto.BodyFatMetricsDto;
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

    @Query(value = """
            Select self_trainer.neck AS neck,
            self_trainer.waist AS waist,
            self_trainer.hip AS hip,
            self_trainer.height AS height,
            self_trainer.gender As gender,
            self_trainer.birth_date AS birthDate
            FROM self_trainer
            WHERE self_trainer.id = :id
            """, nativeQuery = true)
    BodyFatMetricsDto getPersonalIfoForBodyFat(@Param("id") Long id);
}
