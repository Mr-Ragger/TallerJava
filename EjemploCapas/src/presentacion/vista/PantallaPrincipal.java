package presentacion.vista;



import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class PantallaPrincipal {

	public JFrame frame;
	private JTextField txtIdEquipo;
	private JTextField txtNombreEquipo;
	private JTextField txtFundacion;
	private JTextField txtIdEntrenador;
	private JTextField txtNombreEntrenador;
	private JTextField txtFechaNaci;
	private JTextField txtApellidosEntrenador;
	private JTextField txtFechaInicioEntreno;
	private JTextField txtJugadores;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmBuscar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 749, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Equipo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 715, 137);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(36, 38, 10, 14);
		panel.add(lblId);
		
		txtIdEquipo = new JTextField();
		txtIdEquipo.setBounds(78, 35, 157, 20);
		panel.add(txtIdEquipo);
		txtIdEquipo.setColumns(10);
		lblId.setLabelFor(txtIdEquipo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 46, 14);
		panel.add(lblNombre);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setBounds(77, 62, 335, 20);
		panel.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);
		lblNombre.setLabelFor(txtNombreEquipo);
		
		JLabel lblFundacion = new JLabel("Fundacion");
		lblFundacion.setBounds(10, 97, 68, 14);
		panel.add(lblFundacion);
		
		txtFundacion = new JTextField();
		txtFundacion.setBounds(77, 94, 110, 20);
		panel.add(txtFundacion);
		txtFundacion.setColumns(10);
		lblFundacion.setLabelFor(txtFundacion);
		
		JButton btnEditEquip = new JButton("Editar equipo");
		btnEditEquip.setBounds(610, 59, 95, 23);
		panel.add(btnEditEquip);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Jugadores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 336, 715, 166);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtJugadores = new JTextField();
		txtJugadores.setBounds(10, 48, 695, 103);
		panel_1.add(txtJugadores);
		txtJugadores.setColumns(10);
		
		JButton btnAsignarJugadors = new JButton("Asignar Jugadores");
		btnAsignarJugadors.setBounds(581, 11, 124, 23);
		panel_1.add(btnAsignarJugadors);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 255, 255)), "Entrenador", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 159, 715, 166);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setBounds(10, 41, 46, 14);
		panel_2.add(lblId_1);
		lblId_1.setLabelFor(txtIdEntrenador);
		
		txtIdEntrenador = new JTextField();
		txtIdEntrenador.setBounds(74, 38, 184, 20);
		panel_2.add(txtIdEntrenador);
		txtIdEntrenador.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 71, 46, 14);
		panel_2.add(lblNombre_1);
		lblNombre_1.setLabelFor(txtNombreEntrenador);
		
		txtNombreEntrenador = new JTextField();
		txtNombreEntrenador.setBounds(75, 65, 184, 20);
		panel_2.add(txtNombreEntrenador);
		txtNombreEntrenador.setColumns(10);
		
		JLabel lblFnacimiento = new JLabel("F.Nacimiento");
		lblFnacimiento.setBounds(10, 101, 68, 14);
		panel_2.add(lblFnacimiento);
		lblFnacimiento.setLabelFor(txtFechaNaci);
		
		txtFechaNaci = new JTextField();
		txtFechaNaci.setBounds(74, 96, 187, 20);
		panel_2.add(txtFechaNaci);
		txtFechaNaci.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(282, 69, 85, 14);
		panel_2.add(lblApellidos);
		lblApellidos.setLabelFor(txtApellidosEntrenador);
		
		txtApellidosEntrenador = new JTextField();
		txtApellidosEntrenador.setBounds(373, 64, 181, 20);
		panel_2.add(txtApellidosEntrenador);
		txtApellidosEntrenador.setColumns(10);
		
		JLabel lblFinicioEntreno = new JLabel("F.Inicio Entreno");
		lblFinicioEntreno.setBounds(284, 99, 85, 14);
		panel_2.add(lblFinicioEntreno);
		lblFinicioEntreno.setLabelFor(txtFechaInicioEntreno);
		
		txtFechaInicioEntreno = new JTextField();
		txtFechaInicioEntreno.setBounds(373, 96, 181, 20);
		panel_2.add(txtFechaInicioEntreno);
		txtFechaInicioEntreno.setColumns(10);
		
		JButton btnAsignEntr = new JButton("Asignar Entrenador");
		btnAsignEntr.setBounds(580, 11, 125, 23);
		panel_2.add(btnAsignEntr);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnEquipo = new JMenu("Equipo");
		menuBar.add(mnEquipo);
		
		mntmNuevo = new JMenuItem("Nuevo");

		mnEquipo.add(mntmNuevo);
		
		mntmBuscar = new JMenuItem("Buscar");
		mnEquipo.add(mntmBuscar);
		
		JMenu mnEntrenador = new JMenu("Entrenador");
		menuBar.add(mnEntrenador);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mnEntrenador.add(mntmNuevo_1);
		
		JMenuItem mntmAsignar = new JMenuItem("Asignar");
		mnEntrenador.add(mntmAsignar);
		
		JMenu mnJugador = new JMenu("Jugador");
		menuBar.add(mnJugador);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnJugador.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnJugador.add(mntmNewMenuItem_1);
	}

	public void addmnUNueviEquipoActionPerformed(java.awt.event.ActionListener actionListener) {
		// TODO Auto-generated method stub
		mntmNuevo.addActionListener(actionListener);
	}
	public void addmnUBuscarEquipoActionPerformed(java.awt.event.ActionListener actionListener) {
		// TODO Auto-generated method stub
		mntmBuscar.addActionListener(actionListener);
	}
	
	
}
