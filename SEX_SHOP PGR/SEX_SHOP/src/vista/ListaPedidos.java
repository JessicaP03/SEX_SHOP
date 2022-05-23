package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Compra;
import clases.Producto;
import modelo.ControladorDatos;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

/**
 * @author 1dam
 *
 */
public class ListaPedidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Map<String, Compra> compras;
	private JTable tablaProducto;
	private ControladorDatos datos;
	/**
	 * Launch the application.
	 * @param piñaMeloco 
	 * @param b 
	 * @param datos 
	 * @param compra 
	 */

	public ListaPedidos(PiñaMeloco piñaMeloco, boolean b, ControladorDatos datos, Compra compra) {
		super(piñaMeloco);
		this.setModal(b);
		
		setBounds(100, 100, 447, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlDkShadow);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblListaDePedidos = new JLabel("LISTA DE PEDIDOS");
			lblListaDePedidos.setForeground(Color.WHITE);
			lblListaDePedidos.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblListaDePedidos.setBounds(26, 11, 149, 14);
			contentPanel.add(lblListaDePedidos);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(26, 36, 346, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel = new JLabel("Pedidos comprados");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(36, 49, 115, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(41, 318, 346, 2);
			contentPanel.add(separator);
		}
		this.presentarTabla(compra, datos);
	}
	
	
	private void presentarTabla(Compra compra, ControladorDatos datos) {

		JScrollPane scroll = new JScrollPane();
		scroll.setForeground(Color.BLACK);
		scroll.setBackground(Color.GRAY);
		tablaProducto = this.cargarTabla(compra, datos);
		scroll.setViewportView(tablaProducto);

		contentPanel.add(scroll);
		scroll.setBounds(26, 88, 361, 178);


	}




	private JTable cargarTabla(Compra comp, ControladorDatos datos) {
		// ASIGNAR LOS NOMBRES DE LAS COLUMNAS
		String[] nombreColumnas = { "FECHA", "IDPRODUCTO", "CODUSUARIO"};
		String[] registros = new String[3];

		DefaultTableModel modelo = new DefaultTableModel(null, nombreColumnas);
		modelo.setRowCount(0);

		// RECOGER LOS DATOS DE JUGUETES
		compras  = datos.listarCompra();

		for (Compra com: compras.values()) {
			registros[0] = String.valueOf(com.getFecha_compra());
			registros[1] = com.getIdproducto();
			registros[2] = String.valueOf(com.getCodusuario());
			modelo.addRow(registros);
		}

		return new JTable(modelo);

	}

}
