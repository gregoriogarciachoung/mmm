package com.redsocial.bean;

public class FiltroUsuario {
	//también usado para obtener los filtros de un usuario
	//(1)select * from filtros f join usuario u on f.idUsu = u.id where u.mail = #{mail};
	// mostrar
private String nom;
private String mail; // mail para el filtro (1)
private int edad;
private String ocupacion;
private byte[] foto;

	//filtros
private int sexo;
private int edadMax;
private int edadMin;
private Relacion relacion;
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getOcupacion() {
	return ocupacion;
}
public void setOcupacion(String ocupacion) {
	this.ocupacion = ocupacion;
}
public int getSexo() {
	return sexo;
}
public void setSexo(int sexo) {
	this.sexo = sexo;
}
public int getEdadMax() {
	return edadMax;
}
public void setEdadMax(int edadMax) {
	this.edadMax = edadMax;
}
public int getEdadMin() {
	return edadMin;
}
public void setEdadMin(int edadMin) {
	this.edadMin = edadMin;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public byte[] getFoto() {
	return foto;
}
public void setFoto(byte[] foto) {
	this.foto = foto;
}
public Relacion getRelacion() {
	return relacion;
}
public void setRelacion(Relacion relacion) {
	this.relacion = relacion;
}

}
