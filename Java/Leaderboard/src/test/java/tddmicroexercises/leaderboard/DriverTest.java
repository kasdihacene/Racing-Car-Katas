package tddmicroexercises.leaderboard;

import org.junit.Test;

public class DriverTest {

    @Test
    public void testGetNameSelfCar() {
        Driver selfDirvingCar = new SelfDrivingCar("1.2.AZEBBI", "vincent");
        assert(selfDirvingCar.getName().equals("Self Driving Car - vincent (1.2.AZEBBI)"));
    }
    @Test
    public void testGetName404BACHINE() {
        Driver driver = new Driver("404", "NASSM AQERQOUR");
        assert(driver.getName().equals("404"));
    }
}