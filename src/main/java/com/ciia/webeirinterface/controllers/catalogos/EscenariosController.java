package com.ciia.webeirinterface.controllers.catalogos;

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

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.EscenarioDAO;
import com.ciia.webeirinterface.model.db.Accion;
import com.ciia.webeirinterface.model.db.Bitacora;
import com.ciia.webeirinterface.model.db.Documento;
import com.ciia.webeirinterface.model.db.Escenario;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;

@Controller
@RequestMapping("/catalogos/")
public class EscenariosController {
	
	private final String tilesAsignado = "escenarioTiles";
	
	private static Log logger = LogFactory.getLog(EscenariosController.class);
	private EscenarioDAO escenarioDAO = new EscenarioDAO();
	
	@RequestMapping(value="escenarios.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
		model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO, new Escenario());
		
		return this.tilesAsignado;
	}
	
	@RequestMapping(value="obtenEscenarios.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Escenario> listaElementos(
     @RequestParam(value = "page", required = false, defaultValue = "1") int page,
     @RequestParam(value = "max", required = false, defaultValue = "20") int max,
     @RequestParam(value = "sord", required = false, defaultValue = ConstantesWeb.CONST_SORT_ASC) String sord,
	  @RequestParam(value = "sidx", required = false, defaultValue = ConstantesWeb.CONST_SORT_FIELD_DOCUMENTO) String sidx) {
		
		try {

			List<Escenario> elementos =escenarioDAO.consultarEscenario(max*(page-1), max, !ConstantesWeb.CONST_SORT_ASC.equals(sord));
			return new PaginaGrid<Escenario>(elementos, page, escenarioDAO.consultarTotalEscenario(Boolean.TRUE), max);
			
		} catch (Exception ex) {
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new PaginaGrid<Escenario>();
		
	}
	
	@RequestMapping(value="editaEscenario.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson agregarEditar(@RequestBody Escenario elemento, HttpServletRequest request) {
		RespuestaJson respuesta=new RespuestaJson();
		
		try {
			/*
			if(elemento.getIdEscenario() == null){
				
				elemento.setActivo(Boolean.TRUE);
				if(escenarioDAO.insertarEscenario(elemento) != null){
					this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_INSERTAR),elemento);
					
					respuesta.setMessage("El documento ha sido registrado correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					
					respuesta.setMessage("Ocurrió un error al registrar el documento");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}				
				
			}
			else{
				
				if(escenarioDAO.actualizarEscenario(elemento)){
					
					this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_ACTUALIZAR),elemento);
					
					respuesta.setMessage("La información ha sido guardada correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}
				else{
					respuesta.setMessage("Ocurrió un error al editar el documento");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}
				
			}*/
			
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			if(ex.getMessage().contains("MySQLIntegrityConstraintViolationException")){
				respuesta.setMessage("Nombre de escenario: El registro ya existe");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			}
			else{
				respuesta.setMessage("Ocurrió un error al insertar el registro de documento:"+ex.getMessage());
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			}
		}
		
		return respuesta;
	}
	
	@RequestMapping(value="eliminaEscenario.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaJson eliminar(@RequestParam(value = "id", required = true) int id, HttpServletRequest request) {
		RespuestaJson respuesta=new RespuestaJson();
		Escenario elemento = null;
		
		try {
			elemento = escenarioDAO.consultarEscenarioPorID(new Escenario(id));
			if(elemento != null){
				elemento.setActivo(Boolean.FALSE);
			}
			if(elemento != null && escenarioDAO.activarDesactivarEscenario(elemento)){
				this.agregarBitacora(request,new Accion(ConstantesWeb.CONST_ID_ACCION_ELIMINAR),elemento);
				
				respuesta.setMessage("El registro se eliminó correctamente.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				
			}
			else{
				respuesta.setMessage("No exite el escenario.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			}
			
		} catch (Exception ex) {
			logger.error(ex.getStackTrace());
			respuesta.setMessage("Ocurrió una excepcion: "+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		
		return respuesta;
	}

	private void agregarBitacora(HttpServletRequest request,Accion accion,Escenario elemento){
		String descripcion = "Escenario:" + elemento.getDescripcion() + ",Inicial:" + elemento.getInicial();
		
		request.setAttribute(ConstantesWeb.CONST_ATTRIBUTE_INTERCEPTOR_BITACORA, new Bitacora(accion,descripcion));
	}
}
