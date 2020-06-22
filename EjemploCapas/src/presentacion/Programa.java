package presentacion;

import java.awt.EventQueue;

import presentacion.controlador.PantallaPrincipalControl;
import presentacion.vista.PantallaPrincipal;

public class Programa {


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new PantallaPrincipalControl(new PantallaPrincipal());
//						PantallaPrincipal window = new PantallaPrincipal();
//						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}
