package spring.restapp;

import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.model.Pauta;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.repository.PautaRepository;
import spring.restapp.repository.SessaoVotacaoRepository;
import spring.restapp.service.PautaService;
import spring.restapp.service.SessaoVotacaoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessaoVotacaoServiceTests {
	
	@Autowired
	private PautaService pautaService;
	
	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;
	
	@MockBean
	private PautaRepository pautaRepository;
	
	@MockBean
	private SessaoVotacaoRepository sessaoVotacaoRepository;
 	
    @Test
    public void quandoCarregamosUmaSessaoVotacao() {
    	Optional<SessaoVotacao> sessaoVotacaoMock = Optional.of(new SessaoVotacao(1l));
    	
    	Mockito.when(sessaoVotacaoService.findById(1l)).thenReturn(sessaoVotacaoMock);
    	
    	Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoService.findById(1l);
        
        Assertions.assertThat(sessaoVotacao).isEqualTo(sessaoVotacaoMock);
     }
    
    @Test
    public void quandoInserimosUmaSessaoVotacao() {
    	SessaoVotacao sessaoVotacaoMock = new SessaoVotacao(1l, new Pauta(1l), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10l));
    	
    	Mockito.when(pautaService.existePauta(sessaoVotacaoMock.getPauta().getId())).thenReturn(Boolean.TRUE);
    	Mockito.when(sessaoVotacaoService.persistirSessaoVotacao(sessaoVotacaoMock)).thenReturn(sessaoVotacaoMock);
    	
    	SessaoVotacao sessaoVotacao = sessaoVotacaoService.persistirSessaoVotacao(sessaoVotacaoMock);
    	
    	Assertions.assertThat(sessaoVotacao.getId()).isEqualTo(sessaoVotacaoMock.getId());
    	Assertions.assertThat(sessaoVotacao.getPauta()).isEqualTo(sessaoVotacaoMock.getPauta());
    	Assertions.assertThat(sessaoVotacao.getInicio()).isEqualTo(sessaoVotacaoMock.getInicio());
    	Assertions.assertThat(sessaoVotacao.getFim()).isEqualTo(sessaoVotacaoMock.getFim());
    }
    
    @Test(expected = PautaNaoEncontradaException.class)
    public void quandoInserimosUmaSessaoVotacaoRelacionadoComUmaPautaInexistente() {
    	SessaoVotacao sessaoVotacaoMock = new SessaoVotacao(1l, new Pauta(1l), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10l));
    	
    	Mockito.when(pautaService.existePauta(sessaoVotacaoMock.getPauta().getId())).thenReturn(Boolean.FALSE);
    	Mockito.when(sessaoVotacaoService.persistirSessaoVotacao(sessaoVotacaoMock)).thenThrow(PautaNaoEncontradaException.class);
     }

    @Test
    public void quandoVerificamosSeSessaoEstaAberta() {
    	SessaoVotacao sessaoAberta = new SessaoVotacao(1l, new Pauta(1l), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10l));
    	SessaoVotacao sessaoFechada = new SessaoVotacao(1l, new Pauta(1l), LocalDateTime.now().plusMinutes(1l), LocalDateTime.now().plusMinutes(10l));
    	Assertions.assertThat(sessaoAberta.sessaoAberta()).isEqualTo(Boolean.TRUE);
    	Assertions.assertThat(sessaoFechada.sessaoAberta()).isEqualTo(Boolean.FALSE);
    }
    
}
