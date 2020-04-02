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
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository("daoManager")
public class PersonaDaoImpl implements PersonaDao {

    private final EntityManager em;
    String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";

    public PersonaDaoImpl() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public PersonaDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Persona> findAll() {
        TypedQuery<Persona> typedQuery = em.createQuery("SELECT u FROM Persona u", Persona.class);
        List<Persona> personaList = typedQuery.getResultList();
        return personaList;
    }

    @Override
    public Persona findById(Long id) {
        TypedQuery<Persona> typedQuery = em.createQuery("SELECT u FROM Persona u WHERE u.id=:id", Persona.class);
        typedQuery.setParameter("id", id);
        Persona persona = typedQuery.getResultList().get(0);
        return persona;
    }

    @Override
    public List<Persona> findByNome(String nome) {
        TypedQuery<Persona> typedQuery = em.createQuery("SELECT u FROM Persona u WHERE u.nome=:nome", Persona.class);
        typedQuery.setParameter("nome", nome);
        List<Persona> personaList = typedQuery.getResultList();
        return personaList;
    }

    @Override
    public List<Persona> findByCognome(String cognome) {
        TypedQuery<Persona> typedQuery = em.createQuery("SELECT u FROM Persona u WHERE u.cognome=:cognome", Persona.class);
        typedQuery.setParameter("cognome", cognome);
        List<Persona> personaList = typedQuery.getResultList();
        return personaList;
    }

    @Override
    public List<Tuple> findRicevuteByCognome(String cognome) {
        TypedQuery<Tuple> typedQuery = em.createQuery(
                "SELECT u,p FROM Persona u JOIN Prestazione p ON u=p.personaID_R WHERE u.cognome=:cognome",
                Tuple.class);
        typedQuery.setParameter("cognome", cognome);
        List<Tuple> pers_prestList = typedQuery.getResultList();
        return pers_prestList;
    }

    @Override
    public boolean insertPersona(Persona p) {
        em.getTransaction().begin();
        try {
            em.persist(p);
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
    public boolean updatePersonaNome(Long id, String nome) {
        em.getTransaction().begin();
        Persona persona = em.find(Persona.class, id);
        persona.setNome(nome);
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
    public boolean updatePersonaCognome(Long id, String cognome) {
        em.getTransaction().begin();
        Persona persona = em.find(Persona.class, id);
        persona.setCognome(cognome);
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
    public boolean deletePersona(Persona p) {
        em.getTransaction().begin();
        try {
            em.remove(p);
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
