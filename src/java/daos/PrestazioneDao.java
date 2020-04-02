/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entity.Persona;
import entity.Prestazione;
import java.util.List;

/**
 *
 * @author 5ei
 */
public interface PrestazioneDao {
    
    List<Prestazione> findAll();
    List<Prestazione> findById(Long id);
    List<Prestazione> findByOra(String ora);
    List<Prestazione> findByData(String data);
    List<Prestazione> findByPersonaRicevente(Persona p);
    List<Prestazione> findByPersonaInviante(Persona p);
    
    boolean insertPrestazione(Prestazione pr);
    
    boolean updatePrestazioneData(Long id, String data);
    boolean updatePrestazioneOra(Long id, String ora);
    
    boolean deletePrestazione(Prestazione pr);
    
}
