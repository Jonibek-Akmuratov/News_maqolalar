package uz.pdp.news_maqolalar.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotNull(message = "Full Name bo'sh bo'lmasin")
    private String fullname;
    @NotNull(message = "User Name bo'sh bo'lmasin")
    private String username;
    @NotNull(message = "Password bo'sh bo'lmasin")
    private String password;
    @NotNull(message = "Prepassword bo'sh bo'lmasin")
    private String prePassword;

    @NotNull(message = "Phone Number bo'sh bo'lmasin")
    private String phoneNumber;

}
