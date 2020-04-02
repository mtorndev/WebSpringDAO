/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// see exaples
// https://crunchify.com/how-to-use-ajax-jquery-in-spring-web-mvc-jsp-example/
// http://www.lm-tech.it/Blog/post/2013/05/08/How-to-consume-a-RESTful-service-using-jQuery.aspx
// http://www.mkyong.com/spring-mvc/spring-4-mvc-ajax-hello-world-example/
// https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
// https://stackoverflow.com/questions/20245544/how-to-pass-json-object-from-ajax-to-spring-mvc-controller
// http://fruzenshtein.com/spring-mvc-ajax-jquery/
// https://msdn.microsoft.com/it-it/library/cc836466(v=vs.94).aspx
// https://api.jquery.com/jQuery.ajax/

var APP = {
    pressione_tasto_invia: function () {
        var par1 = $("#par_001").val();
        var jsPar = 'parametro=' + par1; // single quote
        //start ajax request
        $.ajax({
            //url: "/WebSpringDAO/echo.htm",
            url: "/WebSpringDAO/findBySurname.htm",
            //url: "/WebSpringDAO/findRequestPerson.htm",  
            method: "GET", //type: "GET",  // or method 
            contentType: "application/json; charset=utf-8",
            accepts: {json: "application/json, text/javascript"}, //text: "text/plain",
            data: jsPar, //Data to be sent to the server
            cache: false, //force requested pages not to be cached by the browser
            success: function (data) {  //A function to be called if the request succeeds
                //$("#result").html(data);
                var obj = JSON.parse(data);
                //$("#result").html(obj);    
                var out = '';
                if (typeof (obj) == 'undefined') //no value
                    out = 'Nessun risultato';
                else
                if (typeof (obj[0]) == 'undefined') { // single Value 
                    if (typeof (obj.valore) != 'undefined')
                        out = obj.valore;
                } else
                    for (i = 0; i < obj.length; i++) {
                        if (typeof (obj[i][0]) != 'undefined') { // Tuple
                            for (j = 0; j < obj[i].length; j++) {
                                var o = obj[i][j];
                                out += APP.JsonToString(o);
                            }
                        } else { // Single entity
                            var o = obj[i];
                            out += APP.JsonToString(o);
                        }
                    }
                $("#result").html(out);
            },
            error: function () {
                var out = 'Error';
                $("#result").html(out);
            }
        });
    },
    JsonToString: function (o) {
        var out = '';
        if (Object.keys(o).indexOf('cognome') > 0)
            out += ' ' + o.cognome;
        if (Object.keys(o).indexOf('nome') > 0)
            out += ' ' + o.nome;
        if (Object.keys(o).indexOf('data') > 0)
            out += ' ' + o.data;
        return out;
    },
    /*Event Listener
     *associa una funzione all'evento pressione tasto invia*/
    init_Click_button: function () {
        $("#btn_001").on('click', APP.pressione_tasto_invia);
    }
};
//Main viene eseguito quando il document è pronto => ready
//si aspetta che il document sia pronto => tutti i .js .css ecc. caricati
$(document).ready(function () {
    /*Initialize Click del testo invia*/
    APP.init_Click_button();
});


