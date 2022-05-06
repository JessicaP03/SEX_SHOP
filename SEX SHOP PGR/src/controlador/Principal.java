package controlador;

import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;
import vista.InicioSesion;

public class Principal {

	public static void main(String[] args) {
	ControladorDatos datos = new ControladorBDImplementacion();
	
	//Pantallas
	InicioSesion ventanaPrincipal = new InicioSesion(datos);
	ventanaPrincipal.setVisible(true);
	
	}
}
