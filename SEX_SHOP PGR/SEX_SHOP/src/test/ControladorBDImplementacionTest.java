package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import clases.Empleado;
import clases.Persona;
import clases.Producto;
import modelo.ControladorBDImplementacion;

class ControladorBDImplementacionTest {

	ControladorBDImplementacion controladorBD = new ControladorBDImplementacion();

	@Test
	void testInsertarPersona() {
		String nombre= "fernando";
		String apellido= "gonzales";
		String email= "fernando@gmail.com";
		String contrasena= "abcd*1234";
		
		Persona pers= new Persona(1, nombre, apellido, email, contrasena, "CLIENTE");
		assertTrue(controladorBD.insertarPersona(pers));
		

	}

	@Test
	void testExistePersona() {
		assertEquals(controladorBD.existePersona("June"), 1);
		
	}

	@Test
	void testExisteProducto() {
		assertEquals(controladorBD.existeProducto("JJ1"), 1);
	}

	@Test
	void testInsertarProducto() {
		String IdProducto= "LL5";
		String NombreProd= "Consolador";
		String Categoria= "Juguete";
		String Sexo= "hombre";
		int Precio= 20;
		String tipo= "vibrador";
		
		Producto prod = new Producto(IdProducto, NombreProd, Categoria, Sexo, Precio, tipo);
		assertTrue(controladorBD.insertarProducto(prod));
	}

	@Test
	void testModificarProducto() {
		
		String IdProducto= "LL5";
		String NombreProd= "gfdhs";
		String Categoria= "Lenceria";
		String Sexo= "hombre";
		int Precio= 20;
		String tipo= "vibrador";
		
		Producto prod = new Producto(IdProducto, NombreProd, Categoria, Sexo, Precio, tipo);
		assertTrue(controladorBD.modificarProducto(prod));
	}

	@Test
	void testBajaProducto() {
		Producto prod = new Producto();
		prod.setIdProducto("LL5");
		assertTrue(controladorBD.bajaProducto(prod));
	}

	@Test
	void testListarProducto() {
		assertNotEquals(controladorBD.listarProducto().size(), 0);
	}

	@Test
	void testObtenerProducto() {
		Producto prod = new Producto();
		prod.setIdProducto("JJ3");
		prod.setNombreProd("COLUMPIO");
		prod.setCategoria("JUGUETE");
		prod.setPrecio(50);
		prod.setSexo("HOMBRE");
		prod.setTipo("VOLADOR");
		
		assertEquals(controladorBD.obtenerProducto("JJ3"), prod);
	
	}

	@Test
	void testListarEmpleados() {
		assertNotEquals(controladorBD.listarEmpleados().size(), 0);
	}

	@Test
	void testEliminarEmpleado() {
		Empleado emp =new Empleado();
		emp.setCodUsuario(17);
		assertTrue(controladorBD.eliminarEmpleado(emp));
	}

	@Test
	void testEliminarProducto() {
		Producto prod = new Producto();
		prod.setIdProducto("LL5");
		assertTrue(controladorBD.eliminarProducto(prod));
	}

	@Test
	void testModificarUsuario() {
		String nombre= "Fernando";
		
		String email= "Fernandogz@gmail.com";
		
		int codUsuario= 9;
		
		Persona pers= new Persona();
		pers.setNombre(nombre);
		pers.setEmail(email);
		pers.setCodUsuario(codUsuario);
		assertTrue(controladorBD.modificarUsuario(pers));
	}

	@Test
	void testListarUsuario() {
		assertNotEquals(controladorBD.listarUsuario().size(), 0);
	}
	
	

	@Test
	void testListarJuguetes() {
		assertNotEquals(controladorBD.listarJuguetes().size(), 0);
	}

	@Test
	void testListarCosmetico() {
		assertNotEquals(controladorBD.listarCosmetico().size(), 0);
	}

	@Test
	void testListarLenceria() {
		assertNotEquals(controladorBD.listarLenceria().size(), 0);
	}

}
