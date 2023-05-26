package home.bruce.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Dog {
    private int id;
    private String name;
}
