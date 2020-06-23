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
				guardarDatosEquipo();
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
