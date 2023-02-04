/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.kevinmv.area_figuras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author kevinm
 */
public class AreaFiguras extends JFrame implements ActionListener {

	JLabel lblBase, lblAltura, lblArea;
	JTextField txtBase, txtAltura, txtArea;
	JComboBox cbOpcion;
	JButton btnCalcArea;

	public AreaFiguras() {
		this.setBounds(0, 0, 400, 400);

		this.lblBase = new JLabel();
		this.lblBase.setBounds(10, 20, 190, 20);
		this.lblBase.setName("lblBase");
		this.lblBase.setText("Ingrese la base: ");
		this.lblBase.setVisible(true);

		this.txtBase = new JTextField();
		this.txtBase.setBounds(200, 20, 150, 20);
		this.txtBase.setName("txtBase");

		this.lblAltura = new JLabel();
		this.lblAltura.setBounds(10, 40, 120, 20);
		this.lblAltura.setName("lblAltura");
		this.lblAltura.setText("Ingrese la altura: ");
		this.lblAltura.setVisible(true);

		this.txtAltura = new JTextField();
		this.txtAltura.setBounds(200, 40, 150, 20);
		this.txtAltura.setName("txtAltura");

		this.lblArea = new JLabel();
		this.lblArea.setBounds(10, 60, 120, 20);
		this.lblArea.setName("lblArea");
		this.lblArea.setText("Área: ");
		this.lblArea.setVisible(true);

		this.txtArea = new JTextField();
		this.txtArea.setBounds(200, 60, 150, 20);
		this.txtArea.setName("txtArea");
		this.txtArea.setEnabled(false);

		this.add(this.lblBase);
		this.add(this.txtBase);
		this.add(this.lblAltura);
		this.add(this.txtAltura);
		this.add(this.lblArea);
		this.add(this.txtArea);

		this.btnCalcArea = new JButton();
		this.btnCalcArea.setBounds(10, 130, 120, 20);
		this.btnCalcArea.setName("btnCalcArea");
		this.btnCalcArea.setText("Calcular área");
		this.btnCalcArea.addActionListener(this);

		this.add(this.btnCalcArea);

		this.cbOpcion = new JComboBox();
		this.cbOpcion.setBounds(10, 100, 120, 20);
		this.cbOpcion.addActionListener(this);
		this.cbOpcion.setName("cbOpcion");
		this.cbOpcion.addItem("Triangulo");
		this.cbOpcion.addItem("Cuadrado");
		this.cbOpcion.addItem("Rectangulo");
		this.cbOpcion.addItem("Poligono");

		this.add(this.cbOpcion);

		this.setLayout(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		AreaFiguras ob = new AreaFiguras();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnCalcArea) {
			switch (cbOpcion.getSelectedItem().toString()) {
				case "Triangulo": {
					Double base = Double.valueOf(txtBase.getText());
					Double altura = Double.valueOf(txtAltura.getText());
					Double area = Triangulo.calcArea(base, altura);
					txtArea.setText(String.valueOf(area));
					break;
				}

				case "Cuadrado": {
					Double lado = Double.valueOf(txtBase.getText());
					Double area = Cuadrado.calcArea(lado);
					txtArea.setText(String.valueOf(area));
					break;
				}
				case "Rectangulo": {
					Double base = Double.valueOf(txtBase.getText());
					Double altura = Double.valueOf(txtAltura.getText());
					Double area = Rectangulo.calcArea(base, altura);
					txtArea.setText(String.valueOf(area));
					break;
				}
				case "Poligono": {
					Integer numLados = Integer.valueOf(txtBase.getText());
					Double lado = Double.valueOf(txtAltura.getText());
					Double area = Poligono.calcArea(numLados, lado);
					txtArea.setText(String.valueOf(area));
					break;
				}

				default:
					throw new AssertionError();
			}
			return;
		}
		if (ae.getSource() == cbOpcion) {
			txtArea.setText("");
			switch (cbOpcion.getSelectedItem().toString()) {
				case "Triangulo":
					lblBase.setText("Ingrese la base: ");
					lblAltura.setText("Ingrese la altura: ");
					lblAltura.setVisible(true);
					txtAltura.setVisible(true);
					break;

				case "Cuadrado":
					lblBase.setText("Ingrese el lado: ");
					lblAltura.setVisible(false);
					txtAltura.setVisible(false);
					break;

				case "Rectangulo": 
					lblBase.setText("Ingrese la base: ");
					lblAltura.setText("Ingrese la altura: ");
					lblAltura.setVisible(true);
					txtAltura.setVisible(true);
					break;
				
				case "Poligono": 
					lblBase.setText("Ingrese el número de lados: ");
					lblAltura.setText("Ingrese el lado: ");
					lblAltura.setVisible(true);
					txtAltura.setVisible(true);
					break;
				

				default:
					throw new AssertionError();
			}
		}
	}
}
