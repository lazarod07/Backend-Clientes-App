package com.lazarod.springboot.backend.apirest.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lazarod.springboot.backend.apirest.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

}
