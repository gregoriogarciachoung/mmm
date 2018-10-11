package com.redsocial.action;

import com.redsocial.bean.FiltroUsuario;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.bean.UsuarioDatosBean;
import com.redsocial.dao.MySqlUsuarioDAO;

public class DejameProbar {
public static void main(String[] args) {
	MySqlUsuarioDAO dao = new MySqlUsuarioDAO();
	/*UsuarioBean usu = new UsuarioBean();
	usu.setMail("maysu@gmail.com");
	usu.setPass("1234");
	try {
		System.out.println(dao.loginUsuario(usu).get(0).getId());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
/*	usu.setNom("may");
	usu.setMail("may@gmail.com");
	usu.setPass("1234");
	
	// ------------------------
	
	String fecNac = "2000-11-04";
	int hijos = 1;
	int miAltura = 160;
	String ocu = "Programador";
	
	usu.setFecNac(fecNac);
	usu.setHijos(hijos);
	usu.setMiAltura(miAltura);
	usu.setOcu(ocu);
	
	try {
		
		dao.insertaUsuario(usu);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	FiltroUsuario filtro = new FiltroUsuario();
	filtro.setSexo(1);
	filtro.setEdadMin(15);
	filtro.setEdadMax(21);
	try {
		for(UsuarioBean b : dao.buscaOtroUsuario(filtro)){
			System.out.println(b.getNom()+" - "+b.getEdad()+" - "+b.getOcu());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("---------------------busca mis datos------------------------------");
	UsuarioBean b2 = new UsuarioBean();
	String filtro2= "nina@gmail.com";
	b2.setMail(filtro2);
	try {
		for(UsuarioBean b : dao.consultaMisDatos(b2)){
			System.out.println(b.getNom());
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
