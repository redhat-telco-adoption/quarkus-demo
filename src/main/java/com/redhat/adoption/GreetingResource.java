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

    @ConfigProperty(name = "application.name", defaultValue = "Not Defined!")
    String appName;

    @ConfigProperty(name = "app.environment", defaultValue = "Not Defined")
    String appEnvironment;

    @ConfigProperty(name = "db.username", defaultValue = "Not Defined!")
    String dbUsername;
    @ConfigProperty(name = "db.password", defaultValue = "Not Defined!")
    String dbPassword;
    @ConfigProperty(name = "db.name", defaultValue = "Not Defined!")
    String dbName;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> hello() {

        Map<String, String> resp = new HashMap<>();

        resp.put("msg", "Quarkus Demo Application");
        resp.put("namespace", k8sNamespace);
        resp.put("app-name", appName);
        resp.put("app-environment", appEnvironment);
        resp.put("db-username", dbUsername);
        resp.put("db-password", dbPassword);
        resp.put("db-name", dbName);
        resp.put("extra-param", "extra");
        resp.put("greeeting", "Hello Everyone!");

        return resp;
    }
}
