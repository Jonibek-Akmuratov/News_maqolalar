package uz.pdp.news_maqolalar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.news_maqolalar.payload.RegisterDto;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/register")
    public HttpEntity<?> register(@Valid @RequestBody RegisterDto registerDto) {
        Responce responce = authService.register(registerDto);
        return ResponseEntity.status(responce.isSucces()?200:409).body(responce);
    }


}
