package com.redsocial.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.redsocial.bean.InteresesUsuario;

@SuppressWarnings("serial")
@ParentPackage("dawi")
public class AbcAction extends ActionSupport{



	private boolean chk1=true;
	private boolean chk2=true;
	private boolean chk3=true;
	private boolean chk4=true;
	private boolean chk5=true;
	private boolean chk6=true;

	private InteresesUsuario iu;

	ArrayList<InteresesUsuario> agrega = new ArrayList<InteresesUsuario>();
	ArrayList<InteresesUsuario> elimina = new ArrayList<InteresesUsuario>();

	@Action(value="/std",
			results={@Result(name="success",location="/abc.jsp")
	})


	public String add(){
		System.out.println("--------------------------");
		//System.out.println(chk1);

		if(chk1==false){
			m(1);
		}else{
			n(1);
		}
		if(chk2==false){
			m(2);
		}else{
			n(2);
		}
		if(chk3==false){
			m(3);
		}else{
			n(3);
		}
		if(chk4==false){
			m(4);
		}else{
			n(4);
		}
		if(chk5==false){
			m(5);
		}else{
			n(5);
		}
		if(chk6==false){
			m(6);
		}else{
			n(6);
		}

		for(InteresesUsuario i : agrega){
			System.out.println("agrega "+i.getTrs1());
		}
		for(InteresesUsuario i : elimina){
			System.out.println("elimina "+i.getTrs1());
		}

		return SUCCESS;
	}

	public void m(int i){
		InteresesUsuario object = new InteresesUsuario();
		//object.setUsu(i);
		object.setTrs1(i);
		agrega.add(object);
		elimina.remove(object);
	}
	public void n (int i){
		InteresesUsuario object = new InteresesUsuario();
		//object.setUsu(i);
		object.setTrs1(i);
		agrega.remove(object);
		elimina.add(object);
	}



	public InteresesUsuario getIu() {
		return iu;
	}

	public void setIu(InteresesUsuario iu) {
		this.iu = iu;
	}

	public boolean isChk1() {
		return chk1;
	}


	public void setChk1(boolean chk1) {
		this.chk1 = chk1;
	}


	public boolean isChk2() {
		return chk2;
	}


	public void setChk2(boolean chk2) {
		this.chk2 = chk2;
	}


	public boolean isChk3() {
		return chk3;
	}


	public void setChk3(boolean chk3) {
		this.chk3 = chk3;
	}


	public boolean isChk4() {
		return chk4;
	}


	public void setChk4(boolean chk4) {
		this.chk4 = chk4;
	}


	public boolean isChk5() {
		return chk5;
	}


	public void setChk5(boolean chk5) {
		this.chk5 = chk5;
	}


	public boolean isChk6() {
		return chk6;
	}


	public void setChk6(boolean chk6) {
		this.chk6 = chk6;
	}




}
