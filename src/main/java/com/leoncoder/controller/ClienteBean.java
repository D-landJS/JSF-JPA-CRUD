package com.leoncoder.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.leoncoder.dao.ClienteDAO;

import leon.coder.model.Cliente;

@ManagedBean(name="clienteBean")
@RequestScoped
public class ClienteBean {
	
	public String nuevo() {
		
		Cliente cliente = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", cliente);
		return "/faces/crear.xhtml";
	}
	
	public String crear(Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Date fechaActual = new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));
		clienteDAO.guardar(cliente);
		
		return "/faces/index.xhtml";
	}
	
	public List<Cliente> obtenerClientes(){
		
		ClienteDAO cDao = new ClienteDAO();
		
		return cDao.obtenerClientes();
		
//		List<Cliente> listaClientes = new ArrayList<>();
//		Cliente cliente1 = new Cliente();2
//		cliente1.setId(1L);
//		cliente1.setNombre("D-land");
//		cliente1.setApellidos("Ar");
//		cliente1.setDireccion("lujan");
//		Cliente cliente2 = new Cliente();
//		cliente2.setId(1L);
//		cliente2.setNombre("Dalas");
//		cliente2.setApellidos("Ree");
//		cliente2.setDireccion("X");
//		listaClientes.add(cliente1);
//		listaClientes.add(cliente2);
//		return listaClientes;
	}
	
	public String editar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscarPorId(id);
		System.out.println(c);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c) ;
		return "/faces/editar.xhtml";
	}
	
	public String actualizar(Cliente c) {
		ClienteDAO cDao = new ClienteDAO();
		Date fechaActual = new Date();
		c.setFactualizar(new java.sql.Date(fechaActual.getTime()));
		cDao.editar(c);
		
		return "/faces/index.xhtml";
	}
	
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminar(id);
		System.out.println("Cliente elimnado!");
		return "/faces/index.xhtml";
	}
}
