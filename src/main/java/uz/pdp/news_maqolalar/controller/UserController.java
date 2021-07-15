package uz.pdp.news_maqolalar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.payload.UserDto;
import uz.pdp.news_maqolalar.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody UserDto userDto) {
        Responce responce = userService.register(userDto);
        return ResponseEntity.status(responce.isSucces()?200:409).body(responce);
    }


}
