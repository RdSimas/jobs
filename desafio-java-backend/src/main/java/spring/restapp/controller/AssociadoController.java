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
import spring.restapp.dto.PersistirAssociadoDTO;
import spring.restapp.model.Associado;
import spring.restapp.service.AssociadoService;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
	
	@Autowired
	private AssociadoService associadoService;
	
	@ResponseBody
	@PostMapping(path = "/persistir", produces = "application/json")
	public ResponseEntity<Response<Associado>> persistir(@Valid @RequestBody PersistirAssociadoDTO associadoDto, BindingResult result) {
		Response<Associado> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Associado associado = associadoService.persistirAssociado(associadoDto.toAssociado());
		response.setData(associado);
		
		return ResponseEntity.ok(response);
	}

}
