package com.ciia.webeirinterface.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ciia.webeirinterface.model.db.Escenario;
import com.ciia.webeirinterface.model.db.Motivo;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class EscenarioDAO {
	private static final String LISTA_ESCENARIO = "Escenario.getListaEscenario";
	private static final String INSERTAR_ESCENARIO = "Escenario.insertEscenario";
	private static final String ACTUALIZAR_ESCENARIO = "Escenario.updateEscenario";
	private static final String ASIGNAR_MOTIVO = "Escenario.insertEscenarioMotivo";
	private static final String BORRADO_LOGICO = "Escenario.borradoLogico";
	
	public EscenarioDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Escenario> consultarEscenario() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Escenario>)ibatis.getSqlSession().selectList(LISTA_ESCENARIO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de escenario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Escenario insertarEscenario(Escenario escenario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_ESCENARIO, escenario);
			
			if (inserta != null && inserta > 0)
			{	
				ibatis.getSqlSession().commit();
				return escenario;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al insertar el escenario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean actualizarEscenario(Escenario escenario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(ACTUALIZAR_ESCENARIO, escenario);
			
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
			throw new Exception("Error al acutalizar el escenario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean asignarMotivo(Escenario escenario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer insertar = null;
			Map<String,Object> pMap = new HashMap<String, Object>();
			pMap.put("idEscenario", escenario.getIdEscenario());
			
			if (escenario.getMotivo() != null && !escenario.getMotivo().isEmpty()) {
				for (Motivo motivo : escenario.getMotivo()) {
					if (pMap.containsKey("idMotivo"))
						pMap.remove("idMotivo");
						
					pMap.put("idMotivo", motivo.getIdMotivo());
					
					insertar = ibatis.getSqlSession().insert(ASIGNAR_MOTIVO, pMap);
				}
			}
			else 
				return false;
			
			if (insertar != null &&  insertar > 0)
			{
				ibatis.getSqlSession().commit();
				return true;
			}
			
			ibatis.getSqlSession().rollback();
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			ibatis.getSqlSession().rollback();
			e.printStackTrace();
			throw new Exception("Error al asignar el perfil al usuario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean activarDesactivarEscenario(Escenario escenario) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(BORRADO_LOGICO, escenario);
			
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
			throw new Exception("Error al " + (escenario.getActivo() == true ? "activar" : "desactivar") + " el escenario. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
