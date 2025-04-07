package com.trainWise.app.config;

import com.trainWise.app.model.Exercise;
import com.trainWise.app.model.MesoCicle;
import com.trainWise.app.model.TrainingUnit;
import com.trainWise.app.model.Workout;
import com.trainWise.app.model.enums.ExerciseEquipment;
import com.trainWise.app.model.enums.ExerciseType;
import com.trainWise.app.model.enums.Muscle;
import com.trainWise.app.model.enums.MuscleGroup;
import com.trainWise.app.repository.ExerciseRepository;
import com.trainWise.app.repository.MesoCicleRepository;
import com.trainWise.app.repository.TrainingUnitRepository;
import com.trainWise.app.repository.WorkoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initExercises(ExerciseRepository exerciseRepository,
                                    TrainingUnitRepository trainingUnitRepository,
                                    WorkoutRepository workoutRepository,
                                    MesoCicleRepository mesoCicleRepository) {
        return args -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (exerciseRepository.count() == 0) {
                List<Exercise> exercises = Arrays.asList(
                        new Exercise("Deadlift",
                                Arrays.asList(Muscle.LOWER_BACK, Muscle.GLUTES, Muscle.HAMSTRINGS),
                                Arrays.asList(MuscleGroup.LEGS, MuscleGroup.BACK),
                                Arrays.asList(ExerciseType.STRENGTH),
                                ExerciseEquipment.BARBELL,
                                "A compound movement that targets multiple muscles.",
                                "deadlift.jpg",
                                "deadlift.mp4"
                        ),
                        new Exercise("Pull-Up",
                                Arrays.asList(Muscle.BICEPS, Muscle.LATS, Muscle.TRAPS),
                                Arrays.asList(MuscleGroup.BACK),
                                Arrays.asList(ExerciseType.CALISTHENICS, ExerciseType.STRENGTH),
                                ExerciseEquipment.PULLUP_BAR,
                                "A fundamental upper body exercise using bodyweight.",
                                "pullup.jpg",
                                "pullup.mp4"
                        ),
                        new Exercise("Bench Press",
                                Arrays.asList(Muscle.CHEST, Muscle.TRICEPS),
                                Arrays.asList(MuscleGroup.CHEST),
                                Arrays.asList(ExerciseType.STRENGTH),
                                ExerciseEquipment.BENCH_PRESS,
                                "A classic chest exercise using a barbell.",
                                "bench_press.jpg",
                                "bench_press.mp4"
                        )
                );

                exerciseRepository.saveAll(exercises);
                System.out.println("Exercises have been load!");
            }
            if (trainingUnitRepository.count() == 0){
                Optional<Exercise> exercise = exerciseRepository.findById(1l);
                List<TrainingUnit> trainingUnits = Arrays.asList(
                        new TrainingUnit(
                                exercise.get(),
                                3,
                                3,
                                3,
                                3
                        )
                );
                trainingUnitRepository.saveAll(trainingUnits);
            }
            if(workoutRepository.count() == 0){
                Date workoutDate = dateFormat.parse("2024-01-27");
                List<Workout> workouts = Arrays.asList(
                        new Workout(
                                workoutDate
                        )
                );
                workoutRepository.saveAll(workouts);
                workoutRepository.addTrainingUnitToWorkout(1l,1l);
            }
            if(mesoCicleRepository.count() == 0){
                Date mesoClicleBegin = dateFormat.parse("2024-01-01");
                Date mesoClicleEnd =  dateFormat.parse("2024-06-01");
                List<MesoCicle> mesoCicles = Arrays.asList(
                        new MesoCicle(
                                "Hipertrofia Avançada",
                                mesoClicleBegin,
                                mesoClicleEnd
                        )
                );
                mesoCicleRepository.saveAll(mesoCicles);
            }
        };
    }
}
