/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Persona;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author 5ei
 */
public interface PersonaDao {
    
    List<Persona> findAll();
    //List<Persona> findById(Long id);
    Persona findById(Long id);
    List<Persona> findByNome(String nome);
    List<Persona> findByCognome(String cognome);
    List<Tuple> findRicevuteByCognome(String cognome);
    boolean insertPersona(Persona p);
    
    boolean updatePersonaNome(Long id, String nome);
    boolean updatePersonaCognome(Long id, String cognome);
    
    boolean deletePersona(Persona p);
    
}
