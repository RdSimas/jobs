package spring.restapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VotacaoApplication {

	private static final Logger log = LoggerFactory.getLogger(VotacaoApplication.class);

	@Value("${mensagem.inicializacao}")
	private String mensagemInicializacao;

	public static void main(String[] args) {
		SpringApplication.run(VotacaoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			log.info(this.mensagemInicializacao);
		};
	}

}
