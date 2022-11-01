/**
 * 
 */
package com.proyecto.business;


import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.banco.BancoServiceStub;
import com.banco.RequestBancoDocument;
import com.banco.ResponseBancoDocument;
import com.banco.UsuarioType;
import com.disney.DisneyServiceStub;
import com.disney.RequestDisneyDocument;
import com.disney.ResponseDisneyDocument;
import com.hbomax.HboServiceStub;
import com.hbomax.RequestHboDocument;
import com.hbomax.ResponseHboDocument;
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
	
	public String Cobro(UsuarioDto usuarioDto)  {
		BancoServiceStub service;
		try {
			service = new BancoServiceStub();
			
			RequestBancoDocument reqDoc = RequestBancoDocument.Factory.newInstance();
			
			UsuarioType response = reqDoc.addNewRequestBanco();
			response.setNombre(usuarioDto.getNombre());
			response.setApellido(usuarioDto.getApellido());
			response.setUsername(usuarioDto.getUsername());
			response.setPassword(usuarioDto.getPassword());
			
			ResponseBancoDocument bancoOperation = service.bancoOperation(reqDoc);

			return bancoOperation.getResponseBanco().getMensaje();
			
			
		} catch (RemoteException e) {
			return null;
		}
		
	}
	
	public String SubDisney(UsuarioDto usuarioDto) {
		try {
			DisneyServiceStub disneyService = new DisneyServiceStub();
			
			RequestDisneyDocument reqDoc = RequestDisneyDocument.Factory.newInstance();
			
			com.disney.UsuarioType response = reqDoc.addNewRequestDisney();
			response.setUsername(usuarioDto.getUsername());
			response.setPassword(usuarioDto.getPassword());
			
			ResponseDisneyDocument disneyOperation = disneyService.disneyOperation(reqDoc);
			
			String responseString = disneyOperation.getResponseDisney().getMensaje();
			
			return responseString;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}
	
	public String SubHbo(UsuarioDto usarioDto) {
		try {
			HboServiceStub hboService = new HboServiceStub();
			
			RequestHboDocument reqDoc = RequestHboDocument.Factory.newInstance();
			
			com.hbomax.UsuarioType response = reqDoc.addNewRequestHbo();
			response.setUsername(usarioDto.getUsername());
			response.setUsername(usarioDto.getPassword());
			
			ResponseHboDocument hboOperation = hboService.hboOperation(reqDoc);
			
			String responseString = hboOperation.getResponseHbo().getMensaje();
			return responseString;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Recibe la instancia de DAO
	 * 
	 * @param usuarioDao the usuarioDao to set
	 */
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
