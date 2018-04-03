

package br.com.algartelecom.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.algartelecom.model.Champion;

@Local
public interface IChampionDAO  {

   public Champion getById(final int id);
   public List<Champion> findAll();
   public void persist(Champion champion) ;	  
   public void merge(Champion champion); 
   public void remove(Champion champion) ; 
   public void removeById(final int id);
    
}