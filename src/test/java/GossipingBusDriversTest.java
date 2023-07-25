import org.example.BusDrivers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GossipingBusDriversTest {
    @Test
    public void testDriverNeverGossips() {
        int[][] driverRoutes = {
                {2, 1, 2},
                {5, 2, 8}
        };
        int expectedOutput = -1;
        assertEquals(expectedOutput, BusDrivers.getStopsForSharingAllGossips(driverRoutes));
    }
    @Test
    public void testTwoDriversSameRoute() {
        int[][] driverRoutes = {
                {1, 2, 3},
                {1, 2, 3}
        };
        int expectedOutput = 3;
        assertEquals(expectedOutput, BusDrivers.getStopsForSharingAllGossips(driverRoutes));
    }
    @Test
    public void testMultipleDriversDifferentRoutes() {
        int[][] driverRoutes = {
                {3,1,2,3},
                {3,2,3,1},
                {4, 2,3,4,5},
        };
        int expectedOutput = 5;
        assertEquals(expectedOutput, BusDrivers.getStopsForSharingAllGossips(driverRoutes));
    }
}
