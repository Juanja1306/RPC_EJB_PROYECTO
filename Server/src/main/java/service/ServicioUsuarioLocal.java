package service;

import java.util.List;

import model.Usuario;

import jakarta.ejb.Local;

@Local
public interface ServicioUsuarioLocal {
		
	void crearUsuario(Usuario usuario);
	List<Usuario> listarUsuarios();
}