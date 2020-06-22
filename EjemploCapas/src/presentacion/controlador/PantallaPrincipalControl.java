package presentacion.controlador;

import presentacion.vista.PantallaPrincipal;

public class PantallaPrincipalControl {

	private PantallaPrincipal vista;
	
	
	public PantallaPrincipalControl(PantallaPrincipal vista) {
		this.vista = vista;
		vista.frame.setVisible(true);
		vista.frame.setLocationRelativeTo(null);
	}
	
}
