package com.bridgelabz.cabinvoicegenerator;


import java.util.Objects;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final double averageFare;

    /**
     * initializing the variables
     *
     * @param numOfRides
     * @param totalFare
     */
    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / numOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfRides, totalFare, averageFare);
    }
}
