package uz.pdp.news_maqolalar.exeptions;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@AllArgsConstructor
public class ResouceNotFoundExeption extends RuntimeException {

    private final String recourceName;    //Role;
    private final String recourceField;   //name;
    private final Object object;          // USER  ADMIN;

}
