package br.com.algartelecom.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.LocalBinding;

import br.com.algartelecom.dao.IChampionDAO;
import br.com.algartelecom.model.Champion;
import br.com.algartelecom.services.ChampionService;

@Stateless
@LocalBinding(jndiBinding = "jpaExempo-ola/ChampionService/local")
public class ChampionServiceBean  implements ChampionService{
	
	@EJB
	private IChampionDAO championDao;
	
	public Champion getChampionID(int idChampion) {
		return championDao.getById(idChampion);
	}
	
	public List<Champion> getTodosChampions(){
		return championDao.findAll();
	}
	
	public boolean insereChampion(Champion champion) {
		championDao.persist(champion);
		return true;
	}
	
	public boolean deletaCampion(int idChampion) {
		championDao.remove(championDao.getById(idChampion));
		return true;
	}
	
	public Champion updateChampion(int idChampion, Champion champion) {
		championDao.merge(champion);
		return champion;
	}
}
