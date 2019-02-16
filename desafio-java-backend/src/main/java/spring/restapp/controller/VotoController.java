package spring.restapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.restapp.dto.PersistirVotoDTO;
import spring.restapp.model.Voto;
import spring.restapp.response.Response;
import spring.restapp.service.VotoService;

@RestController
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoService votoService;

	@ResponseBody
	@PostMapping(path = "/persistir", produces = "application/json")
	public ResponseEntity<Response<Voto>> persistir(@Valid @RequestBody PersistirVotoDTO votoDto,
			BindingResult result) {
		Response<Voto> response = new Response<>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		return ResponseEntity.ok(votoService.persistirVoto(votoDto.toVoto()));
	}

	@ResponseBody
	@GetMapping(value = "/recuperar/{idPauta}", produces = "application/json")
	public ResponseEntity<Response<List<Voto>>> recuperarByPauta(@PathVariable("idPauta") Long idPauta) {
		return ResponseEntity.ok(votoService.recuperarByPauta(idPauta));
	}

}
