package tddmicroexercises.leaderboard;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaderboardTest {

    @Test
    public void itShouldSumThePoints() {
        // setup
        Driver driver1 = new Driver("Nico Rosberg", "DE");
        Driver driver2 = new Driver("Lewis Hamilton", "UK");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");

        Race race1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race race2 = new Race("Malaysian Grand Prix", driver3, driver2, driver1);
        Race race3 = new Race("Chinese Grand Prix", driver2, driver1, driver3);
        Leaderboard sampleLeaderboard1 = new Leaderboard(race1, race2, race3);

        // act
        Map<String, Integer> results = sampleLeaderboard1.driverResults();

        // verify
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void isShouldFindTheWinner() {
        // setup
        Driver driver1 = new Driver("Nico Rosberg", "DE");
        Driver driver2 = new Driver("Lewis Hamilton", "UK");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");

        Race race1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race race2 = new Race("Malaysian Grand Prix", driver3, driver2, driver1);
        Race race3 = new Race("Chinese Grand Prix", driver2, driver1, driver3);
        Leaderboard sampleLeaderboard1 = new Leaderboard(race1, race2, race3);
        // act
        List<String> result = sampleLeaderboard1.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        Driver driver1 = new Driver("Nico Rosberg", "DE");
        Driver driver2 = new Driver("Lewis Hamilton", "UK");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");

        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePointsSameNames() {
        // setup
        Driver driver1 = new Driver("Nassim Vuqerqur1", "ALG");
        Driver driver2 = new Driver("Nassim Vuqerqur2", "BIZ");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");

        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
