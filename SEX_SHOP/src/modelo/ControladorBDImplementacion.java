package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import clases.Persona;

public class ControladorBDImplementacion {

	//Atributos
		private Connection con;
		private PreparedStatement stmt;
		
		
		//Estos atributos son los necesarios para recoger los valores del fichero de configuracion
		private ResourceBundle configFichero;
		
		private String driverBD;
		private String urlBD;
		private String userBD;
		private String passwordBD;
		
		//Sentencias sql
		final String INSERTpersona = "INSERT INTO persona (codUsuario, nombre, apellido, email, contrasena, tipo) VALUES (?, ?, ?, ?, ?,?)";
		
		// Para la conexión utilizamos un fichero de configuaración, configuracion que
			// guardamos en el paquete control:
		
		public ControladorBDImplementacion() {
				this.configFichero = ResourceBundle.getBundle("modelo.configuracion");
				this.driverBD = this.configFichero.getString("Driver");
				this.urlBD = this.configFichero.getString("Conn");
				this.userBD = this.configFichero.getString("DBUser");
				this.passwordBD = this.configFichero.getString("DBPass");
			}

			private void openConnection() {
				try {
					//Class.forName(this.driverBD);
					con =  DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
				} catch (SQLException e) {
					System.out.println("Error al intentar abrir la BD");
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println("Se ha abierto la base de datos");
					e.printStackTrace();
				}
			}

			private void closeConnection() throws SQLException {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null)
					con.close();
			}

			public void insertarPersona(Persona pers) {
				this.openConnection();
				
				try {
					stmt = con.prepareStatement(INSERTpersona); //Cargamos el insert de persona con el stmt
					
					stmt.setString(1, "1");
					stmt.setString(2, pers.getNombre());
					stmt.setString(3, pers.getApellido());
					stmt.setString(4, pers.getEmail());
					stmt.setString(5, pers.getContrasena());
					stmt.setString(6, "c");
					
					stmt.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
}
