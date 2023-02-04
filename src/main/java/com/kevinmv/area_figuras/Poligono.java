/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kevinmv.area_figuras;

/**
 *
 * @author kevinm
 */
public class Poligono {
	public static Double calcArea(Integer numLados, Double lado){
		Double theta = Math.toRadians(360/(2.0*numLados));
		Double apotema = lado/(2*Math.tan(theta));
		Double perimetro = numLados * lado;
		return perimetro * apotema /2;
	}
}
