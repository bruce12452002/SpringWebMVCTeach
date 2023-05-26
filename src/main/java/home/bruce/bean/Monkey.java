package home.bruce.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Monkey {
    private int id;
    private String name;
    private Dog dog;
}
