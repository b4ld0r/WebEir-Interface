package com.ciia.webeirinterface.controllers.catalogos;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.DocumentoDAO;
import com.ciia.webeirinterface.model.db.Accion;
import com.ciia.webeirinterface.model.db.Bitacora;
import com.ciia.webeirinterface.model.db.Documento;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;

import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/catalogos/")
public class DocumentosController {
	
	private final String tilesAsignado = "documentoTiles";
	
	private static Log logger = LogFactory.getLog(DocumentosController.class);
	private DocumentoDAO documentoDAO = new DocumentoDAO();
	
    @RequestMapping(value="documentos.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		return this.tilesAsignado;
	}
	

	@RequestMapping(value="obtenDocumentos.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Documento> listaElementos(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max,
      @RequestParam(value = "sord", required = false, defaultValue = ConstantesWeb.CONST_SORT_ASC) String sord,
	  @RequestParam(value = "sidx", required = false, defaultValue = ConstantesWeb.CONST_SORT_FIELD_DOCUMENTO) String sidx) {
		
		try {

			List<Documento> elementos =documentoDAO.consultarDocumento(max*(page-1), max, !ConstantesWeb.CONST_SORT_ASC.equals(sord));
			return new PaginaGrid<Documento>(elementos, page, documentoDAO.consultarTotalDocumento(Boolean.TRUE), max);
			
		} catch (Exception ex) {
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new PaginaGrid<Documento>();
		
	}
	
	@RequestMapping(value="editaDocumento.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson agregarEditar(@RequestBody Documento elemento, HttpServletRequest request) {
		
		RespuestaJson respuesta=new RespuestaJson();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<ControllerModelo:"  + request);
		try {
			
			if(elemento.getIdDocumento() == null){
				
				elemento.setActivo(Boolean.TRUE);
				if(documentoDAO.insertarDocumento(elemento) != null){
					this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_INSERTAR),elemento);
					
					respuesta.setMessage("El documento ha sido registrado correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					
					respuesta.setMessage("Ocurrió un error al registrar el documento");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}				
				
			}
			else{
				
				if(documentoDAO.actualizarDocumento(elemento)){
					
					this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_ACTUALIZAR),elemento);
					
					respuesta.setMessage("La información ha sido guardada correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}
				else{
					respuesta.setMessage("Ocurrió un error al editar el documento");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}
				
			}
			
		}catch (Exception ex) {
			logger.error(ex.getStackTrace());
			respuesta.setMessage("Ocurrió un error al insertar el registro de documento:"+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="eliminaDocumento.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaJson eliminar(@RequestParam(value = "id", required = true) int id, HttpServletRequest request) {
		RespuestaJson respuesta=new RespuestaJson();
		Documento elemento = new Documento(new Integer(id),Boolean.FALSE);
		
		try {
			
			if(documentoDAO.activarDesactivarDocumento(elemento)){
				elemento.setDescripcion("NoImplementado");
				elemento.setObligatorio(new Boolean(false));
				this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_ELIMINAR),elemento);
				
				respuesta.setMessage("El registro se eliminó correctamente.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				
			}
			else{
				respuesta.setMessage("No exite el documento.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			}
			
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			respuesta.setMessage("Ocurrió una excepcion: "+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		
		return respuesta;
	}
	
	private void agregarBitacora(HttpServletRequest request,Accion accion,Documento elemento){
		String descripcion = "Documento:" + elemento.getDescripcion() + ",Obligatorio:" + (elemento.getObligatorio()?"Si":"No") ;
		
		request.setAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA, new Bitacora(accion,descripcion));
	}
	
}

