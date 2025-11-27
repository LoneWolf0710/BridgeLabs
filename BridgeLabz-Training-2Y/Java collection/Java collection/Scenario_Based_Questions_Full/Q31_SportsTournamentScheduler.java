import java.util.*;

class Team {
    String name;
    int points;
    public Team(String name, int points) { this.name = name; this.points = points; }
    @Override
    public String toString() { return name + " (" + points + ")"; }
}

class MatchPair {
    String description;
    public MatchPair(String description) { this.description = description; }
    @Override
    public String toString() { return description; }
}

class ResultRecord {
    String match;
    String winner;
    public ResultRecord(String match, String winner) { this.match = match; this.winner = winner; }
    @Override
    public String toString() { return match + " -> " + winner; }
}

public class Q31_SportsTournamentScheduler {

    public static void main(String[] args) {
        Set<Team> teams = new HashSet<>();
        teams.add(new Team("TeamA", 3));
        teams.add(new Team("TeamB", 6));

        Queue<MatchPair> matchQueue = new LinkedList<>();
        matchQueue.add(new MatchPair("TeamA vs TeamB"));

        List<ResultRecord> results = new ArrayList<>();
        results.add(new ResultRecord("TeamA vs TeamB", "TeamB"));

        TreeSet<Team> ranking = new TreeSet<>(Comparator.comparingInt(t -> -t.points));
        ranking.addAll(teams);

        System.out.println("Registered teams: " + teams);
        System.out.println("Match queue: " + matchQueue);
        System.out.println("Results: " + results);
        System.out.println("Leaderboard: " + ranking);
    }
}
