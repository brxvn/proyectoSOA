/**
 * 
 */
package com.proyecto.business;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

//import com.banco.BancoServiceStub;
//import com.banco.RequestBancoDocument;
//import com.banco.ResponseBancoDocument;
//import com.banco.ResponseBancoDocument.ResponseBanco;
//import com.banco.UsuarioType;
import com.proyecto.ResponseProyectoDocument.ResponseProyecto;
import com.springsample.dao.UsuarioDao;
import com.springsample.dto.UsuarioDto;

/**
 * @author brayg
 *
 */
public class ProyectoBusiness {

	private UsuarioDao usuarioDao;

	public String AddUser(UsuarioDto usuarioDto) {
		try {
			usuarioDao.add(usuarioDto);
		} catch (Exception e) {
			return e.getMessage();
		}
		return usuarioDto.getNombre() + " fue agregado exitosamente.";
	}
	
//	public String Cobro(UsuarioDto usuarioDto)  {
//		BancoServiceStub service;
//		try {
//			service = new BancoServiceStub();
//			
//			RequestBancoDocument reqDoc = RequestBancoDocument.Factory.newInstance();
//			
//			UsuarioType response = reqDoc.addNewRequestBanco();
//			response.setNombre(usuarioDto.getNombre());
//			
//			ResponseBancoDocument bancoOperation = service.bancoOperation(reqDoc);
//
//			return bancoOperation.getResponseBanco().getMensaje();
//			
//			
//		} catch (RemoteException e) {
//			return null;
//		}
//		
//	}

	/**
	 * Recibe la instancia de DAO
	 * 
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
