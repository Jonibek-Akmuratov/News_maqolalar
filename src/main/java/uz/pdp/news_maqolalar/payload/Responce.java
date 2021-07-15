package uz.pdp.news_maqolalar.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responce {

    private String message;

    private boolean succes;

    private Object object;

    public Responce(String message, boolean succes) {
        this.message = message;
        this.succes = succes;
    }
}
