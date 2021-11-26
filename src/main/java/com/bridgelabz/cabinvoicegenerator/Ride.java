package com.bridgelabz.cabinvoicegenerator;

/**
 * Ride class has details for calculating particular ride
 */
public class Ride {
    public final int time;
    public final CabRide cabRide;
    public double distance;

    /**
     * constructor for initializing the variables
     *
     * @param time
     * @param cabRide
     * @param distance
     */
    public Ride(int time, CabRide cabRide, double distance) {
        this.time = time;
        this.cabRide = cabRide;
        this.distance = distance;
    }
}
