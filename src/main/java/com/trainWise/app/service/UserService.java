package com.trainWise.app.service;

import com.trainWise.app.dto.UserDto;
import com.trainWise.app.model.Client;
import com.trainWise.app.model.SelfTrainer;
import com.trainWise.app.model.Trainer;
import com.trainWise.app.model.User;
import com.trainWise.app.repository.ClientRepository;
import com.trainWise.app.repository.SelfTrainerRepository;
import com.trainWise.app.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private SelfTrainerRepository selfTrainerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDto user, String userType){
        switch (userType.toUpperCase()){
            case "SELFTRAINER":
                SelfTrainer selfTrainer = new SelfTrainer();
                copyDataToUserType(user, selfTrainer);
                selfTrainer.setPassword(passwordEncoder.encode(user.getPassword()));
                return selfTrainerRepository.save(selfTrainer);

            case "TRAINER":
                Trainer trainer = new Trainer();
                copyDataToUserType(user, trainer);
                trainer.setPassword(passwordEncoder.encode(user.getPassword()));
                return trainerRepository.save(trainer);

            case "CLIENT":
                Client client = new Client();
                copyDataToUserType(user, client);
                client.setPassword(passwordEncoder.encode(user.getPassword()));

                return clientRepository.save(client);

            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }

    private void copyDataToUserType(UserDto userDto, User user){
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBirthDate(userDto.getBirthDate());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setGender(userDto.getGender());
        user.setUserName(userDto.getUserName());
        user.setGoals(userDto.getGoals());
        user.setGoalWeight(userDto.getGoalWeight());
        user.setNeck(userDto.getNeck());
        user.setHip(userDto.getHip());
        user.setWaist(userDto.getWaist());
        user.setPhysicalActivity(userDto.getPhysicalActivity());
    }
}
