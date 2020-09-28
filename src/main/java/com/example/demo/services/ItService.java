package com.example.demo.services;

import com.example.demo.entities.*;


public final class ItService {
    private final Staff webDeveloper;
    private final Staff webDesigner;
    private final Staff appDeveloper;

    public ItService(Staff webDeveloper, Staff webDesigner, Staff appDeveloper) {
        this.webDeveloper = webDeveloper;
        this.webDesigner = webDesigner;
        this.appDeveloper = appDeveloper;
    }

    public String fixSite(Customer customer){
        Problems problem = customer.getProblem();
        customer.setProblem(Problems.NoProblems);
        return this.webDeveloper.getPosition() + " " + this.webDeveloper.getFirstName() + " fixed bug: " + problem + ".";
    }

    public String fixInterface(Customer customer){
        Problems problem = customer.getProblem();
        customer.setProblem(Problems.NoProblems);
        return this.webDesigner.getPosition() + " " + this.webDesigner.getFirstName() + " fixed bug: " + problem + ".";

    }

    public String fixApp(Customer customer){
        Problems problem = customer.getProblem();
        customer.setProblem(Problems.NoProblems);
        return this.appDeveloper.getPosition() + " " + this.appDeveloper.getFirstName() + " fixed bug: " + problem + ".";

    }

    @Override
    public String toString(){
        return "There are Web-developer, Web-designer and App-developer in our IT service";
    }
}
