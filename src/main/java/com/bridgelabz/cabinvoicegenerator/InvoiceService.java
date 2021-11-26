package com.bridgelabz.cabinvoicegenerator;

/**
 * To perform cabInvoice generator programming and calculating the fare
 */
public class InvoiceService {
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final double COST_PER_MIN = 1;
    private static final double MIN_FARE = 5.0;
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    /**
     * method to calculate total fare for particular ride
     *
     * @param distance
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MIN_FARE);
    }

    /**
     * method to calculate fare for multiple rides
     *
     * @param rides
     * @return total fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += ride.cabRide.calculateRideCost(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * method to add rides with respect to the userID
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
