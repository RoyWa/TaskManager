package com.pegaxchange.java.web.rest;
import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.pegaxchange.java.bean.Product;
import com.pegaxchange.java.bean.Status;
import com.pegaxchange.java.bean.Task;
@Path("storytasks")
public class StoryTasks {
    private static List<Task> tasks;
    public StoryTasks() {
        initializeProductCatalog();
    }
    

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Task[] searchByName(@QueryParam("name") String name) {
        List<Task> tasklist = new ArrayList<Task>();
        
        return tasks.toArray(new Task[tasklist.size()]);
    }
    
    private void initializeProductCatalog() {
        if (tasks == null) {
        	tasks = new ArrayList<Task>();
        	tasks.add(new Task("STSK0513526", "Cloud Events: 3. Profiling the performance of the Mid Selection"));
        	tasks.add(new Task("STSK0513408", "Cloud Events: 1. Profiling the performance of the REST API"));
        	tasks.add(new Task("STSK0513398", "Cloud Events: C. Expedite the performance of PatternLauncherManager"));
        }
    }
}