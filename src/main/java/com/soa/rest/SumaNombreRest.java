/**
 * 
 */
package com.soa.rest;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soa.dto.Response;
import com.soa.dto.Documento;
import com.soa.dto.Registro;
import com.soa.dto.Request;

/**
 * 
 */

@RestController
public class SumaNombreRest {

    @GetMapping("/nombre/{nombre}/{segnombre}/{appat}/{apmat}")
    public ResponseEntity<Response> consultar(
            @PathVariable Integer nombre,
            @PathVariable Integer segnombre,
            @PathVariable Integer appat,
            @PathVariable Integer apmat) {
        ResponseEntity<Response> re = null;
        Response response = new Response();
        Documento documento = new Documento();
        Request request = new Request();
        Registro registro = new Registro();
        registro.setLizbeth(nombre);
        registro.setMaria(segnombre);
        registro.setVelasco(apmat);
        registro.setRicardez(apmat);
        request.setRegistro(registro);
        
        Integer resultado = registro.getLizbeth() + registro.getMaria() + registro.getVelasco() + registro.getRicardez();

        documento.setRespuesta(resultado);
        response.setDocumento(documento);

        re = new ResponseEntity<Response>(response, HttpStatus.OK);
        return re;
    }

    @PutMapping("/nombre")
    public ResponseEntity<Response> modificar(@RequestBody Registro registro) {
        ResponseEntity<Response> re = null;
        Response response = new Response();
        Documento documento = new Documento();
        
        Integer resultado = registro.getLizbeth() + registro.getMaria() + registro.getVelasco() + registro.getRicardez();

        documento.setRespuesta(resultado);
        response.setDocumento(documento);
 
        re = new ResponseEntity<>(response, HttpStatus.OK);
        return re;
    }
}
