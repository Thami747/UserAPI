package com.thamiprojects.userapi.service;

import com.thamiprojects.userapi.model.User;

import java.io.IOException;
import java.util.List;

//The below service is not used as we're not persisting to any database at this time
public interface UserService {
    void saveUser(List<User> user) throws IOException;

    void updateUser(List<User> user) throws IOException;

    User getUser(String id) throws IOException;
  List<User> getUsers() throws IOException;

}
