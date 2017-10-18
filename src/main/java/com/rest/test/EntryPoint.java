/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.test;

/**
 *
 * @author User
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.io.IOException;

@Path("/entry-point")
public class EntryPoint {

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Test";
    }
    
    @GET
    @Path("/testDeployment")
    @Produces(MediaType.TEXT_PLAIN)
    public String testDeployment() {
        
        String response = " ";
        String restURL = "http://192.168.1.143:8080/entry-point/test";
            
        try {
            URL url = new URL(restURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Authorization", "Bearer "+sessionId);

//            System.out.println("sessionId>>>> "+sessionId);
            System.out.println("restURL>>>> "+restURL);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            
            
            String output;
            
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                response += output; 
            }

            conn.disconnect();
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Response from '" + restURL + "' => " + response;

    }
}