package controller;


import model.Usuario;
import service.ServicioUsuarioLocal;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Controlador {

	@EJB
	private ServicioUsuarioLocal userService;

	private Usuario usuario;

	@PostConstruct
	public void initNewUser() {
		usuario = new Usuario();
	}

	public void crearUsuario() {
		try {
			userService.crearUsuario(usuario);
			System.out.println("user created successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public Usuario getnUser() {
		return usuario;
	}

	public void setnUser(Usuario usuario) {
		this.usuario = usuario;
	}

}