package com.walmart.supplyChain.Service;

import com.walmart.supplyChain.Payload.LoginResponse;
import com.walmart.supplyChain.Dto.LoginDto;
import com.walmart.supplyChain.Dto.UserDto;
import com.walmart.supplyChain.Payload.SignUpResponse;

public interface UserService {

    SignUpResponse addUser(UserDto userDto);

    LoginResponse loginUser(LoginDto loginDto);
}
