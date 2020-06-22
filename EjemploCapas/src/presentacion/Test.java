package presentacion;

import java.util.ArrayList;

import crosscutting.excepciones.ConexionBBDDException;
import datos.equipo.PersistenciaEquipoBBDD;
import negocio.modelo.entidades.Equipo;
import negocio.persistencia.equipo.IPersistenciaEquipo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPersistenciaEquipo persEqu = new PersistenciaEquipoBBDD();
		try {
			ArrayList<Equipo> equipos = (ArrayList<Equipo>) persEqu.obtenerListadoEquipos(null);
			for (Equipo e:equipos) {
				System.out.println(e);
			}
			
			System.out.println("depor -------------------");
			
		} catch (ConexionBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
