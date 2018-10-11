package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.FiltroUsuario;
import com.redsocial.bean.InteresesUsuario;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.bean.UsuarioDatosBean;

public class MySqlUsuarioDAO {

	/*
	 * Session en myIbatis-->Coneccion de BD SqlSessionFactory -->Permite crear
	 * conexiones
	 */

	SqlSessionFactory sqlMapper = null;
	{
		String archivo = "ConfiguracionIbatis.xml";
		try {
			Reader reader = Resources.getResourceAsReader(archivo);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public int insertaUsuario(UsuarioBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaUsuario", bean);
			session.commit(); 
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}  finally{
			session.close();
		}
		return salida;
	}
	
	public int insertaUsuarioDatos(UsuarioDatosBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaUsuarioDatos", bean);
			session.commit(); 
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}  finally{
			session.close();
		}
		return salida;
	}
	
	
	@SuppressWarnings("unchecked")
	
	public List<UsuarioBean> loginUsuario(UsuarioBean filtro) throws Exception {
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_loginUsuario", filtro);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	
@SuppressWarnings("unchecked")
	
	public List<UsuarioBean> buscaOtroUsuario(FiltroUsuario filtro) throws Exception {
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_buscaOtroUsuario", filtro);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}

@SuppressWarnings("unchecked")

public List<UsuarioBean> consultaMisDatos(UsuarioBean filtro) throws Exception {
	List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
	SqlSession sesion = null; 
	try {
		sesion =  sqlMapper.openSession();
		lista = sesion.selectList("SQL_consultaMisDatos", filtro);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		sesion.close();
	}
	return lista;
}

@SuppressWarnings("unchecked")

public List<FiltroUsuario> consultaMisFiltros(UsuarioBean filtro) throws Exception {
	List<FiltroUsuario> lista = new ArrayList<FiltroUsuario>();
	SqlSession sesion = null; 
	try {
		sesion =  sqlMapper.openSession();
		lista = sesion.selectList("SQL_consultaMisFiltros", filtro);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		sesion.close();
	}
	return lista;
}

@SuppressWarnings("unchecked")

public List<InteresesUsuario> listaRespuestaIntereses(UsuarioBean filtro) throws Exception {
	List<InteresesUsuario> lista = new ArrayList<InteresesUsuario>();
	SqlSession sesion = null; 
	try {
		sesion =  sqlMapper.openSession();
		lista = sesion.selectList("SQL_listaRespuestaIntereses", filtro);
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		sesion.close();
	}
	return lista;
}

}
