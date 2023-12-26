/**
 * 
 */
package com.soa.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.soa.dto.Response;
import com.google.gson.Gson;
import com.soa.dto.Registro;
import com.soa.dto.Request;

/**
 * 
 */
class SumaNombreRestTest {

    //GET
    
    @Test
    void test() {
        SumaNombreRest sumaNombreRest = new SumaNombreRest();
        
        Request request = new Request();
        Registro registro = new Registro();
        registro.setLizbeth(1);
        registro.setMaria(2);
        registro.setVelasco(3);
        registro.setRicardez(4);
        
        ResponseEntity<Response> re = sumaNombreRest.consultar(registro.getLizbeth(), registro.getMaria(), registro.getVelasco(), registro.getRicardez());
        Gson gson = new Gson();
        System.out.println(gson.toJson(re.getBody()));
        assertEquals(HttpStatus.OK, re.getStatusCode()); //VERIFICA LA PRUEBA
    }
    
    //PUT
    
    @Test
    void test_put()
    {
        SumaNombreRest sumaNombreRest = new SumaNombreRest();
        
        Request request = new Request();
        Registro registro = new Registro();
        registro.setLizbeth(1);
        registro.setMaria(2);
        registro.setVelasco(3);
        registro.setRicardez(4);
        request.setRegistro(registro);
        
        ResponseEntity<Response> re = sumaNombreRest.modificar(registro);
        Gson gson = new Gson();
        System.out.println(gson.toJson(re.getBody()));
        assertEquals(HttpStatus.OK, re.getStatusCode()); //VERIFICA LA PRUEBA
    }

}
