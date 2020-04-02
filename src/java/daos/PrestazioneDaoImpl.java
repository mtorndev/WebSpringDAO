/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;


import entity.Persona;
import entity.Prestazione;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class PrestazioneDaoImpl implements PrestazioneDao {
    
    private final EntityManager em;
    String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";

    public PrestazioneDaoImpl() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public PrestazioneDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Prestazione> findAll() {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u", Prestazione.class);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public List<Prestazione> findById(Long id) {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u WHERE u.id=:id", Prestazione.class);
        typedQuery.setParameter("id", id);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public List<Prestazione> findByOra(String ora) {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u WHERE u.ora=:ora", Prestazione.class);
        typedQuery.setParameter("ora", ora);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public List<Prestazione> findByData(String data) {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u WHERE u.data=:data", Prestazione.class);
        typedQuery.setParameter("data", data);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public List<Prestazione> findByPersonaRicevente(Persona p) {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u WHERE u.personaRicevente=:pr", Prestazione.class);
        typedQuery.setParameter("pr", p);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public List<Prestazione> findByPersonaInviante(Persona p) {
        TypedQuery<Prestazione> typedQuery = em.createQuery("SELECT u FROM Prestazione u WHERE u.personaInviante=:pi", Prestazione.class);
        typedQuery.setParameter("pi", p);
        List<Prestazione> prestazioneList = typedQuery.getResultList();
        return prestazioneList;
    }

    @Override
    public boolean insertPrestazione(Prestazione pr) {
        em.getTransaction().begin();
        try {
            em.persist(pr);
            em.getTransaction().commit();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean updatePrestazioneData(Long id, String data) {
        em.getTransaction().begin();
        Prestazione pr = em.find(Prestazione.class, id);
        pr.setData(data);
        try {
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    @Override
    public boolean updatePrestazioneOra(Long id, String ora) {
        em.getTransaction().begin();
        Prestazione pr = em.find(Prestazione.class, id);
        pr.setOra(ora);
        try {
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean deletePrestazione(Prestazione pr) {
         em.getTransaction().begin();
        try {
            em.remove(pr);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
}
