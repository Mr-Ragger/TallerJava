package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.NuevoEquipo;
import presentacion.vista.PantallaPrincipal;

public class PantallaPrincipalControl {

	private PantallaPrincipal vista;
	
	
	public PantallaPrincipalControl(PantallaPrincipal vista) {
		this.vista = vista;
		vista.frame.setVisible(true);
		vista.frame.setLocationRelativeTo(null);
		
		anhadirListeners();
		
		
		
		
	}
	
	private void anhadirListeners() {
		vista.addmnUNueviEquipoActionPerformed(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				mostrarPantallaNuevoEquipo();
			}
		});
			
		}
	
	
	
	private void mostrarPantallaNuevoEquipo() {
		NuevoEquipo dialogo = new NuevoEquipo();
		new NuevoEquipoController(dialogo);
	}
	
	
}
