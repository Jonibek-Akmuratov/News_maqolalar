package uz.pdp.news_maqolalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.news_maqolalar.entity.User;
import uz.pdp.news_maqolalar.exeptions.ResouceNotFoundExeption;
import uz.pdp.news_maqolalar.payload.RegisterDto;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.payload.UserDto;
import uz.pdp.news_maqolalar.repository.RoleRepository;
import uz.pdp.news_maqolalar.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    public Responce register(UserDto userDto) {

        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber()))
            return new Responce("Bunday nomerli user avval ro'yxatdan o'tgan", false);
        if (!userDto.getPhoneNumber().substring(0, 4).equals("+998"))
            return new Responce("Phone Numberni '+998 xx xxx xx xx' korinishda yozish", false);
        if (!(userDto.getPhoneNumber().length() == 13))
            return new Responce("Phone Numberni yozishda xatolik.Nomerizni tekshirib koring !!!", false);


        User user = new User(
                userDto.getFullname(),
                userDto.getUsername(),
                userDto.getPhoneNumber(),
                passwordEncoder.encode(userDto.getPassword()),
                roleRepository.findById(userDto.getRoleId()).orElseThrow(() -> new ResouceNotFoundExeption("USER", "name", "USER")),
                true
        );
        User save = userRepository.save(user);
        return new Responce("User muvaffaqiyatli saqlandi", true, save);
    }


}
