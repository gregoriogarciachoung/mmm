package com.redsocial.bean;

public class ModalidadBean {

	private int idModalidad;
	private String nombre;
	private int edadMaxima;
	private int edadMinima;
	private int numHombres;
	private int numMujeres;
	private DeporteBean deporte;
	
	
	public int getIdModalidad() {
		return idModalidad;
	}
	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public int getNumHombres() {
		return numHombres;
	}
	public void setNumHombres(int numHombres) {
		this.numHombres = numHombres;
	}
	public int getNumMujeres() {
		return numMujeres;
	}
	public void setNumMujeres(int numMujeres) {
		this.numMujeres = numMujeres;
	}
	public DeporteBean getDeporte() {
		return deporte;
	}
	public void setDeporte(DeporteBean deporte) {
		this.deporte = deporte;
	}
	
	
}
