package com.ciia.webeirinterface.dao;

import java.util.List;

import com.ciia.webeirinterface.model.db.Documento;
import com.ciia.webeirinterface.mybatis.AccesoIbatis;

public class DocumentoDAO {
	private static final String LISTA_DOCUMENTO = "Documento.getListaDocumento";
	private static final String INSERTAR_DOCUMENTO = "Documento.insertDocumento";
	private static final String ACTUALIZAR_DOCUMENTO = "Documento.updateDocumento";
	private static final String BORRADO_LOGICO = "Documento.borradoLogico";
	
	public DocumentoDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Documento> consultarDocumento() throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			return (List<Documento>)ibatis.getSqlSession().selectList(LISTA_DOCUMENTO);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al obtener lista de documentos. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Documento insertarDocumento(Documento documento) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer inserta = ibatis.getSqlSession().insert(INSERTAR_DOCUMENTO, documento);
			
			if (inserta != null && inserta > 0)
			{	
				ibatis.getSqlSession().commit();
				return documento;
			}
			
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("Error al insertar el documento. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean actualizarDocumento(Documento documento) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(ACTUALIZAR_DOCUMENTO, documento);
			
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
			throw new Exception("Error al acutalizar el documento. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
	
	public Boolean activarDesactivarDocumento(Documento documento) throws Exception {
		AccesoIbatis ibatis = new AccesoIbatis();
		
		try {
			ibatis.generarSession();
			
			Integer actualiza = ibatis.getSqlSession().update(BORRADO_LOGICO, documento);
			
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
			throw new Exception("Error al " + (documento.getActivo() == true ? "activar" : "desactivar") + " el documento. - " + e.getMessage());
		} finally {
			ibatis.cerrarSession();
		}
	}
}
