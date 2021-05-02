package com.lazarod.springboot.backend.apirest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lazarod.springboot.backend.apirest.model.entity.Cliente;
import com.lazarod.springboot.backend.apirest.model.service.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index() {

		return clienteService.findAll();

	}

	@GetMapping("clientes/{id}")
	public Cliente show(@PathVariable Long id) {

		return clienteService.findById(id);
	}

	@PostMapping("clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {

		return clienteService.save(cliente);
	}

	@PutMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {

		Cliente clienteDb = clienteService.findById(id);

		clienteDb.setNombre(cliente.getNombre());

		clienteDb.setApellido(cliente.getApellido());

		clienteDb.setEmail(cliente.getEmail());

		return clienteService.save(clienteDb);
	}

	@DeleteMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		clienteService.delete(id);
	}

}
