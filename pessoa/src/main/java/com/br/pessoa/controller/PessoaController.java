package com.br.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pessoa.model.Pessoa;
import com.br.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> buscarTodos() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Pessoa buscar(@PathVariable ("id") Integer id) {
		return pessoaRepository.findOne(id);
	}

	@PostMapping
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@PutMapping
	public Pessoa atualizar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable("id") Integer id) {
		pessoaRepository.delete(id);
	}
}
