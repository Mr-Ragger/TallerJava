package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.NuevoEquipo;

public class NuevoEquipoController {
		
	private NuevoEquipo vista;
	
		
		public NuevoEquipoController(NuevoEquipo vista) {
			this.vista = vista;
			
			vista.setVisible(true);
			vista.setLocationRelativeTo(null);
			
			anhadirListeners();
		}
		
	private void anhadirListeners() {
		vista.addbtnGuardarActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				vista.dispose();
				
			}
		});
		vista.addbtnCancelarActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vista.dispose();
			}
		});
	}
	
}
