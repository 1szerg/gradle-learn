package com.gmail.user0abc.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RideStatusService {

    private static final Random random = new Random();

    public String getRideStatus(String rideId) {
        List<String> statuses = readStatuses(rideId);
        return statuses.get(random.nextInt(statuses.size()));
    }

    private static List<String>  readStatuses(String rideId) {
        InputStream inputStream = RideStatusService.class.getClassLoader().getResourceAsStream(rideId + ".txt");
        if(inputStream == null) {
            throw new IllegalArgumentException("Invalid rideId: " + rideId);
        }
        List<String> rides = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            rides.add(line);
        }
        return rides;
    }
}
