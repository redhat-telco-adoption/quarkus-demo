package com.redhat.adoption;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "kubernetes.namespace", defaultValue = "Not defined!")
    String k8sNamespace;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {

        Map<String, String> resp = new HashMap<>();

        resp.put("msg", "Quarkus Demo Application");
        resp.put("namespace", k8sNamespace);

        return resp;
    }
}
