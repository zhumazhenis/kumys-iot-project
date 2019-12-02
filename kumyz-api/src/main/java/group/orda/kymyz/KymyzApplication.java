package group.orda.kymyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KymyzApplication {

    public static void main(String[] args) {
        SpringApplication.run(KymyzApplication.class, args);
    }

}
