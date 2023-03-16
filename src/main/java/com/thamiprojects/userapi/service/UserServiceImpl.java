package com.thamiprojects.userapi.service;

import com.thamiprojects.userapi.model.User;
import com.thamiprojects.userapi.repository.UserRepository;
import com.thamiprojects.userapi.utilities.UserObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//The below service implementation is commented out as we're not persisting to any database at this time
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(List<User> user) throws IOException {
        UserObjectMapper.saveNewClient(user);
    }

    public void updateUser(List<User> user) throws IOException {
        UserObjectMapper.saveNewClient(user);
    }

    public User getUser(String id) throws IOException {
        List<User> getUsers = UserObjectMapper.getClientsFromJson();

        return getUsers.stream()
                .filter(t -> id.equals(t.getIdNumber()))
                .findFirst()
                .orElse(null);
    }
}
