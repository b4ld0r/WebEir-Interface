package com.ciia.webeirinterface.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciia.webeirinterface.model.db.Solicitud;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class SolicitudDAO {
	private static final String LISTA_SOLICITUD_SF = "Solicitud.getListaSolicitudSF";
	private static final String LISTA_SOLICITUD = "Solicitud.getListaSolicitud";
	
	public SolicitudDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Solicitud> consultarSolicitud() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Solicitud>)ibatis.getSqlSession().selectList(LISTA_SOLICITUD_SF);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de solicitud. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> consultarSolicitud(Integer cursor, Integer registros, String columnas) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("cursor", cursor);
			pMap.put("registros", registros);
			pMap.put("columnas", columnas);
			
			return (List<Solicitud>)ibatis.getSqlSession().selectList(LISTA_SOLICITUD, pMap);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de solicitud. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
