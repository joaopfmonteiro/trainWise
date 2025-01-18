package com.trainWise.app.repository;

import com.trainWise.app.dto.ExerciseNameDto;
import com.trainWise.app.model.Exercise;
import com.trainWise.app.model.enums.ExerciseEquipment;
import com.trainWise.app.model.enums.ExerciseType;
import com.trainWise.app.model.enums.Muscle;
import com.trainWise.app.model.enums.MuscleGroup;
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

    @Query("SELECT e FROM Exercise e " +
            "WHERE e.equipment IN (:equipments)")
    List<Exercise> filterByEquipment(@Param("equipments") List<ExerciseEquipment> equipments);

    @Query("SELECT DISTINCT e FROM Exercise e " +
            "JOIN e.exerciseTypes et " +
            "WHERE et IN (:exerciseTypes)")
    List<Exercise> filterByExerciseType(@Param("exerciseTypes") List<ExerciseType> exerciseTypes);

    @Query("SELECT DISTINCT e FROM Exercise e " +
            "JOIN e.muscle em " +
            "WHERE em IN (:muscle)")
    List<Exercise> filterByMuscle(@Param("muscle")List<Muscle> muscle);

    @Query("SELECT DISTINCT e FROM Exercise e " +
            "JOIN e.muscleGroup em " +
            "WHERE em IN (:muscleGroup)")
    List<Exercise> filterByMuscleGroup(@Param("muscleGroup") List<MuscleGroup> muscleGroup);

}
