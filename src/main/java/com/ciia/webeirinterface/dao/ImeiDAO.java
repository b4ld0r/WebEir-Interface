package com.ciia.webeirinterface.dao;

import com.ciia.webeirinterface.model.db.Imei;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class ImeiDAO {
	private static final String CONSULTA_POR_IMEI = "Imei.consultaIMEI";
	
	public ImeiDAO() {
		// TODO Auto-generated constructor stub
	}

	public Imei consultaPorImei(Imei imei) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Imei resultadoImei = new Imei();
			resultadoImei = (Imei)ibatis.getSqlSession().selectOne(CONSULTA_POR_IMEI, imei);
			
			return resultadoImei == null ? null : resultadoImei;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Error al obtener el IMEI. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
