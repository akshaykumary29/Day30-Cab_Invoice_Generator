package com.bridgelabz.cabinvoicegenerator;

public enum CabRide {
    NORMAl(10.0, 1.0, 5.0);

    PREMIUM(15.0,2.0,20.0);

    private final double COST_PER_KM;
    private final double COST_PER_MIN;
    private final double MIN_FARE_PER_RIDE;

    /**
     * Initializing the variables in Contructor
     *
     * @param COST_PER_KM
     * @param COST_PER_MIN
     * @param MIN_FARE_PER_RIDE
     */
    CabRide(double COST_PER_KM, double COST_PER_MIN, double MIN_FARE_PER_RIDE) {
        this.COST_PER_KM = COST_PER_KM;
        this.COST_PER_MIN = COST_PER_MIN;
        this.MIN_FARE_PER_RIDE = MIN_FARE_PER_RIDE;
    }

    /**
     * Method to calculate ride fare.
     *
     * @param ride
     * @return ride cost
     */
    public double calculateRideCost(Ride ride) {
        double rideCost = ride.distance * COST_PER_KM + ride.time * COST_PER_MIN;
        return Math.max(rideCost, MIN_FARE_PER_RIDE);
    }
}
