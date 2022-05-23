package controlador;

import modelo.ControladorBDImplementacion;
import modelo.ControladorDatos;
import vista.InicioSesion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControladorDatos datos= new ControladorBDImplementacion();
		
		InicioSesion inicio= new InicioSesion();
		inicio.setVisible(true);
	}

}
