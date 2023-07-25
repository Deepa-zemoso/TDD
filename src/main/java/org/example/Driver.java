package org.example;

import java.util.HashSet;
import java.util.Set;

public class Driver {
    private int[] routes;
    private Set<Integer> gossips=new HashSet<>();
    public Driver(int[] routes){
        this.routes=routes;
        for(int route:routes){
            gossips.add(route);
        }
    }
    public int getDriverStop(int minute) {
        int size = this.routes.length;
        return routes[minute < size ? minute : minute % size];
    }

    public Set<Integer> getGossips(){
        return  this.gossips;
    }


}
