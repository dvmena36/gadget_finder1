package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.LoginResponse;
import com.dvmena.gadget_finder1.model.Register;
//import com.dvmena.gadget_finder1.security.CustomAuthenticationManager;
//import com.dvmena.gadget_finder1.security.TokenService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService extends ResponseService{

//    private final TokenService tokenService;
//    private final CustomAuthenticationManager authenticationManager;
    private final RegisterService registerService;
    public LoginResponse login(Login login){
        String response;
       Register register = registerService.get(login.getEmail());
            if(register !=null){
                if(register.getPassword().equals(login.getPassword())){
                    response = "User is logged in";

                }else{
                    response =  "Wrong password";
                }
            }else{
                response = "User not found";
            }
            return super.loginResponse(register.getUser_first_name(),
                register.getUser_last_name(),
                response);

    }

//    public String login(String email,String password) throws RuntimeException {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(email,password)
//            );
//        } catch (final BadCredentialsException e) {
//            throw new RuntimeException("Incorrect credentials");
//        }
//        return tokenService.generateToken(email);
//    }
}
