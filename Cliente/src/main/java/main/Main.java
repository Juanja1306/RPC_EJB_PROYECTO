package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import model.Usuario;
import service.ServicioUsuarioRemoto;

public class Main {

    private ServicioUsuarioRemoto UsuarioRemoto;
    private List<Usuario> usuarios;
    private JFrame frame;
    private JTextField cedulaField, nombreField, correoField, celularField, autoField, sangreField;
    private JTextArea textArea;

    public Main() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Registro de Usuario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(7, 2));
        frame.add(panel, BorderLayout.NORTH);

        panel.add(new JLabel("Cédula:"));
        cedulaField = new JTextField(10);
        panel.add(cedulaField);

        panel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(10);
        panel.add(nombreField);

        panel.add(new JLabel("Correo:"));
        correoField = new JTextField(10);
        panel.add(correoField);

        panel.add(new JLabel("Celular:"));
        celularField = new JTextField(10);
        panel.add(celularField);

        panel.add(new JLabel("Auto:"));
        autoField = new JTextField(10);
        panel.add(autoField);

        panel.add(new JLabel("Sangre:"));
        sangreField = new JTextField(10);
        panel.add(sangreField);

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    registrarUser(cedulaField.getText(), nombreField.getText(), correoField.getText(), 
                                  celularField.getText(), autoField.getText(), sangreField.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(registerButton);

        JButton listButton = new JButton("Listar");
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    listar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(listButton);

        textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void inicializar() throws Exception {
        Hashtable<String, Object> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        try {
            Context context = new InitialContext(jndiProperties);
            UsuarioRemoto = (ServicioUsuarioRemoto) context.lookup("ejb:/Server/ServicioUsuario!service.ServicioUsuarioRemoto");
        } catch (Exception e) {
            textArea.append("Error al inicializar JNDI: " + e.toString() + "\n");
        }
    }

    public void registrarUser(String cedula, String nombre, String correo, String celular, String auto, String sangre) throws Exception {
    	textArea.setText("");
    	if(!cedula.isEmpty()) {
    		try {
        		Usuario usuario = new Usuario();
                usuario.setCedula(cedula);
                usuario.setNombre(nombre);
                usuario.setCorreo(correo);
                usuario.setCelular(celular);
                usuario.setAuto(auto);
                usuario.setSangre(sangre);

                UsuarioRemoto.crearUsuario(usuario);
                textArea.append("Usuario creado con éxito: " + nombre + "\n");
                
             // Limpiar los campos después del registro
                cedulaField.setText("");
                nombreField.setText("");
                correoField.setText("");
                celularField.setText("");
                autoField.setText("");
                sangreField.setText("");
        	} catch(Exception e) {
        		
                textArea.append("Error al crear el usuario, ingrese otra cedula diferente de: " + cedula + "\n");
                
             // Limpiar los campos después del registro
                cedulaField.setText("");
        		
        	}
    	} else {
    		textArea.append("Error al crear el usuario, ingrese el usuario correctamente");
    	}
    	
    	
    }

    public void listar() throws Exception {
    	textArea.setText("");
        usuarios = UsuarioRemoto.listarUsuarios();
        
        if(usuarios.isEmpty()) {
        	textArea.append("No hay registros de Usuarios:\n");
        }else {
        	for (Usuario usuario : usuarios) {
        		textArea.append("Listado de Usuarios:\n");
                textArea.append("Cedula: " + usuario.getCedula() + ", Nombre: " + usuario.getNombre() + 
                                ", Correo: " + usuario.getCorreo() + ", Celular: " + usuario.getCelular() +
                                ", Auto: " + usuario.getAuto() + ", Sangre: " + usuario.getSangre() + "\n");
            }
        }
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main main = new Main();
                    main.inicializar();
                } catch (Exception e) {
                    System.out.println("Error durante la ejecución: " + e.toString());
                }
            }
        });
    }
}
