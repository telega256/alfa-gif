package alfagif.ru.alfagif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlfaGifApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlfaGifApplication.class, args);
	}

}
