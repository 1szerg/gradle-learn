package com.gmail.user0abc.park;

public class RideStatusService {
    public static void main(String[] args) {
        validateArgs(args);
        getRideStatus(args[0]);
    }

    private static String getRideStatus(String rideId) {
        List<Ride> rides = readStatuses(rideId);
        return rides.get(random.nextInt(rides.size())).getStatus();
    }

    private static List<Ride>  readStatuses(String rideId) {
        InputStream inputStream = RideStatusService.class.getResourceAsStream(rideId + ".txt");
        if(inputStream == null) {
            throw new IllegalArgumentException("Invalid rideId: " + rideId);
        }
        List<Ride> rides = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            rides.add(new Ride(line));
        }
        return rides;
    }

    private static void validateArgs(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Exactly one argument is required");
        }
    }
}
