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
import com.redsocial.dao.MySqlUsuarioDAO;
import javax.servlet.http.HttpSession;  
import org.apache.struts2.ServletActionContext;

@ParentPackage("dawi")
public class UsuarioAction extends ActionSupport{

	/**
	 * 
	 */
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	private List<UsuarioBean> lstOtroUsuario= new ArrayList<UsuarioBean>();
	FiltroUsuario filtro = new FiltroUsuario();
	private String mimail;
	private List<UsuarioBean> lstMisDatos= new ArrayList<UsuarioBean>();
	
	private List<FiltroUsuario> lstMisFiltros= new ArrayList<FiltroUsuario>();
	
	private List<InteresesUsuario> lstMisOtrosIntereses= new ArrayList<InteresesUsuario>();
	
	
	
	UsuarioBean u = new UsuarioBean();
	
	@Action(value = "/cargaOtroUsuario", results = { @Result(name = "success", type = "json") })
	public String cargaOtroUsuario() {
		try {
			//String mimail2="nina@gmail.com";
			String mimail2 =  session.getAttribute("emp").toString();
			u.setMail(mimail2);
			MySqlUsuarioDAO service = new MySqlUsuarioDAO();
			int s = service.consultaMisFiltros(u).get(0).getSexo();
			int max = service.consultaMisFiltros(u).get(0).getEdadMax();
			int min = service.consultaMisFiltros(u).get(0).getEdadMin();
			int rel = service.consultaMisFiltros(u).get(0).getRelacion().getId();
			//int s,min,max;
			//s=1;min=15;max=21;
			filtro.setSexo(s);
			filtro.setEdadMin(min);
			filtro.setEdadMax(max);
			Relacion r = new Relacion();
			r.setId(rel);
			filtro.setRelacion(r);
			
			System.out.println("----------lstOtroUsuario---------------------------------------");
			System.out.println(s+" - "+min+" - "+max+" - "+rel);
			
			lstOtroUsuario = service.buscaOtroUsuario(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	@Action(value = "/cargaMisDatos", results = { @Result(name = "success", type = "json") })
	public String misDatos() {
		System.out.println("------------++++-------------------------------------");
		try {
			
			MySqlUsuarioDAO service = new MySqlUsuarioDAO();
			
			
			u.setMail( session.getAttribute("emp").toString());
				
			lstMisDatos =  service.consultaMisDatos(u);
System.out.println("-----------------------------------");
			//System.out.println(lstMisDatos.get(0).getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	@Action(value = "/cargaMisFiltros", results = { @Result(name = "success", type = "json") })
	public String cargaMisFiltros() {
		try {
			//String mimail2="nina@gmail.com";
			String mimail2 =  session.getAttribute("emp").toString();
			u.setMail(mimail2);
			MySqlUsuarioDAO service = new MySqlUsuarioDAO();
			
			lstMisFiltros = service.consultaMisFiltros(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "/cargaMisOtrosIntereses", results = { @Result(name = "success", type = "json") })
	public String cargaMisOtrosIntereses() {
		try {
			//String mimail2="nina@gmail.com";
			String mimail2 =  session.getAttribute("emp").toString();
			u.setMail(mimail2);
			MySqlUsuarioDAO service = new MySqlUsuarioDAO();
			
			lstMisOtrosIntereses = service.listaRespuestaIntereses(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public List<UsuarioBean> getLstOtroUsuario() {
		return lstOtroUsuario;
	}

	public void setLstOtroUsuario(List<UsuarioBean> lstOtroUsuario) {
		this.lstOtroUsuario = lstOtroUsuario;
	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroUsuario filtro) {
		this.filtro = filtro;
	}

	public String getMimail() {
		return mimail;
	}

	public void setMimail(String mimail) {
		this.mimail = mimail;
	}

	public List<UsuarioBean> getLstMisDatos() {
		return lstMisDatos;
	}


	public void setLstMisDatos(List<UsuarioBean> lstMisDatos) {
		this.lstMisDatos = lstMisDatos;
	}


	public UsuarioBean getU() {
		return u;
	}


	public void setU(UsuarioBean u) {
		this.u = u;
	}

	public List<FiltroUsuario> getLstMisFiltros() {
		return lstMisFiltros;
	}


	public void setLstMisFiltros(List<FiltroUsuario> lstMisFiltros) {
		this.lstMisFiltros = lstMisFiltros;
	}
	
	
	
	// ------------------------ ------------------------ -------------------------

	public List<InteresesUsuario> getLstMisOtrosIntereses() {
		return lstMisOtrosIntereses;
	}


	public void setLstMisOtrosIntereses(List<InteresesUsuario> lstMisOtrosIntereses) {
		this.lstMisOtrosIntereses = lstMisOtrosIntereses;
	}



	HttpSession session=ServletActionContext.getRequest().getSession(false);  
	
}
