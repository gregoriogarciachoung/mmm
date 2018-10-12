package com.redsocial.action;


import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.DistritoBean;
import com.redsocial.bean.EstadoCivilBean;
import com.redsocial.bean.NivelEducacionBean;
import com.redsocial.bean.Relacion;
import com.redsocial.bean.SexoBean;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.dao.MySqlUsuarioDAO;

@SuppressWarnings("serial")
public class RegistroUsuarioAction extends ActionSupport {
	/*
	 * https://www.mkyong.com/struts2/struts-2-scombobox-combo-box-example/
	 * https://www.mkyong.com/struts2/struts-2-sradio-radio-button-example/
	 * */	
	
	private String correo;
	private String clave;
	private String confirmaClave;
	private String nom;
	
	private int sexos;
	
	private String fecNac;
	
	private int hijos;
	private int estCivil;
	private int nivelA;
	private int miAltura;
	private String ocu;
	
	private int distrito;
	
	//atributo no esta en la tabla usuarioDatos pero si en el parametro del sp
	//por comodidad se agrega el atributo relacion a la entidad usuarioDatos
	private int rela;
	
	public String registrar(){
	/*	System.out.println(nom);
		System.out.println(correo);
		System.out.println(clave);
		System.out.println(confirmaClave);
		
		
		System.out.println(sexos);
		System.out.println(hijos);
		System.out.println(estCivil);
		System.out.println(nivelA);
		System.out.println(miAltura);
		System.out.println(ocu);*/
		
		try {
			/*UsuarioDatosBean u = new UsuarioDatosBean();
			DistritoBean d =new DistritoBean();
			SexoBean s = new SexoBean();
			EstadoCivilBean ec = new EstadoCivilBean();
			NivelEducacionBean ne = new NivelEducacionBean();
			
			d.setId(distrito);
			s.setId(sexos);
			ec.setId(estCivil);
			ne.setId(nivelA);*/
			
			
			UsuarioBean uu=new UsuarioBean();
			
			DistritoBean dis = new DistritoBean();
			SexoBean dis1 = new SexoBean();
			EstadoCivilBean dis2 = new EstadoCivilBean();
			NivelEducacionBean dis3 = new NivelEducacionBean();
			Relacion r = new Relacion();
			
			dis.setId(distrito);
			dis1.setId(sexos);
			dis2.setId(estCivil);
			dis3.setId(nivelA);
			r.setId(rela);
			
			uu.setMail(correo);
			uu.setPass(clave);
			uu.setNom(nom);
		    uu.setSexos(dis1);
			uu.setHijos(hijos);
		    uu.setEstCivil(dis2);
			uu.setMiAltura(miAltura);
			uu.setOcu(ocu);
			uu.setDistrito(dis);
			uu.setNivelA(dis3);
			uu.setFecNac(fecNac);
			uu.setRelacion(r);
			
			System.out.println(sexos+" "+estCivil+" "+nivelA+" "+rela);
			System.out.println("------------------------------------");
			
			//llave fk
			new MySqlUsuarioDAO().insertaUsuario(uu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		System.out.println("_________________________________________");
		
		
		return "SUCCESS";
	}
	
	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getConfirmaClave() {
		return confirmaClave;
	}
	public void setConfirmaClave(String confirmaClave) {
		this.confirmaClave = confirmaClave;
	}




	public int getSexos() {
		return sexos;
	}




	public void setSexos(int sexo) {
		this.sexos = sexo;
	}




	




	public int getHijos() {
		return hijos;
	}




	public void setHijos(int hijos) {
		this.hijos = hijos;
	}




	public int getEstCivil() {
		return estCivil;
	}




	public void setEstCivil(int estCivil) {
		this.estCivil = estCivil;
	}




	public int getNivelA() {
		return nivelA;
	}




	public void setNivelA(int nivelA) {
		this.nivelA = nivelA;
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





	public void setDistrito(int distrito) {
		this.distrito = distrito;
	}




	public String getFecNac() {
		return fecNac;
	}




	public void setFecNac(String fecNac) {
		this.fecNac = fecNac;
	}




	public int getRela() {
		return rela;
	}




	public void setRela(int rela) {
		this.rela = rela;
	}
	
	
	
}
