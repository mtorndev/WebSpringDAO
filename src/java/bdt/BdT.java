/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdt;

import daos.PersonaDao;
import daos.PersonaDaoImpl;
import daos.PrestazioneDao;
import daos.PrestazioneDaoImpl;
import entity.Persona;
import entity.Prestazione;

public class BdT {

    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDaoImpl();
        PrestazioneDao prestazioneDao = new PrestazioneDaoImpl();
        
        //insert example data
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();

        persona1.setCognome("Piano");
        persona2.setCognome("Verdi");

        persona1.setNome("Guido");
        persona2.setNome("Mario");

        Prestazione prestazione1 = new Prestazione();
        Prestazione prestazione2 = new Prestazione();
        Prestazione prestazione3 = new Prestazione();

        prestazione1.setData("2017/11/6");
        prestazione2.setData("2017/11/7");
        prestazione3.setData("2018/01/23");

        prestazione1.setOra("12:50");
        prestazione2.setOra("11:00");
        prestazione3.setOra("11:30");

        prestazione1.setPersonaID_R(persona1);
        prestazione2.setPersonaID_R(persona2);
        prestazione3.setPersonaID_R(persona1);
//        prestazione1.setPersonaID_F(persona1);
//        prestazione2.setPersonaID_F(persona1);
//        prestazione3.setPersonaID_F(persona2);

        personaDao.insertPersona(persona1);
        personaDao.insertPersona(persona2);
        prestazioneDao.insertPrestazione(prestazione1);
        prestazioneDao.insertPrestazione(prestazione2);
        prestazioneDao.insertPrestazione(prestazione3);
        
        for (Persona p : personaDao.findAll()) {
            System.out.println(
                    "Persona: " + p.getCognome() + " " + p.getNome()
            );
        }
    }

}
