package spring.restapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.restapp.Response.Response;
import spring.restapp.dto.PersistirSessaoVotacaoDTO;
import spring.restapp.model.SessaoVotacao;
import spring.restapp.service.SessaoVotacaoService;

@RestController
@RequestMapping("/sessaoVotacao")
public class SessaoVotacaoController {
	
	@Autowired
	private SessaoVotacaoService sessaoVotacaoService;
	
	@ResponseBody
	@PostMapping(path = "/persistir", produces = "application/json")
	public ResponseEntity<Response<SessaoVotacao>> persistir(@Valid @RequestBody PersistirSessaoVotacaoDTO sessaoVotacaoDto, BindingResult result) {
		Response<SessaoVotacao> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		SessaoVotacao sessaoVotacao = sessaoVotacaoService.persistirSessaoVotacao(sessaoVotacaoDto.toSessaoVotacao());
		response.setData(sessaoVotacao);
		
		return ResponseEntity.ok(response);
	}

}
