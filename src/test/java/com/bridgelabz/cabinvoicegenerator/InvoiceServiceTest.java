package com.bridgelabz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    //    @Test
//    public void givenDistanceAndTime_ShouldReturnTotalFare() {
//        InvoiceService invoiceService = new InvoiceService();
//        double distance = 2.0;
//        int time = 5;
//        double totalFare = invoiceService.CalculateFare(distance, time);
//        Assert.assertEquals(25, totalFare, 0);
//    }
//
//    @Test
//    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
//        InvoiceService invoiceService = new InvoiceService();
//        double distance = 0.1;
//        int time = 1;
//        double totalFare = invoiceService.CalculateFare(distance, time);
//        Assert.assertEquals(5.0, totalFare, 0);
//    }


    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double minFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25,minFare);
    }

    @Test
    public void givenMultipleRidesAndTime_WhenCalculated_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
        };
        InvoiceSummary actualSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoice = new InvoiceSummary(2, 45.0);
        Assert.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    public void giveUserIDAndRideList_ShouldReturnInvoiceSummary() {
        String userId = "akshay2021";
        Ride[] rides = {new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummeryForPremium() {
        String userId = "akshay2021";
        Ride[] rides = new Ride[]{new Ride(CabRide.PREMIUM, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1),
                new Ride(CabRide.PREMIUM, 2.0, 5)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 100.0);
        Assert.assertEquals(expectedInvoice, actualSummary);
    }

    @Test
    void givenUserIDAndRideList_ShouldReturnInvoiceSummeryForNormal() {
        String userId = "akshay2021";
        Ride[] rides = new Ride[]{new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.NORMAL, 0.1, 1),
                new Ride(CabRide.NORMAL, 2.0, 5)
        };
        invoiceService.addRides(userId, rides);
        InvoiceSummary actualSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoice = new InvoiceSummary(3, 55.0);
        Assert.assertEquals(expectedInvoice, actualSummary);
    }
}
