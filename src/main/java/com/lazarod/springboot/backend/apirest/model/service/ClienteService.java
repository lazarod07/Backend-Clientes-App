package com.lazarod.springboot.backend.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lazarod.springboot.backend.apirest.model.dao.IClienteDao;
import com.lazarod.springboot.backend.apirest.model.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {

		return clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {

		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {

		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		clienteDao.deleteById(id);

	}

}
