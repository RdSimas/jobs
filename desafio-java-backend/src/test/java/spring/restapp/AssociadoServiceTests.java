package spring.restapp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.restapp.model.Associado;
import spring.restapp.repository.AssociadoRepository;
import spring.restapp.service.AssociadoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociadoServiceTests {
	
	@Autowired
	private AssociadoService associadoService;
	
	@MockBean
	private AssociadoRepository associadoRepository;
 	
	@Test
    public void quandoVerificamosExistenciaDeUmAssociado() {
    	Associado associadoMock = new Associado(1l, "nome", "login", "senha");
    	
    	Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.TRUE);
    	
    	Boolean existe = associadoService.existeAssociado(associadoMock);
        
        Assertions.assertThat(existe).isEqualTo(Boolean.TRUE);
     }
    
    @Test
    public void quandoInserimosUmAssociado() {
    	Associado associadoMock = new Associado(1l, "nome", "login", "senha");
    	
    	Mockito.when(associadoService.persistirAssociado(associadoMock)).thenReturn(associadoMock);
    	
    	Associado associado = associadoService.persistirAssociado(associadoMock);
    	
    	Assertions.assertThat(associado.getId()).isEqualTo(associadoMock.getId());
    	Assertions.assertThat(associado.getNome()).isEqualTo(associadoMock.getNome());
    	Assertions.assertThat(associado.getLogin()).isEqualTo(associadoMock.getLogin());
    	Assertions.assertThat(associado.getSenha()).isEqualTo(associadoMock.getSenha());
     }
    
    

}
