package com.ciia.webeirinterface.controllers.catalogos;

import com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb;
import com.ciia.webeirinterface.dao.UsuarioDAO;
import com.ciia.webeirinterface.model.db.Documento;
import com.ciia.webeirinterface.model.db.Usuario;
import com.ciia.webeirinterface.model.json.PaginaGrid;
import com.ciia.webeirinterface.model.json.RespuestaJson;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
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
	private final String nombrePagina = "Documentos";
	
	private List<Documento> listaDummy ;
	
	{
		listaDummy = new ArrayList<Documento>();
		listaDummy.add(new Documento(new Integer(1),"Documento 1", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(2),"Documento 2", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(3),"Documento 3", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(4),"Documento 4", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(5),"Documento 5", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(6),"Documento 6", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(7),"Documento 7", new Boolean(true)));
		listaDummy.add(new Documento(new Integer(8),"Documento 8", new Boolean(true)));
	}
	
	
    @RequestMapping(value="documentos.htm",method = RequestMethod.GET)
	public String initForm(ModelMap model) {
    	model.addAttribute(ConstantesWeb.CONST_ATTRIBUTE_TITULO_PAGINA, nombrePagina);
    	
		return this.tilesAsignado;
	}
	

	@RequestMapping(value="obtenDocumentos.htm",method = RequestMethod.GET)
	 public @ResponseBody PaginaGrid<Documento> listaElementos(
      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
      @RequestParam(value = "max", required = false, defaultValue = "20") int max) {
		
		try {
			
			List<Documento> elementos = listaDummy;
			
			return new PaginaGrid<Documento>(elementos.subList(max*(page-1), (max*page)>elementos.size()?elementos.size():(max*page)), page, elementos.size(), max);
			
		} catch (Exception ex) {
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new PaginaGrid<Documento>();
	}
	
	@RequestMapping(value="editaDocumento.htm",method = {RequestMethod.PUT, RequestMethod.POST})
	public @ResponseBody RespuestaJson agregarEditar(@RequestBody Documento elemento) {
		
		RespuestaJson respuesta=new RespuestaJson();
		
		try {
			
			if(elemento.getIdDocumento() == null){
				/*
				if(usuarioDAO.insertarUsuario(usuario)!=null){
					respuesta.setMessage("El usuario ha sido creado correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					respuesta.setMessage("Ocurrió un error al insertar el usuario");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}*/
				elemento.setIdDocumento(this.listaDummy.size()+1);
				this.listaDummy.add(elemento);
				respuesta.setMessage("El usuario ha sido creado correctamente.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				
			}
			else{
				/*
				if(usuarioDAO.actualizarUsuario(usuario)){
					respuesta.setMessage("La información ha sido guardada correctamente.");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				}else{
					respuesta.setMessage("Ocurrió un error al editar al usuario");
					respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
				}*/
				
				Documento doc = null;
				int index = 0;
				for(Documento documento: this.listaDummy){
					if(documento.getIdDocumento().intValue() == elemento.getIdDocumento().intValue()){
						doc = documento;
						index = this.listaDummy.indexOf(doc);
						System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||>Index de actualizacion:" + index);
						break;
					}
				}
				
				this.listaDummy.set(index, elemento);
				
				respuesta.setMessage("La información ha sido guardada correctamente.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				
			}
			
		/*}catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException ex) {
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("El nombre de usuario asignado ya existe");
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);*/
		}catch (Exception ex) {
			
			Logger.getLogger(ex.getClass().getName());
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("Ocurrió un error al insertar el usuario:"+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			
		}
		return respuesta;
	}
	
	@RequestMapping(value="eliminaDocumento.htm",method = RequestMethod.POST)
	public @ResponseBody RespuestaJson eliminar(@RequestParam(value = "id", required = true) int id) {
		RespuestaJson respuesta=new RespuestaJson();
		Documento documento = null;
		int index = 0;
		
		
		try {
			
			
			//documento = usuarioDAO.usuarioPorId(new Usuario(id, null, null, null, null, null, null, null));
			for(Documento doc: this.listaDummy){
				if(doc.getIdDocumento().intValue() == id){
					documento = doc;
					index = this.listaDummy.indexOf(documento);
					break;
				}
			}
			
			if(documento!=null){
				
				if(documento.getActivo()){
					System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||>Index de eliminacion:" + index);
					documento.setActivo(Boolean.FALSE);
					//usuarioDAO.actualizarUsuario(usuario);
				}
				
				respuesta.setMessage("El registro se eliminó correctamente.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_SUCCESS);
				
			}else{
				respuesta.setMessage("No exite el documento.");
				respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
			}
		} catch (Exception ex) {
			Logger.getLogger(DocumentosController.class.getName()).log(Level.SEVERE, null, ex);
			respuesta.setMessage("Ocurrió una excepcion: "+ex.getMessage());
			respuesta.setStatus(ConstantesWeb.CONST_JSON_RESPONSE_STATUS_FAIL);
		}
		
		return respuesta;
	}
	
}

