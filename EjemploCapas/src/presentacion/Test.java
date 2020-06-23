package presentacion;

import java.util.ArrayList;

import crosscutting.excepciones.ConexionBBDDException;
import datos.equipo.PersistenciaEquipoBBDD;
import datos.filtro.FiltroEquipo;
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
			
			System.out.println("depor");
			FiltroEquipo filtro = new FiltroEquipo();
			filtro.nombre = "de";
			equipos = (ArrayList<Equipo>) persEqu.obtenerListadoEquipos(filtro);
			for(Equipo e:equipos) {
				System.out.println(e);
			}
			
			System.out.println("----------------------Insercion--------------");
			
			Equipo eq = new Equipo (0,"prueba1", 2020);
			ArrayList<Equipo> listaInsert = new ArrayList<>();
			persEqu.insertarListadoEquipos(listaInsert);
			
			filtro = new FiltroEquipo();
			equipos = (ArrayList<Equipo>) persEqu.obtenerListadoEquipos(filtro);
			for (Equipo e:equipos) {
				System.out.println(e);
				
				
				System.out.println("-------------Actualizacion---------------");
				equipos.get(1).setNombre("Prueba actualizado");
				persEqu.actualizarListadoEquipos(equipos);
				
			}
			
		} catch (ConexionBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
