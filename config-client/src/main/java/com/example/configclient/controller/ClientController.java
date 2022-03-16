package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/service/v1")
public class ClientController {

    @Autowired
    Environment environment;

    @GetMapping("/configs")
    public ResponseEntity<String> getConfig(){
        System.out.println("value of environment is : "+environment.getProperty("message"));
        return new ResponseEntity<String>(environment.getProperty("message"),HttpStatus.OK);
    }
}
