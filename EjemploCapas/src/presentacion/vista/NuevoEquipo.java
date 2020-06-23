package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.entidades.PEquipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NuevoEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtAnhoFund;
	private JButton btnGuardar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoEquipo dialog = new NuevoEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NuevoEquipo() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("Id");
			lblId.setBounds(66, 71, 28, 14);
			contentPanel.add(lblId);
		}
		{
			txtId = new JTextField();
			txtId.setEditable(false);
			txtId.setBounds(104, 68, 181, 20);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		{
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(48, 102, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(104, 99, 181, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtAnhoFund = new JTextField();
			txtAnhoFund.setBounds(104, 130, 181, 20);
			contentPanel.add(txtAnhoFund);
			txtAnhoFund.setColumns(10);
		}
		{
			JLabel lblAoDeFundacion = new JLabel("A\u00F1o de Fundacion");
			lblAoDeFundacion.setBounds(10, 133, 84, 14);
			contentPanel.add(lblAoDeFundacion);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 11, 219, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	//listener
	public void addbtnGuardarActionListener(ActionListener listener) {
		btnGuardar.addActionListener(listener);
	}
	
	public void addbtnCancelarActionListener(ActionListener listener) {
		btnCancelar.addActionListener(listener);
	}
	
	
	public PEquipo obtenerDatos() {
		PEquipo eq = new PEquipo();
		eq.nombre = txtNombre.getText()	;
		eq.anhoFundacion = Integer.valueOf(txtAnhoFund.getText());
		return eq;		
	}
	
	public boolean validarFormulario() {
		boolean valido = true;
		if (txtNombre.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"El campo de nombre es obligatorio");
			valido = false;		
		}else {
			if(txtAnhoFund.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "El anño de fundacion es obligatorio");
				valido = false;
			}else {
				try {
					Integer.valueOf(txtAnhoFund.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El campo de creacion debe de ser numerico");
					valido = false;
				}
			}
			
		}
		return valido;
	}
	 
}
