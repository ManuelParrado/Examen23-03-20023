package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerIdioma;
import Controller.ControllerInquilino;
import Controller.ControllerLocalidad;
import Controller.ControllerPais;
import Controller.ControllerVivienda;
import Model.Idioma;
import Model.Inquilino;
import Model.Localidad;
import Model.Pais;
import Model.Vivienda;
import controllers.ControladorMateria;
import models.CentroEducativo;
import models.Materia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfDNI;
	private JTextField jtfNombreC;
	private JTextField jtfFechaInicio;
	private JTextField jtfFechaFin;
	private JTextField jtfCuotaMensual;
	private JComboBox<Localidad> jcbLocalidad;
	private JComboBox<Vivienda> jcbVivienda;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JCheckBox jCheck;
	private JLabel jLabelIva;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Modificación de alquileres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbLocalidad = new JComboBox<Localidad>();
		jcbLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarViviendaDeLocalidad();
				
			}
		});
		GridBagConstraints gbc_jcbLocalidad = new GridBagConstraints();
		gbc_jcbLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_jcbLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbLocalidad.gridx = 4;
		gbc_jcbLocalidad.gridy = 1;
		contentPane.add(jcbLocalidad, gbc_jcbLocalidad);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vivienda:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 3;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jcbVivienda = new JComboBox<Vivienda>();
		jcbVivienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosInquilino();
				
			}
		});
		GridBagConstraints gbc_jcbVivienda = new GridBagConstraints();
		gbc_jcbVivienda.insets = new Insets(0, 0, 5, 5);
		gbc_jcbVivienda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbVivienda.gridx = 4;
		gbc_jcbVivienda.gridy = 2;
		contentPane.add(jcbVivienda, gbc_jcbVivienda);
		
		JLabel lblNewLabel_2 = new JLabel("Datos del inquilino");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 4;
		gbc_jtfId.gridy = 4;
		jtfId.setEnabled(false);
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 3;
		gbc_lblNewLabel_3_1.gridy = 5;
		contentPane.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		jtfDNI = new JTextField();
		jtfDNI.setColumns(10);
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 4;
		gbc_jtfDNI.gridy = 5;
		contentPane.add(jtfDNI, gbc_jtfDNI);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nombre Completo:");
		GridBagConstraints gbc_lblNewLabel_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_3_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_2.gridx = 3;
		gbc_lblNewLabel_3_2.gridy = 6;
		contentPane.add(lblNewLabel_3_2, gbc_lblNewLabel_3_2);
		
		jtfNombreC = new JTextField();
		jtfNombreC.setColumns(10);
		GridBagConstraints gbc_jtfNombreC = new GridBagConstraints();
		gbc_jtfNombreC.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombreC.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombreC.gridx = 4;
		gbc_jtfNombreC.gridy = 6;
		contentPane.add(jtfNombreC, gbc_jtfNombreC);
		
		JLabel lblNewLabel_3_3 = new JLabel("Fecha inicio:");
		GridBagConstraints gbc_lblNewLabel_3_3 = new GridBagConstraints();
		gbc_lblNewLabel_3_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3.gridx = 3;
		gbc_lblNewLabel_3_3.gridy = 7;
		contentPane.add(lblNewLabel_3_3, gbc_lblNewLabel_3_3);
		
		jtfFechaInicio = new JTextField();
		jtfFechaInicio.setColumns(10);
		GridBagConstraints gbc_jtfFechaInicio = new GridBagConstraints();
		gbc_jtfFechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechaInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaInicio.gridx = 4;
		gbc_jtfFechaInicio.gridy = 7;
		contentPane.add(jtfFechaInicio, gbc_jtfFechaInicio);
		
		jCheck = new JCheckBox("Alquiler en activo");
		jCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtfFechaFin.setEnabled(jCheck.isSelected());
			}
		});
		GridBagConstraints gbc_jCheck = new GridBagConstraints();
		gbc_jCheck.fill = GridBagConstraints.HORIZONTAL;
		gbc_jCheck.insets = new Insets(0, 0, 5, 5);
		gbc_jCheck.gridx = 4;
		gbc_jCheck.gridy = 8;
		contentPane.add(jCheck, gbc_jCheck);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Fecha fin:");
		GridBagConstraints gbc_lblNewLabel_3_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3_1.gridx = 3;
		gbc_lblNewLabel_3_3_1.gridy = 9;
		contentPane.add(lblNewLabel_3_3_1, gbc_lblNewLabel_3_3_1);
		
		jtfFechaFin = new JTextField();
		jtfFechaFin.setColumns(10);
		GridBagConstraints gbc_jtfFechaFin = new GridBagConstraints();
		gbc_jtfFechaFin.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechaFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFin.gridx = 4;
		gbc_jtfFechaFin.gridy = 9;
		contentPane.add(jtfFechaFin, gbc_jtfFechaFin);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Cuota mensual (€):");
		GridBagConstraints gbc_lblNewLabel_3_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_3_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_3_1_1.gridx = 3;
		gbc_lblNewLabel_3_3_1_1.gridy = 10;
		contentPane.add(lblNewLabel_3_3_1_1, gbc_lblNewLabel_3_3_1_1);
		
		jtfCuotaMensual = new JTextField();
		jtfCuotaMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Float sinIva = Float.parseFloat(jtfCuotaMensual.getText());
				Float conIva = (float) (sinIva*1.21);
				
				jLabelIva.setText(""+conIva);
				
			}
		});
		jtfCuotaMensual.setColumns(10);
		GridBagConstraints gbc_jtfCuotaMensual = new GridBagConstraints();
		gbc_jtfCuotaMensual.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCuotaMensual.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCuotaMensual.gridx = 4;
		gbc_jtfCuotaMensual.gridy = 10;
		contentPane.add(jtfCuotaMensual, gbc_jtfCuotaMensual);
		
		JLabel lblNewLabel_4 = new JLabel("Total Mensual (IVA Incluido) (€)");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 11;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jLabelIva = new JLabel("New label");
		GridBagConstraints gbc_jLabelIva = new GridBagConstraints();
		gbc_jLabelIva.insets = new Insets(0, 0, 5, 5);
		gbc_jLabelIva.gridx = 4;
		gbc_jLabelIva.gridy = 11;
		contentPane.add(jLabelIva, gbc_jLabelIva);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardarInquilino();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 12;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		cargarListaLocalidades();
	}
	
	
	/**
	 * 
	 */
	private void cargarListaLocalidades () {
		List<Localidad> lista = ControllerLocalidad.findAll();
		
		for (Localidad p : lista) {
			this.jcbLocalidad.addItem(p);
		}
	}
	
	
	/**
	 * 
	 */
	private void cargarViviendaDeLocalidad() {
		
		Localidad n = (Localidad) this.jcbLocalidad.getSelectedItem();
		
		if (n != null) {
			
			this.jcbVivienda.removeAllItems();
			
			List<Vivienda> lista = ControllerVivienda.findAllByIdPais(n.getId());
			
			for (Vivienda i : lista) {
				this.jcbVivienda.addItem(i);
			}
			
		}

	}
	
	
	/**
	 * 
	 */
	private void cargarDatosInquilino() {
		Vivienda m = (Vivienda) this.jcbVivienda.getSelectedItem();
		
		if (m != null) {
			
			Inquilino i = ControllerInquilino.findInquilinoByIdVivienda(m.getId());
			
			this.jtfId.setText("" + m.getId());
			this.jtfDNI.setText(i.getDni());
			this.jtfNombreC.setText(i.getNombreCompleto());
			this.jtfFechaInicio.setText(sdf.format(i.getFechaIncioAlquiler()));
	
			
			if (i.getFechaFinAlquiler() == null) {
				jCheck.setSelected(false);
				this.jtfFechaFin.setText("");
			} else {
				jCheck.setSelected(true);
				this.jtfFechaFin.setText(sdf.format(i.getFechaFinAlquiler()));
			}
			
			this.jtfCuotaMensual.setText(""+i.getCoutaMensual());


		}
	}
	
	
	/**
	 * 
	 */
	private void guardarInquilino() {
		
		
		String dni = this.jtfDNI.getText();
		if (!dni.matches("[\\d]{8}+[A-Z]{1}")) {
			JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos y una letra mayúscula");
			return;
		}
		
		String nombre = this.jtfNombreC.getText();
		if (nombre.isBlank()) {
			JOptionPane.showMessageDialog(null, "Debes introducir letras");
			return;
		}
		
		
		String fecha1 = this.jtfFechaInicio.getText();
		String fecha2 = this.jtfFechaFin.getText();
		
		if (!fecha1.matches("[\\d]{2}+/+[\\d]{2}+/+[\\d]{4}") || !fecha2.matches("[\\d]{2}+/+[\\d]{2}+/+[\\d]{4}")) {
			JOptionPane.showMessageDialog(null, "Debes introducir introducir un formato correcto de fecha dd/MM/yyyy");
			return;
		}
		
		
		Inquilino m = new Inquilino();
		
		Vivienda v = (Vivienda) this.jcbVivienda.getSelectedItem();
		
		
		
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setDni(this.jtfDNI.getText());
		m.setNombreCompleto(this.jtfNombreC.getText());
		
		try {
			m.setFechaIncioAlquiler(sdf.parse(this.jtfFechaInicio.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		try {
			m.setFechaFinAlquiler(sdf.parse(this.jtfFechaFin.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		
		m.setCoutaMensual(Float.parseFloat(this.jtfCuotaMensual.getText()));
		m.setIdVivienda(v.getId());

		

		
		if (ControllerInquilino.insertar(m) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");			
		}
	}
	
	
	

}
