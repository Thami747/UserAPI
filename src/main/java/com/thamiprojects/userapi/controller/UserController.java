package com.thamiprojects.userapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thamiprojects.userapi.model.User;
import com.thamiprojects.userapi.service.UserService;
import com.thamiprojects.userapi.utilities.UserObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    //The below service is commented out as we're not persisting to any database at this time
    private final UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveClient")
    public User saveClient(@RequestBody User user) throws IOException {
        User userResponse = new User();
        boolean isDuplicate = false;

        //The below comment is for testing purpose only
//        System.out.println("Hello:----" + objectMapper.writeValueAsString(ClientObjectMapper.getClientsFromJson()));
        if (isEmptyString(user.getFirstName())) {
            userResponse.setMessage("Client firstName cannot be empty or null.");
        } else if (isEmptyString(user.getLastName())) {
            userResponse.setMessage("Client lastName cannot be empty or null.");
        } else if (!isValidSouthAfricanID(user.getIdNumber())) {
            userResponse.setMessage("South African ID number should contain 13 digits and cannot be empty or null.");
        } else {
            for (User userObj : UserObjectMapper.getClientsFromJson()) {
                if (userObj.getIdNumber().equals(user.getIdNumber()) || userObj.getMobileNumber().equals(user.getMobileNumber())) {
                    userResponse.setMessage("Filed to create Client, either ID number or mobile number is duplicate.");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                List<User> newUserList = UserObjectMapper.getClientsFromJson();
                user.setMessage("Successfully created Client.");
                newUserList.add(user);
                userService.saveUser(newUserList);
                userResponse = user;

            }
        }
        return userResponse;
    }

    @PostMapping(value = "/updateClient")
    public User updateClient(@RequestBody User user) throws IOException {
        User userResponse = new User();
        boolean clientExists = false;
        int index = 0;
        //The below comment is for testing purpose only
//        System.out.println("Hello:----" + objectMapper.writeValueAsString(ClientObjectMapper.getClientsFromJson()));
        if (isEmptyString(user.getFirstName())) {
            userResponse.setMessage("Client firstName cannot be empty or null.");
        } else if (isEmptyString(user.getLastName())) {
            userResponse.setMessage("Client lastName cannot be empty or null.");
        } else if (!isValidSouthAfricanID(user.getIdNumber())) {
            userResponse.setMessage("South African ID number should contain 13 digits and cannot be empty or null.");
        } else {
            for (User userObj : UserObjectMapper.getClientsFromJson()) {
                if (userObj.getIdNumber().equals(user.getIdNumber())) {
                    List<User> newUserList = UserObjectMapper.getClientsFromJson();
                    newUserList.get(index).setFirstName(user.getFirstName());
                    newUserList.get(index).setLastName(user.getLastName());
                    newUserList.get(index).setMobileNumber(user.getMobileNumber());
                    newUserList.get(index).setAddress(user.getAddress());
                    newUserList.get(index).setMessage("Successfully updated Client.");
                    user.setMessage("Successfully updated Client.");
                    userService.updateUser(newUserList);
                    userResponse = user;
                    clientExists = true;
                    break;
                }
                ++index;
            }

            if (!clientExists) {
                userResponse.setMessage("Client does not exist!");
            }
        }
        return userResponse;
    }

    @GetMapping(value="/getClientById/{id}")
    public User getClientById(@PathVariable String id) throws IOException {
        User userResponse;
        userResponse = userService.getUser(id);
        if(userResponse != null) {
            userResponse.setMessage("Successfully found client.");
        } else {
            userResponse = new User();
            userResponse.setMessage("Client does not exist.");
        }
        return userResponse;
    }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping(value="/getClients")
  public List<User> getClients() throws IOException {
    List<User> userResponse;
    userResponse = userService.getUsers();
    if(userResponse != null) {
      userResponse.get(0).setMessage("Successfully found client.");
    } else {
      userResponse.get(0).setMessage("Client does not exist.");
    }
    return userResponse;
  }

    private boolean isEmptyString(String s) {
        if (s != null && !s.isEmpty())
            return false;
        else
            return true;
    }

    //--TODO the below function requires a third party API to validate the accuracy of a South African ID number--
    private boolean isValidSouthAfricanID(String idNumber) {
        if (isEmptyString(idNumber)) {
            return false;
        } else {
            if (idNumber.length() != 13)
                return false;
            else
                return true;
        }
    }
}
