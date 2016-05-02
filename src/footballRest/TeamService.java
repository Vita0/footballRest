package footballRest;

import java.util.Map;
import java.util.HashMap;

public class TeamService {
    public static void add(Team team) {
    	teams.put(team.getSymbol(), team);
    }

    public static void removeStock(String symbol) {
    	teams.remove(symbol);
    }

    public static Team get(String symbol) {
        return teams.get(symbol);
    }

    private static Map<String, Team> teams = new HashMap<String, Team>();

    static {
        generateStocks();
    }

    private static void generateStocks() {
        add(new Team("IBM", 43.12, "USD", "US"));
        add(new Team("APPL", 320.0, "USD", "US"));
    }
}
