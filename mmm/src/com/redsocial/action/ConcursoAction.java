package com.redsocial.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.ConcursoBean;
import com.redsocial.service.ConcursoService;
import com.redsocial.service.ConcursoServiceImpl;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class ConcursoAction extends ActionSupport{
	
	private static final Log log = LogFactory.getLog(ConcursoAction.class);

	//Para la consulta
	private List<ConcursoBean> concursos= new ArrayList<ConcursoBean>();
	private String filtro ="";
	
	//para el registrar y actualizar
	private String id;
	private ConcursoBean concurso = new ConcursoBean();
	
	@Action(value="/eliminaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")	})
	public String elimina(){
		log.info("En eliminar concurso");
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.eliminaConcurso(Integer.parseInt(id));
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	@Action(value="/actualizaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String actualiza(){
		log.info("En actualizar concurso");	
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.actualizaConcurso(concurso);
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	

	@Action(value="/registraConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String registra(){
		log.info("En registrar concurso");		
		
		try {
			ConcursoService service = new ConcursoServiceImpl();
			service.insertaConcurso(concurso);
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	@Action(value="/consultaConcurso",results={@Result(name="success", location="/crudConcurso.jsp")})
	public String listar(){
		log.info("En listar concurso");	
		ConcursoService service = new ConcursoServiceImpl();
		try {
			concursos =  service.consultaConcurso(filtro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	

	public List<ConcursoBean> getConcursos() {
		return concursos;
	}


	public void setConcursos(List<ConcursoBean> concursos) {
		this.concursos = concursos;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}






	public ConcursoBean getConcurso() {
		return concurso;
	}


	public void setConcurso(ConcursoBean concurso) {
		this.concurso = concurso;
	}



}



