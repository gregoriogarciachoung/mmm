package com.redsocial.bean;

public class UsuarioDatosBean {
private int idUsu;
private int  hijos,  miAltura;
private String ocu;
private String fecNac;

//este atributo se agrego por comodidad 
//no está en la tabla pero si en los parametros del sp
private Relacion relacion;


public int getIdUsu() {
	return idUsu;
}

public void setIdUsu(int idUsu) {
	this.idUsu = idUsu;
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

public Relacion getRelacion() {
	return relacion;
}

public void setRelacion(Relacion relacion) {
	this.relacion = relacion;
}

}
