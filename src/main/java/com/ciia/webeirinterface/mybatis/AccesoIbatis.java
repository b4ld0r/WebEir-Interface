package com.ciia.webeirinterface.mybatis;

import java.io.*;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccesoIbatis {
	private static final String CONFIGURACION = "IbatisConfig.xml";
	private static final String PROPIEDADES = "MyBatisProp.properties";
	private SqlSession sqlSession;
	
	public AccesoIbatis () {
		
	}
	
	public void generarSession() throws Exception {
		try {
			Properties prop = new Properties();
			Reader readerProp = Resources.getResourceAsReader(PROPIEDADES);
			prop.load(readerProp);
			
			Reader reader = Resources.getResourceAsReader(CONFIGURACION);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, prop.getProperty("JDBC.Ambiente"));
			this.sqlSession = sqlSessionFactory.openSession();
			
			readerProp.close();
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al generar la session. - " + e.getMessage());
		}
	}
	
	public void cerrarSession() throws Exception {
		try {
			this.sqlSession.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al cerrar la session. - " + e.getMessage());
		}
	}
	
	public SqlSession getSqlSession() {
		return this.sqlSession;
	}
}
