package com.redsocial.bean;



public class UsuarioBean {
private int id;
private String nom, mail;
private String pass;

private int  hijos,  miAltura;
private String ocu;
private String fecNac;

private DistritoBean distrito;
private SexoBean sexos;
private EstadoCivilBean estCivil;
private NivelEducacionBean nivelA;

private byte[] foto;

private int edad; // atributo que no se encuentra en la tabla usuario pero está en el resultado (select) del procedimiento almacenado

private FiltroUsuario busca; // borrar

/*
 * 	System.out.println(sexos);
		System.out.println(hijos);
		System.out.println(estCivil);
		System.out.println(nivelA);
		System.out.println(miAltura);
		System.out.println(ocu);
 * */

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public int getHijos() {
	return hijos;
}
public void setHijos(int hijos) {
	this.hijos = hijos;
}
public int getMiAltura() {
	return miAltura;
}
public void setMiAltura(int miAltura) {
	this.miAltura = miAltura;
}
public String getOcu() {
	return ocu;
}
public void setOcu(String ocu) {
	this.ocu = ocu;
}
public String getFecNac() {
	return fecNac;
}
public void setFecNac(String fecNac) {
	this.fecNac = fecNac;
}
public DistritoBean getDistrito() {
	return distrito;
}
public void setDistrito(DistritoBean distrito) {
	this.distrito = distrito;
}
public SexoBean getSexos() {
	return sexos;
}
public void setSexos(SexoBean sexos) {
	this.sexos = sexos;
}

public EstadoCivilBean getEstCivil() {
	return estCivil;
}
public void setEstCivil(EstadoCivilBean estCivil) {
	this.estCivil = estCivil;
}
public NivelEducacionBean getNivelA() {
	return nivelA;
}
public void setNivelA(NivelEducacionBean nivelA) {
	this.nivelA = nivelA;
}

public byte[] getFoto() {
	return foto;
}
public void setFoto(byte[] foto) {
	this.foto = foto;
}
public FiltroUsuario getBusca() {
	return busca;
}
public void setBusca(FiltroUsuario busca) {
	this.busca = busca;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}



}
