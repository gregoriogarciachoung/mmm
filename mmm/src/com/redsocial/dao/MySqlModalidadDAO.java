package com.redsocial.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.redsocial.bean.DeporteBean;
import com.redsocial.bean.ModalidadBean;

public class MySqlModalidadDAO implements ModalidadDAO {

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
	@Override
	public List<ModalidadBean> listaModalidad(String filtro) throws Exception {
		List<ModalidadBean> lista = new ArrayList<ModalidadBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			lista = session.selectList("SQL_consultaModalidad",filtro +"%");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public int actualizaModalidad(ModalidadBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.update("SQL_actualizaModalidad",bean);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int insertaModalidad(ModalidadBean bean) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.insert("SQL_insertaModalidad", bean);
			session.commit(); 
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}  finally{
			session.close();
		}
		return salida;
	}

	@Override
	public int eliminaModalidad(int idModalidad) throws Exception {
		int salida = -1;
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			salida = session.delete("SQL_eliminaModalidad",idModalidad);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally{
			session.close();
		}
		return salida;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeporteBean> listaDeporte() throws Exception {
		List<DeporteBean> lista = new ArrayList<DeporteBean>();
		SqlSession session = null;
		try {
			session = sqlMapper.openSession();
			lista = session.selectList("SQL_listaDeporte");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return lista;
	}

}
