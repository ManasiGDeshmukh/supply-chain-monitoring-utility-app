package com.walmart.supplyChain.Service.Impl;

import com.walmart.supplyChain.Payload.LoginResponse;
import com.walmart.supplyChain.Dto.LoginDto;
import com.walmart.supplyChain.Dto.UserDto;
import com.walmart.supplyChain.Entity.User;
import com.walmart.supplyChain.Payload.SignUpResponse;
import com.walmart.supplyChain.Repository.UserRepo;
import com.walmart.supplyChain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    UserDto userDto;

    @Override
    public SignUpResponse addUser(UserDto userDto) {
        User user = new User(
                userDto.getUserId(),
                userDto.getName(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword()),
                userDto.getRole(),
                userDto.getAddr()
        );
        userRepo.save(user);
        User user1 = userRepo.findByEmail(userDto.getEmail());
        return new SignUpResponse("Sign up Successful",user1.getName(),user1.getUserId());
    }


    @Override
    public LoginResponse  loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            int userId = user1.getUserId();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true, userId, user1.getRole());
                } else {
                    return new LoginResponse("Login Failed", false, -1,"");
                }
            } else {
                return new LoginResponse("password Not Match", false, -1,"");
            }
        }else {
            return new LoginResponse("Email not exits", false, -1,"");
        }
    }

    @Override
    public User getUser(int userid) {
        return userRepo.findByUserId(userid);
    }
}
