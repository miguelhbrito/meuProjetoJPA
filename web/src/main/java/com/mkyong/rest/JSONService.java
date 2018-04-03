
package com.mkyong.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.mkyong.util.ServiceLocator;

import br.com.algartelecom.model.Champion;
import br.com.algartelecom.services.ChampionService;

@Path("/rest/")
public class JSONService {

	
	@EJB
	private ChampionService championServices;
	
	public JSONService(){
		championServices = ServiceLocator.getInstance().lookup("jpaExempo-ola/ChampionService/local");
	}

	@GET
	@Path("/champions/{id}")
	public Champion getChampionById(@PathParam("id") int idChampion) {
		return championServices.getChampionID(idChampion);
	}

	@GET
	@Path("/champions")
	public List<Champion> getChamionInJSON() {
		return championServices.getTodosChampions();
	}

	@POST
	@Path("/champions")
	@Consumes("application/json")
	public boolean insereCliente(Champion champion) {
		return championServices.insereChampion(champion);
	}

	@DELETE
	@Path("/champions/{id}")
	@Consumes("application/json")
	public boolean deletaCampion(@PathParam("id") int idChampion) {
		return championServices.deletaCampion(idChampion);
	}

	@PUT
	@Path("/champions/{id}")
	@Consumes("application/json")
	public Champion updateChampion(@PathParam("id") int idChampion, Champion champion) {
		return championServices.updateChampion(idChampion,champion);
	}

}