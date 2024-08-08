package com.walmart.supplyChain.Controller;

import com.walmart.supplyChain.Payload.LoginResponse;
import com.walmart.supplyChain.Dto.LoginDto;
import com.walmart.supplyChain.Dto.UserDto;
import com.walmart.supplyChain.Payload.SignUpResponse;
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
    public ResponseEntity<?> signUp(@RequestBody UserDto userDto)
    {
        SignUpResponse signUpResponse = userService.addUser(userDto);
        return ResponseEntity.ok(signUpResponse);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
    @GetMapping(path = "/user/{userid}")
    public ResponseEntity<?> login(@PathVariable int userid)
    {

        return ResponseEntity.ok(userService.getUser(userid));
    }
}