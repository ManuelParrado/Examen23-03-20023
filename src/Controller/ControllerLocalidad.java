package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Localidad;

public class ControllerLocalidad {

	/**
	 * 
	 * @return
	 */
	public static List<Localidad> findAll() {
		List<Localidad> lista = new ArrayList<Localidad>();

		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from alquileres.localidad");

			while (rs.next()) {
				Localidad p = new Localidad();
				p.setId(rs.getInt("id"));
				p.setDescripcion(rs.getString("descripcion"));
				lista.add(p);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}

}
