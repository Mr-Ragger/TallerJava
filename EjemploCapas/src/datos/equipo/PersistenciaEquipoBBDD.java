package datos.equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crosscutting.GestorLog;
import crosscutting.excepciones.ConexionBBDDException;
import datos.conexion.PersistenciaBBDD;
import datos.filtro.FiltroEquipo;
import negocio.modelo.entidades.Equipo;
import negocio.persistencia.equipo.IPersistenciaEquipo;

public class PersistenciaEquipoBBDD extends PersistenciaBBDD implements IPersistenciaEquipo {

	@Override
	public List<Equipo> obtenerListadoEquipos(FiltroEquipo filtro) throws ConexionBBDDException {
		// TODO Auto-generated method stub
		String consulta = "Select id, nombre, anho_fundacion from equipo";
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
		String clausulaWhere = "";

		try {
			cargarDriverConexionBBDD();

			Connection con = obtenerConexion();

			
			
			
			if (filtro!=null) {
				if ( filtro.id != null ) {
					clausulaWhere = clausulaWhere + " id=?";
				}
					if(filtro.nombre!=null && !filtro.nombre.isEmpty())
					{
						if(!clausulaWhere.isEmpty()) {
							clausulaWhere = clausulaWhere + " and ";
						}
						clausulaWhere = clausulaWhere + " nombre like ? ";
					}
					if (!clausulaWhere.isEmpty()) {
						clausulaWhere = " where " + clausulaWhere;
					}
			}
			
			PreparedStatement ps = con.prepareStatement(consulta + clausulaWhere);

			if(filtro != null && clausulaWhere !=null && !clausulaWhere.isEmpty()) {
				int indice = 1;
				 if(filtro.id != null) {
					 ps.setInt(indice,  filtro.id);
					 indice++;
				 }
				 if ( filtro.nombre != null && !filtro.nombre.isEmpty()) {
					 ps.setString(indice, filtro.nombre);
					 indice++;
				 }
			}

			ps.execute();

			ResultSet rs = ps.getResultSet();

			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				int anhoFundacion = rs.getInt("anho_fundacion");

				Equipo e = new Equipo(id, nombre, anhoFundacion);
				listaEquipos.add(e);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			GestorLog.logError("Error al obtener los equipos", e.getStackTrace());
		} finally {
			cerrarConexion();
		}
		return listaEquipos;

	}

	@Override
	public boolean insertarListadoEquipos(List<Equipo> listadoEquipos) throws ConexionBBDDException {
		String consulta = "INSERT INTO equipo (nombre,anho_fundacion) VALUES (?,?)";
		try {
			cargarDriverConexionBBDD();
			
			Connection con = obtenerConexion();

			PreparedStatement ps = con.prepareStatement(consulta);

			for(Equipo e:listadoEquipos) {
				ps.setString(1,e.getNombre());
				ps.setInt(2, e.getAnhoFundacion());
				ps.addBatch();
			}
			
			ps.executeBatch();
			
			return true;
			
		} catch (ClassNotFoundException | SQLException e) {
			GestorLog.logError("No se ha completado la insercion", e.getStackTrace());
			e.printStackTrace();
			return false;
		}
		finally {
			cerrarConexion();
		}

	}

	@Override
	public boolean eliminarListadoEquipos(List<Equipo> listadoJugadores) throws ConexionBBDDException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizarListadoEquipos(List<Equipo> listaEquipos) throws ConexionBBDDException {
		String consulta = "Update equipo set nombre=?, anho_fundacion=? where id=? ";
		
//		for(Equipo e:listaEquipos) {
//			ps.setString(1,e.getNombre());
//			ps.setInt(2, e.getAnhoFundacion());
//			ps.setInt(3, e.getId());
//			ps.addBatch();
//		}
//			
		return false;
	}

}// PersistenciaEquipoBBDD
