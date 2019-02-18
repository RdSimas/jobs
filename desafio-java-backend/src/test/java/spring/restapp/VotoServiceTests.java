package spring.restapp;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.restapp.exception.AssociadoJaVotouException;
import spring.restapp.exception.AssociadoNaoEncontradoException;
import spring.restapp.exception.PautaNaoEncontradaException;
import spring.restapp.exception.PautaSemVotosException;
import spring.restapp.exception.SessaoVotacaoIndisponivelException;
import spring.restapp.exception.SessaoVotacaoNaoEncontradaException;
import spring.restapp.model.Associado;
import spring.restapp.model.Pauta;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.model.Voto;
import spring.restapp.model.enums.VotoEnum;
import spring.restapp.repository.AssociadoRepository;
import spring.restapp.repository.PautaRepository;
import spring.restapp.repository.SessaoVotacaoRepository;
import spring.restapp.repository.VotoRepository;
import spring.restapp.service.AssociadoService;
import spring.restapp.service.PautaService;
import spring.restapp.service.SessaoVotacaoService;
import spring.restapp.service.VotoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VotoServiceTests {

	@Autowired
	private VotoService votoService;
	
	@Autowired
	private AssociadoService associadoService;

	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;

	@Autowired
	private PautaService pautaService;
	
	@MockBean
	private PautaRepository pautaRepository;
	
	@MockBean
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	@MockBean
	private AssociadoRepository associadoRepository;

	@MockBean
	private VotoRepository votoRepository;

	@Test
	public void quandoInserimosUmVoto() {
		Associado associadoMock = new Associado(10l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, new Pauta(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		Voto votoMock = new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock);

		Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.findById(sessaoMock.getId())).thenReturn(Optional.of(sessaoMock));
		Mockito.when(votoService.existeVoto(associadoMock, sessaoMock.getPauta())).thenReturn(Boolean.FALSE);
		Mockito.when(votoService.persistirVoto(votoMock)).thenReturn(votoMock);

		Voto voto = votoService.persistirVoto(votoMock);

		Assertions.assertThat(voto.getId()).isEqualTo(votoMock.getId());
		Assertions.assertThat(voto.getValor()).isEqualTo(votoMock.getValor());
		Assertions.assertThat(voto.getAssociado()).isEqualTo(associadoMock);
		Assertions.assertThat(voto.getSessao()).isEqualTo(sessaoMock);
	}
	
	@Test(expected = AssociadoNaoEncontradoException.class)
	public void quandoInserimosUmVotoRelacionadoComUmAssociadoInexistente() {
		Associado associadoMock = new Associado(10l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, new Pauta(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		Voto votoMock = new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock);

		Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.FALSE);
		Mockito.when(votoService.persistirVoto(votoMock)).thenThrow(AssociadoNaoEncontradoException.class);
	}
	
	
	@Test(expected = SessaoVotacaoNaoEncontradaException.class)
	public void quandoInserimosUmVotoRelacionadoComUmaSessaoInexistente() {
		Associado associadoMock = new Associado(10l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, new Pauta(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		Voto votoMock = new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock);

		Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.findById(sessaoMock.getId())).thenReturn(Optional.empty());
		Mockito.when(votoService.persistirVoto(votoMock)).thenThrow(SessaoVotacaoNaoEncontradaException.class);
	}
	
	@Test(expected = SessaoVotacaoIndisponivelException.class)
	public void quandoInserimosUmVotoRelacionadoComUmaSessaoIndisponivel() {
		Associado associadoMock = new Associado(10l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, new Pauta(), LocalDateTime.now().plusMinutes(10), LocalDateTime.now().plusMinutes(50));
		Voto votoMock = new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock);

		Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.findById(sessaoMock.getId())).thenReturn(Optional.of(sessaoMock));
		Mockito.when(votoService.persistirVoto(votoMock)).thenThrow(SessaoVotacaoIndisponivelException.class);
	}
	
	@Test(expected = AssociadoJaVotouException.class)
	public void quandoInserimosUmVotoRelacionadoComUmAssociadoQueJaVotou() {
		Associado associadoMock = new Associado(10l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, new Pauta(), LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		Voto votoMock = new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock);

		Mockito.when(associadoService.existeAssociado(associadoMock)).thenReturn(Boolean.TRUE);
		Mockito.when(sessaoVotacaoService.findById(sessaoMock.getId())).thenReturn(Optional.of(sessaoMock));
		Mockito.when(votoService.existeVoto(associadoMock, sessaoMock.getPauta())).thenReturn(Boolean.TRUE);
		Mockito.when(votoService.persistirVoto(votoMock)).thenThrow(AssociadoJaVotouException.class);
	}
	
	@Test
	public void quandoRecuperamosVotosAtravesDeUmaPauta() {
		Pauta pautaMock = new Pauta(1l);
		SessaoVotacao sessaoMock = new SessaoVotacao(1l, pautaMock, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10));
		Associado associadoMock = new Associado(1l, "nome", "login", "senha");
		Associado associadoMock2 = new Associado(2l, "nome2", "login2", "senha2");
		
		List<Voto> votosMock = Arrays.asList(new Voto(1l, VotoEnum.SIM, associadoMock, sessaoMock), new Voto(2l, VotoEnum.NAO, associadoMock2, sessaoMock));
		
		Mockito.when(pautaService.existePauta(pautaMock.getId())).thenReturn(Boolean.TRUE);
		Mockito.when(votoRepository.recuperarByPauta(pautaMock.getId())).thenReturn(votosMock);
		
		List<Voto> votos = votoRepository.recuperarByPauta(pautaMock.getId());
		
		Assertions.assertThat(votos.get(0).getId()).isEqualTo(votosMock.get(0).getId());
		Assertions.assertThat(votos.get(0).getValor()).isEqualTo(votosMock.get(0).getValor());
		Assertions.assertThat(votos.get(0).getAssociado()).isEqualTo(votosMock.get(0).getAssociado());
		Assertions.assertThat(votos.get(0).getSessao()).isEqualTo(votosMock.get(0).getSessao());
		Assertions.assertThat(votos.get(1).getId()).isEqualTo(votosMock.get(1).getId());
		Assertions.assertThat(votos.get(1).getValor()).isEqualTo(votosMock.get(1).getValor());
		Assertions.assertThat(votos.get(1).getAssociado()).isEqualTo(votosMock.get(1).getAssociado());
		Assertions.assertThat(votos.get(1).getSessao()).isEqualTo(votosMock.get(1).getSessao());
	}
	
	@Test(expected = PautaNaoEncontradaException.class)
	public void quandoRecuperamosVotosAtravesDeUmaPautaInexistente() {
		Pauta pautaMock = new Pauta(1l);
		
		Mockito.when(pautaService.existePauta(pautaMock.getId())).thenReturn(Boolean.FALSE);
		Mockito.when(votoService.recuperarByPauta(pautaMock.getId())).thenThrow(PautaNaoEncontradaException.class);
	}
	
	@Test(expected = PautaSemVotosException.class)
	public void quandoRecuperamosVotosAtravesDeUmaPautaSemVotos() {
		Pauta pautaMock = new Pauta(1l);
		
		Mockito.when(pautaService.existePauta(pautaMock.getId())).thenReturn(Boolean.TRUE);
		Mockito.when(votoRepository.recuperarByPauta(pautaMock.getId())).thenReturn(null);
		Mockito.when(votoService.recuperarByPauta(pautaMock.getId())).thenThrow(PautaSemVotosException.class);
	}

}
