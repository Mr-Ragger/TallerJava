package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import crosscutting.excepciones.ConexionBBDDException;
import datos.equipo.PersistenciaEquipoBBDD;
import negocio.modelo.entidades.Equipo;
import negocio.persistencia.equipo.IPersistenciaEquipo;
import presentacion.controlador.mapeadorpresentacion.MapeadorEntrenador;
import presentacion.controlador.mapeadorpresentacion.MapeadorEquipo;
import presentacion.entidades.PEquipo;
import presentacion.vista.BuscarEquipo;
import presentacion.vista.NuevoEquipo;

public class BuscarEquipoController {

	private BuscarEquipo vista;

	public BuscarEquipoController(BuscarEquipo vista) {
		this.vista = vista;

		vista.setVisible(true);
		vista.setLocationRelativeTo(null);

		anhadirListeners();
		mostrarEquiposDesplegable();
		
	}
	
	private void mostrarEquiposDesplegable() {
		IPersistenciaEquipo persEq = new PersistenciaEquipoBBDD();
		try {
			ArrayList<Equipo> listaEquipos =  (ArrayList<Equipo>) persEq.obtenerListadoEquipos(null);
			
			ArrayList<PEquipo> listaEquiposPresentacion = MapeadorEquipo.obtenerPEquipo(listaEquipos);
			
			vista.mostrarEquiposDesplegable(listaEquiposPresentacion);
			
		} catch (ConexionBBDDException e) {
		
			e.printStackTrace();
		}
	}

	private void anhadirListeners() {
		vista.addbtnGuardarActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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

	private void guardarDatosEquipo() {
		PEquipo eq = vista.obtenerDatos();

		IPersistenciaEquipo persEq = new PersistenciaEquipoBBDD();
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		equipos.add(MapeadorEquipo.obtenerEquipo(eq));

		try {
			persEq.insertarListadoEquipos(equipos);
		} catch (ConexionBBDDException e) {

			e.printStackTrace();
		}

	}

}
