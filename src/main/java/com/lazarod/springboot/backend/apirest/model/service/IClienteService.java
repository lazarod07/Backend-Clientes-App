package com.lazarod.springboot.backend.apirest.model.service;

import java.util.List;

import com.lazarod.springboot.backend.apirest.model.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public Cliente save(Cliente cliente);

	public Cliente findById(Long id);

	public void delete(Long id);

}
