package com.manager.server.api;

import com.manager.server.api.bean.Task;
import java.util.ArrayList;
import java.util.List;


public class StoryTasks {
    private static List<Task> tasks;
    public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		StoryTasks.tasks = tasks;
	}

	public StoryTasks() {
        initializeProductCatalog();
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