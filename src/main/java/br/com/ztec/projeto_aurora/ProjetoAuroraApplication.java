package br.com.ztec.projeto_aurora;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.ztec.projeto_aurora"})
public class ProjetoAuroraApplication {
	
	private static final Logger _logger = LoggerFactory.getLogger(ProjetoAuroraApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjetoAuroraApplication.class, args);
		
		_logger.info("**********************************************************");
		_logger.info("******* PROJETO AURORA - MODULO CADASTRO DE USUARIO ******");	
		_logger.info("**********************************************************");	
	}

}
