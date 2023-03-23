package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Inquilino;
import Model.Usuario;

public class ControllerInquilino {

	public static Inquilino findInquilinoByIdVivienda(int idVivienda) {
		Inquilino m = null;

		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from alquileres.inquilino " + "where idVivienda = " + idVivienda);

			while (rs.next()) {
				m = new Inquilino();
				m.setId(rs.getInt("id"));
				m.setDni(rs.getString("dni"));
				m.setNombreCompleto(rs.getString("nombreCompleto"));
				m.setFechaIncioAlquiler(rs.getDate("fechaInicioAlquiler"));
				m.setFechaFinAlquiler(rs.getDate("fechaFinAlquiler"));
				m.setCoutaMensual(rs.getFloat("cuotaMensual"));
				m.setIdVivienda(rs.getInt("idVivienda"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return m;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar(Inquilino var) {

		try {

			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update alquileres.inquilino set dni = ?, " + "nombreCompleto = ?, fechaInicioAlquiler = ?, "
							+ "fechaFinAlquiler = ?, cuotaMensual = ?, idVivienda = ? where id = ?");

			ps.setString(1, var.getDni());
			ps.setString(2, var.getNombreCompleto());
			ps.setDate(3, new java.sql.Date(var.getFechaIncioAlquiler().getTime()));
			ps.setDate(4, new java.sql.Date(var.getFechaFinAlquiler().getTime()));
			ps.setFloat(5, var.getCoutaMensual());
			ps.setInt(6, var.getIdVivienda());
			ps.setInt(7, var.getId());

			int rows = ps.executeUpdate();
			ps.close();
			conn.close();

			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
