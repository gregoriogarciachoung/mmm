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
import com.redsocial.bean.Relacion;
import com.redsocial.bean.UsuarioBean;
import com.redsocial.bean.UsuarioDatosBean;

public class MySqlRelacionInteresDAO {

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

	
	@SuppressWarnings("unchecked")

	public List<Relacion> listaRelacionInteres() throws Exception {
		List<Relacion> lista = new ArrayList<Relacion>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_listaRelacion");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
}
