package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.FiltroUsuario;
import com.redsocial.bean.InteresesUsuario;
import com.redsocial.bean.Relacion;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.dao.MySqlRelacionInteresDAO;
import com.redsocial.dao.MySqlUsuarioDAO;
import javax.servlet.http.HttpSession;  
import org.apache.struts2.ServletActionContext;

@ParentPackage("dawi")
public class ListaAction extends ActionSupport{

	/**
	 * 
	 */
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	private List<Relacion> lstRelacionInteres = new ArrayList<Relacion>();
	
	
	@Action(value = "/listaRelacionInteres", results = { @Result(name = "success", type = "json") })
	public String misDatos() {
		System.out.println("------------++++------------------+++++-------------------");
		try {
			
			MySqlRelacionInteresDAO service = new MySqlRelacionInteresDAO();

			lstRelacionInteres =  service.listaRelacionInteres();
			System.out.println("-----------------------------------");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	public List<Relacion> getLstRelacionInteres() {
		return lstRelacionInteres;
	}


	public void setLstRelacionInteres(List<Relacion> lstRelacionInteres) {
		this.lstRelacionInteres = lstRelacionInteres;
	}
	
	

}
