

package br.com.algartelecom.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.algartelecom.dao.IChampionDAO;
import br.com.algartelecom.model.Champion;


@Stateless
public class ChampionDAO implements IChampionDAO {

	@PersistenceContext
    protected EntityManager entityManager;
    
    public Champion getById(final int id) {
        return entityManager.find(Champion.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Champion> findAll() {
              return entityManager.createQuery("FROM " + Champion.class.getName()).getResultList();
    }
    
    public void persist(Champion champion) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.persist(champion);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void merge(Champion champion) {
        try {
                 entityManager.getTransaction().begin();
                 entityManager.merge(champion);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void remove(Champion champion) {
        try {
                 entityManager.getTransaction().begin();
                 champion = entityManager.find(Champion.class, champion.getId());
                 entityManager.remove(champion);
                 entityManager.getTransaction().commit();
        } catch (Exception ex) {
                 ex.printStackTrace();
                 entityManager.getTransaction().rollback();
        }
    }
    
    public void removeById(final int id) {
        try {
                 Champion champion = getById(id);
                 remove(champion);
        } catch (Exception ex) {
                 ex.printStackTrace();
        }
    }
    
}