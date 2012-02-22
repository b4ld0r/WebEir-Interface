package com.ciia.webeirinterface.dao;

import java.util.List;

import com.ciia.webeirinterface.model.db.Escenario;
import com.ciia.webeirinterface.model.db.Motivo;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class MotivoDAO {
	private static final String LISTA_MOTIVO = "Motivo.getListaMotivo";
	private static final String INSERTAR_MOTIVO = "Motivo.insertMotivo";
	private static final String ACTUALIZAR_MOTIVO = "Motivo.updateMotivo";
	private static final String MOTIVO_POR_ESCENARIO = "Motivo.getMotivosEscenario";
	private static final String BORRADO_LOGICO = "Motivo.borradoLogico";
	
	public MotivoDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Motivo> consultarMotivo() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Motivo>)ibatis.getSqlSession().selectList(LISTA_MOTIVO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de motivo. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Motivo insertarMotivo(Motivo motivo) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_MOTIVO, motivo);
			
			if (inserta != null && inserta > 0)
			{	
				ibatis.getSqlSession().commit();
				return motivo;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al insertar el motivo. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean actualizarMotivo(Motivo motivo) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(ACTUALIZAR_MOTIVO, motivo);
			
			if (actualiza != null && actualiza > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al acutalizar el motivo. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Motivo> consultarMotivoPorEscenario(Escenario escenario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Motivo>)ibatis.getSqlSession().selectList(MOTIVO_POR_ESCENARIO, escenario);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de motivos por escenario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean activarDesactivarMotivo(Motivo motivo) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(BORRADO_LOGICO, motivo);
			
			if (actualiza != null && actualiza > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al " + (motivo.getActivo() == true ? "activar" : "desactivar") + " el motivo. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
