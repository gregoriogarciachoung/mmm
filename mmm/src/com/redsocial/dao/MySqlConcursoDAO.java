package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.ConcursoBean;

public class MySqlConcursoDAO implements ConcursoDAO {
	/*
	 * Session en myIbatis-->Coneccion de BD
	 * SqlSessionFactory -->Permite crear conexiones
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
	@Override
	public int eliminaConcurso(int idConcurso) throws Exception {
		int salida = -1;
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			salida = sesion.delete("SQL_eliminaConcurso", idConcurso);
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
		} finally{
			sesion.close();
		}
		return salida;
	}
	@Override
	public int insertaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			salida = sesion.insert("SQL_insertaConcurso", obj);
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
		} finally{
			sesion.close();
		}
		return salida;
	}
	@Override
	public int actualizaConcurso(ConcursoBean obj) throws Exception {
		int salida = -1;
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			salida = sesion.update("SQL_actualizaConcurso", obj);
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
		} finally{
			sesion.close();
		}
		return salida;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ConcursoBean> consultaConcurso(String filtro) throws Exception {
		List<ConcursoBean> lista = new ArrayList<ConcursoBean>();
		SqlSession sesion = null; 
		try {
			sesion =  sqlMapper.openSession();
			lista = sesion.selectList("SQL_listaConcurso", filtro+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sesion.close();
		}
		return lista;
	}
	
	
	
}
