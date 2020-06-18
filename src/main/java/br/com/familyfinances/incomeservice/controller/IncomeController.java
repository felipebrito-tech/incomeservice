package br.com.familyfinances.incomeservice.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.familyfinances.incomeservice.dto.IncomeDto;
import br.com.familyfinances.incomeservice.model.Income;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

	@GetMapping
	public String list() {
		return "Funcionou!";
	}

	@GetMapping("/{id}")
	public String details(Long id) {
		return "Funcionou!";
	}

	@PostMapping
	public ResponseEntity<IncomeDto> create(UriComponentsBuilder uriBuilder) {
		URI uri = uriBuilder.path("/list").build().toUri();

		return ResponseEntity.created(uri).body(new IncomeDto(new Income()));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<IncomeDto> remove(UriComponentsBuilder uriBuilder) {
		IncomeDto incomeDto = new IncomeDto(new Income());
		incomeDto.setTithingStatus(true);

		return ResponseEntity.ok(incomeDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Long> update(UriComponentsBuilder uriBuilder) {
		return ResponseEntity.ok(1L);
	}
}
