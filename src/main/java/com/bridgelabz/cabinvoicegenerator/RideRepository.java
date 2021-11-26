package com.bridgelabz.cabinvoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * creating class to add rides to user with the help of userId
 */
public class RideRepository {
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<String, ArrayList<Ride>>();
    }

    /**
     * method to add rides to the users
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRides.get(userId);
        if (rideList == null) {
            this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(rides)));
        }
    }

    /**
     * this method gives the number of Rides based on the userId
     *
     * @param userId
     * @return rides
     */
    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
