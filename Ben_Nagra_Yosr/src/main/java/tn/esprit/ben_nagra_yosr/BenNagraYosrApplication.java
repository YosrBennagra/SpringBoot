package tn.esprit.ben_nagra_yosr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BenNagraYosrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BenNagraYosrApplication.class, args);
	}

}
