package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BusDrivers {
    public  static int getStopsForSharingAllGossips(int[][]routes){

        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] stops = routes[i];
            drivers.add(new Driver(stops));
        }

        boolean isGossip = false;
        Set<Integer> allDriversGossips = new HashSet<>();
        for (Driver driver : drivers) {
            allDriversGossips.addAll(driver.getGossips());
        }

        for (int time = 1; time <= 480; time++) {
            Set<Integer> gossipsAtStop = new HashSet<>();
            for (Driver driver : drivers) {
                int stop = driver.getDriverStop(time - 1);
                if (gossipsAtStop.add(stop)) {
                    allDriversGossips.add(stop);
                }
            }
            if (gossipsAtStop.size() == allDriversGossips.size()) {
                return time;
            }
            if (gossipsAtStop.size() < drivers.size()) {
                isGossip = true;
            }
        }
        if (allDriversGossips.size() == drivers.size()) {
            return drivers.size();
        }
        if (!isGossip) {
            return -1;
        }
        return allDriversGossips.size();
    }
}
