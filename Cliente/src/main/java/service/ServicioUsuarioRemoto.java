package service;


import java.util.List;

import model.Usuario;

import jakarta.ejb.Remote;

@Remote
public interface ServicioUsuarioRemoto {

	void crearUsuario(Usuario usuario) throws Exception;
	List<Usuario> listarUsuarios() throws Exception;
}