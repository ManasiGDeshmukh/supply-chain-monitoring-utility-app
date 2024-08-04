package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Payload.LoginResponse;
import com.walmart.supplyChain.Dto.LoginDto;
import com.walmart.supplyChain.Dto.UserDto;
import com.walmart.supplyChain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("supply-chain/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/signUp")
    public String signUp(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}