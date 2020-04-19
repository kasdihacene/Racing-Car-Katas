package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer[] POINTS = new Integer[]{25, 18, 15};

    private final String name;
    private List<Driver> rankings;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.rankings = Arrays.asList(drivers);
        attributePointsByRanking();
    }

    private void attributePointsByRanking() {
        for (int index = 0; index < rankings.size(); index++) {
            Driver driver = rankings.get(index);
            driver.accumulatePoints(calculatePointsByRanking(index));
        }
    }

    public int calculatePointsByRanking(int index) {
        return Race.POINTS[index];
    }

    public List<Driver> getRankings() {
        return rankings;
    }

    @Override
    public String toString() {
        return name;
    }

    void calculateResultRace(Map<String, Integer> results) {
        for (Driver driver : getRankings()) {
            results.put(driver.getName(), driver.getPoints());
        }
    }
}
