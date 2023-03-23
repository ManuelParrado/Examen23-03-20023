package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Vivienda;

public class ControllerVivienda {

	public static List<Vivienda> findAllByIdPais(int idLocalidad) {
		List<Vivienda> lista = new ArrayList<Vivienda>();

		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from alquileres.vivienda " + "where idLocalidad = " + idLocalidad);

			while (rs.next()) {
				Vivienda i = new Vivienda();
				i.setId(rs.getInt("id"));
				i.setDescripcion(rs.getString("descripcion"));
				i.setIdLocalidad(rs.getInt("idLocalidad"));
				lista.add(i);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}

}
