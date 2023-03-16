package com.thamiprojects.userapi.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thamiprojects.userapi.model.User;

import java.io.*;
import java.util.List;

public class UserObjectMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String filePath = "src/test/resources/clientList.json";
    public static List<User> getClientsFromJson() throws IOException {
        InputStream inputStream = new FileInputStream(filePath);
        TypeReference<List<User>> typeReference = new TypeReference<>() {};
        return objectMapper.readValue(inputStream, typeReference);
    }

    public static void saveNewClient(List<User> user) throws IOException {
        objectMapper.writeValue(new File(filePath), user);
    }
}
