package tddmicroexercises.leaderboard;

import org.junit.Assert;
import org.junit.Test;

public class RaceTest {

    @Test
    public void isShouldCalculateDriverPoints() {
        // setup
        Driver driver1 = new Driver("Nico Rosberg", "DE");
        Driver driver2 = new Driver("Lewis Hamilton", "UK");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");

        // act
        Race australianGrandPrixRace = new Race("Australian Grand Prix", driver1, driver2, driver3);

        // verify
        Assert.assertEquals(25, driver1.getPoints());
        Assert.assertEquals(18, driver2.getPoints());
        Assert.assertEquals(15, driver3.getPoints());
    }

}
