package com.gmail.user0abc.park;

public class RideStatusApp {

    public static void main( String[] args ) {
        RideStatusService rideStatusrideStatusService = new RideStatusService();
        validateArgs(args);
        System.out.println( rideStatusrideStatusService.getRideStatus(args[0]) );
    }

    private static void validateArgs(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Exactly one argument is required");
        }
    }
}
