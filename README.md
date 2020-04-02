# WebSpringDAO
WebSpringDAO - netbeans 8.2 app 

Applicazione BDTWebSpringDAO

#Requirements 
-	Netbean (8.2)
-	JPA per accesso al DB (derbyclient e eclipselink)
-	Framework Spring per gestione applicazione lato server
-	Javascript, html e css per gestione applicazione lato client
Librerie JPA disponibili nella cartella Requirements

#Description
-	Accesso al DB 
  o	Packages: bdt, daos, entity
  o	Services : DB
-	Lato Server : Spring 
  o	Package it.marconivr.controller 
  o	Cartella Web Pages\META-INF e Web Pages\WEB-INF
  o	Services : Apache 
-	 Lato Client (javascript, html, css)
  o	Cartella “Web Pages”

#Usage:
-	bdt\BdT.java – usare per creare e popolare le tabelle Persona e Prestazione (dopo avere creato il DB);
-	le classi PersonaDaoImpl  e PrestazioneDaoImpl  implementano una propria interfaccia; 
-	it.marconivr.controller prevede tre callback 
  o	msg00  : /WebSpringDAO/echo.htm 
    esegue echoing del testo inserito nella casella di testo
  o	msg01 : /WebSpringDAO/findBySurname.htm
    si aspetta un cognome tra quelli presenti nel DB (Verdi, Piano) ed espone i dati della persona trovata  
  o	msg02 : /WebSpringDAO/findRequestPerson.htm
    si aspetta un cognome tra quelli presenti nel DB (Verdi, Piano) ed 
    espone i dati della persona trovata e la data della Prestazione richiesta 
    (vedere JOIN attivata con nel metodo findRicevuteByCognome in PersonaDaoImpl
	
  Agire sul file indexAjax.js per variare la chiamata attuale (/WebSpringDAO/findBySurname.htm)
  -	la funzione in indexAjax.js eseguita nel caso di ritorno con successo dei dati dall’applicazione lato server è predisposta per           accettare json contenenti :
    o	un singolo valore (echoing), 
    o	una lista di valori (dati Persona)
    o	una tupla di liste di valori (dati Persona e Prestazione)
