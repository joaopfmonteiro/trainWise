package com.trainWise.app.config;

import com.trainWise.app.model.Exercise;
import com.trainWise.app.model.enums.ExerciseEquipment;
import com.trainWise.app.model.enums.ExerciseType;
import com.trainWise.app.model.enums.Muscle;
import com.trainWise.app.model.enums.MuscleGroup;
import com.trainWise.app.repository.ExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ExerciseInitializer {

    @Bean
    CommandLineRunner initExercises(ExerciseRepository exerciseRepository) {
        return args -> {
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
        };
    }
}
