package com.ciia.webeirinterface.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciia.webeirinterface.model.db.Bitacora;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class BitacoraDAO {
	private static final String INSERTAR_BITACORA = "Bitacora.insertBitacora";
	private static final String LISTA_BITACORA = "Bitacora.getListaBitacora";
	
	public BitacoraDAO() {
		// TODO Auto-generated constructor stub
	}

	public Bitacora insertarBitacora(Bitacora bitacora) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("idBitacora", bitacora.getIdBitacora());
			pMap.put("fecha", bitacora.getFecha());
			pMap.put("hora", bitacora.getHora());
			pMap.put("campo", bitacora.getCampo());
			pMap.put("idAccion", bitacora.getAccion().getIdAccion());
			pMap.put("idModuloSistema", bitacora.getModuloSistema().getIdModuloSistema());
			pMap.put("idUsuario", bitacora.getUsuario().getIdUsuario());
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_BITACORA, pMap);
			
			if (inserta != null && inserta > 0)
			{	
				ibatis.getSqlSession().commit();
				bitacora.setIdBitacora(new Integer(pMap.get("idBitacora").toString()));
				return bitacora;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al insertar la bitacora. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Bitacora> consultarBitacora() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Bitacora>)ibatis.getSqlSession().selectList(LISTA_BITACORA);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de bitacora. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
