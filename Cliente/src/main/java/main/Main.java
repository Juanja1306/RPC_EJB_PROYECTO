package main;


import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import model.Usuario;
import service.ServicioUsuarioRemoto;

public class Main {

	private ServicioUsuarioRemoto UsuarioRemoto;
	private List<Usuario> usuarios;

	public void inicializar() throws Exception {
		Hashtable<String, Object> jndiProperties = new Hashtable<String, Object>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		
		try {
			Context context = new InitialContext(jndiProperties);
			UsuarioRemoto = (ServicioUsuarioRemoto) context
					.lookup("ejb:/Server/ServicioUsuario!service.ServicioUsuarioRemoto");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	
	public void registrarUser(String cedula, String nombre, String correo, String celular, String auto, String sangre) throws Exception{
		Usuario usuario = new Usuario();
		usuario.setCedula(cedula);
		usuario.setNombre(nombre);
		usuario.setCorreo(correo);
		usuario.setCelular(celular);
		usuario.setAuto(auto);
		usuario.setSangre(sangre);
		
		UsuarioRemoto.crearUsuario(usuario);
		System.out.println("Usuario creado con exito");
	}
	
	public void listar() throws Exception{
		usuarios = UsuarioRemoto.listarUsuarios();
		
		for(Usuario usuario : usuarios) {
			System.out.println(usuario.getCedula());
			System.out.println(usuario.getNombre());
			System.out.println(usuario.getCorreo());
			System.out.println(usuario.getCelular());
			System.out.println(usuario.getAuto());
			System.out.println(usuario.getSangre());
		}
	}
	
	public static void main(String[] args) {
		try {
			Main main = new Main();
			main.inicializar();
			main.registrarUser("0104435567", "Juan Malo", "Juanja@gmail.com", "0989776543", "Mercedes", "A-");
			System.out.println("------------------------------------------------------------------------------------------------");
			main.listar();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

}