package uz.pdp.news_maqolalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.news_maqolalar.entity.Role;
import uz.pdp.news_maqolalar.entity.User;
import uz.pdp.news_maqolalar.exeptions.ResouceNotFoundExeption;
import uz.pdp.news_maqolalar.payload.RegisterDto;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.repository.RoleRepository;
import uz.pdp.news_maqolalar.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    public Responce register(RegisterDto registerDto) {

        if (userRepository.existsByPhoneNumber(registerDto.getPhoneNumber()))
            return new Responce("Bunday nomerli user avval ro'yxatdan o'tgan", false);
        if (!registerDto.getPhoneNumber().substring(0, 4).equals("+998"))
            return new Responce("Phone Numberni '+998 xx xxx xx xx' korinishda yozish", false);
        if (!(registerDto.getPhoneNumber().length() == 13))
            return new Responce("Phone Numberni yozishda xatolik.Nomerizni tekshirib koring !!!", false);


        User user = new User(
                registerDto.getFullname(),
                registerDto.getUsername(),
                registerDto.getPhoneNumber(),
                passwordEncoder.encode(registerDto.getPassword()),
                roleRepository.findById(2).orElseThrow(() -> new ResouceNotFoundExeption("USER", "name", "USER")),
                true
        );
        User save = userRepository.save(user);
        return new Responce("User muvaffaqiyatli ro'yxatdan otdi :)", true, save);
    }


    public UserDetails loadUserByUsername(String userName) {
        return userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));


    }
}
