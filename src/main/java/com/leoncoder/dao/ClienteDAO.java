package com.leoncoder.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import leon.coder.model.Cliente;
import leon.coder.model.JPAUtil;

public class ClienteDAO {
	
	EntityManager entity = JPAUtil.gEntityManagerFactory().createEntityManager();
	
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
	}
	
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();

	}
	
	public Cliente buscarPorId(Long id) {
		Cliente cliente = new Cliente();
		
		cliente = entity.find(Cliente.class, id);		
		return cliente;
	}
	
	public List<Cliente> obtenerClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>() ;
		
		Query query = entity.createQuery("SELECT c FROM Cliente c");
		clientes = query.getResultList();
		
		return clientes;
	}
	
	public void eliminar(Long id) {
		Cliente cliente = new Cliente();
		
		cliente = entity.find(Cliente.class, id);	
		
		entity.getTransaction().begin();
		entity.remove(cliente);
		entity.getTransaction().commit();
	}
}
