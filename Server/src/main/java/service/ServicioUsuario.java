package service;

import java.util.List;

import model.Usuario;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ServicioUsuario implements ServicioUsuarioLocal, ServicioUsuarioRemoto{
	
	@PersistenceContext
	private EntityManager em;
	
	private List<Usuario> Usuarios;

	@Override
	public void crearUsuario(Usuario user) {
		// TODO Auto-generated method stub
		em.persist(user);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		String jpql = "SELECT c FROM Usuario c";
		Query query = em.createQuery(jpql, Usuario.class);
		Usuarios = query.getResultList();
		return Usuarios;
	}

}