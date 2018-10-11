
package com.redsocial.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.dao.MySqlUsuarioDAO;

@ParentPackage("dawi")
public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private String usu,pass;//login.jsp 
	public String correo;//variable que guarda el correo y manda desde la pg login.jsp "registro" y la visualiza en registro.jsp 
	public String registrar(){
		correo = usu;
		return "SUCCESS";
	}
	
	Map<String,Object>map;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.map=arg0;

	}
	public String excecute(){
		UsuarioBean filtro = new UsuarioBean();
		filtro.setMail(usu);
		filtro.setPass(pass);
		int ps = 2;
		try {
			ps = new MySqlUsuarioDAO().loginUsuario(filtro).get(0).getId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ps == 1){	
			map.put("emp", usu);
			map.put("permiso", "sip");
			return "SUCCESS";
		}else{
			return "LOGIN";
		}

	}
	public String cerrar(){
		map.put("permiso", "nop");
		return "LOGIN";
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsu() {
		return usu;
	}
	public void setUsu(String usu) {
		this.usu = usu;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
		

}