package spring.restapp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.restapp.model.Pauta;
import spring.restapp.repository.PautaRepository;
import spring.restapp.service.PautaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PautaServiceTests {
	
		@Autowired
		private PautaService pautaService;
		
		@MockBean
		private PautaRepository pautaRepository;
	 	
	    @Test
	    public void quandoVerificamosExistenciaDeUmaPauta() {
	    	Pauta pautaMock = new Pauta(1l, "pauta");
	    	
	    	Mockito.when(pautaService.existePauta(pautaMock.getId())).thenReturn(Boolean.TRUE);
	    	Mockito.when(pautaService.existePauta(pautaMock)).thenReturn(Boolean.TRUE);
	    	
	    	Boolean existe = pautaService.existePauta(pautaMock);
	        Boolean existeById = pautaService.existePauta(pautaMock.getId());
	        
	        Assertions.assertThat(existe).isEqualTo(Boolean.TRUE);
	        Assertions.assertThat(existeById).isEqualTo(Boolean.TRUE);
	     }
	    
	    @Test
	    public void quandoInserimosUmaPauta() {
	    	Pauta pautaMock = new Pauta(1l, "pauta");
	    	
	    	Mockito.when(pautaService.persistirPauta(pautaMock)).thenReturn(pautaMock);
	    	
	    	Pauta pauta = pautaService.persistirPauta(pautaMock);
	    	
	    	Assertions.assertThat(pauta.getId()).isEqualTo(pautaMock.getId());
	    	Assertions.assertThat(pauta.getDescricao()).isEqualTo(pautaMock.getDescricao());
	     }

}

