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
import spring.restapp.dto.PersistirPautaDTO;
import spring.restapp.model.Pauta;
import spring.restapp.service.PautaService;


@RestController
@RequestMapping("/pauta")
public class PautaController {
	
	@Autowired
	private PautaService pautaService;
	
	@ResponseBody
	@PostMapping(path = "/persistir", produces = "application/json")
	public ResponseEntity<Response<Pauta>> cadastrar(@Valid @RequestBody PersistirPautaDTO pautaDto, BindingResult result) {
		Response<Pauta> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Pauta pauta = pautaService.persistirPauta(pautaDto.toPauta());
		response.setData(pauta);
		
		return ResponseEntity.ok(response);
	}

}
