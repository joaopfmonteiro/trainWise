package com.trainWise.app.repository;

import com.trainWise.app.dto.ExerciseMuscleDto;
import com.trainWise.app.dto.ExerciseNameDto;
import com.trainWise.app.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT new com.trainWise.app.dto.ExerciseNameDto(e.id, e.name) " +
            "FROM Exercise e " +
            "WHERE LOWER(e.name) LIKE LOWER(CONCAT(:searchTerm, '%'))")
    List<ExerciseNameDto> searchExercisesName(@Param("searchTerm") String searchTerm);

    @Query("SELECT new com.trainWise.app.dto.ExerciseNameDto(e.id, e.name) " +
            "FROM Exercise e " +
            "ORDER BY e.name ASC")
    List<ExerciseNameDto> orderByName();

//    @Query("SELECT new com.trainWise.app.dto.ExerciseMuscleDto(e.id, e.muscle) " +
//            "FROM Exercise e " +
//            "WHERE LOWER(e.muscle) LIKE LOWER(CONCAT(:searchTerm, '%'))")
//    List<ExerciseMuscleDto> searchExercisesMuscle(@Param("searchTerm") String searchTerm);

//    @Query("SELECT new com.trainWise.app.dto.ExerciseMuscleDto(e.id, e.muscle) " +
//            "FROM Exercise e " +
//            "ORDER BY e.muscle ASC")
//    List<ExerciseMuscleDto> orderByMuscle();

}
