/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jonas
 */
@Path("ProxyApi")
public class Proxy {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Proxy
     */
    public Proxy() {
    }

    /**
     * Retrieves representation of an instance of proxy.Proxy
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
return "Hej";
    }

    /**
     * PUT method for updating or creating an instance of Proxy
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countries/{countriesid}")
    public String getFromAll(@PathParam("countriesid") String id) throws MalformedURLException, IOException {
        URL url;
        String jsonStr = null;
            url = new URL("http://restcountries.eu/rest/v1/alpha?codes=" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            Scanner scan = new Scanner(con.getInputStream());           
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
            scan.close();
        return jsonStr;
    }
}
