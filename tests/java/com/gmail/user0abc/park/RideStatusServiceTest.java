package com.gmail.user0abc.park;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RideStatusServiceTest {

    @ParameterizedTest(name = "RideStatusService.getRideStatus({0})")
    @ValueSource(strings = {"pool", "rollercoaster", "teacups"})
    public void getRideStatus(String rideId) throws Exception {
        RideStatusService rideStatusService = new RideStatusService();
        String result = rideStatusService.getRideStatus(rideId);
        assertNotNull(result);
    }

    @Test
    public void getRideStatus() throws Exception {
        RideStatusService rideStatusService = new RideStatusService();
        assertThrows(
                IllegalArgumentException.class, () -> rideStatusService.getRideStatus("no_such_ride")
        );
    }
}
