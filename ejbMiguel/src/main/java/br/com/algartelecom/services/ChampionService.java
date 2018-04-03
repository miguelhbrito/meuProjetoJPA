package br.com.algartelecom.services;

import java.util.List;

import javax.ejb.Local;

import br.com.algartelecom.model.Champion;

@Local
public interface ChampionService {

	public Champion getChampionID(int idChampion) ;
	public List<Champion> getTodosChampions();
	public boolean insereChampion(Champion champion) ;
	public boolean deletaCampion(int idChampion);
	public Champion updateChampion(int idChampion, Champion champion);
	
}
