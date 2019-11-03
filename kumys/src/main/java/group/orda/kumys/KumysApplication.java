package group.orda.kumys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KumysApplication {

	public static void main(String[] args) {
		SpringApplication.run(KumysApplication.class, args);
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("Test OK");
	}
}
