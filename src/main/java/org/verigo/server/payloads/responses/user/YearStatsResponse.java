package org.verigo.server.payloads.responses.user;

import java.util.Map;

public class YearStatsResponse {
    private Map<String, int[]> yearStats;


    public YearStatsResponse(Map<String, int[]> yearStats) {
        this.yearStats = yearStats;
    }


    public Map<String, int[]> getYearStats() {
        return yearStats;
    }

    public void setYearStats(Map<String, int[]> yearStats) {
        this.yearStats = yearStats;
    }
}
