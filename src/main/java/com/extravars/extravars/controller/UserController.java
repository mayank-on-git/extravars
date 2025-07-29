package com.extravars.extravars.controller;

import com.extravars.extravars.entity.User;
import com.extravars.extravars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    UserService userService;


    @PostMapping("/save")
    public ResponseEntity<User> saveUserData(@RequestBody User user ){
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);

    }
    @GetMapping("/api/timezones")
    public Map<String, String> getTimeInZones() {
        Map<String, String> response = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));

        response.put("India_Kolkata", indiaTime.format(formatter));
        response.put("USA_NewYork", nyTime.format(formatter));

        return response;
    }

}
