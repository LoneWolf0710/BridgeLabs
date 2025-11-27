import java.util.*;

class Player {
    String name;
    public Player(String name) { this.name = name; }
    @Override
    public String toString() { return name; }
}

class Match {
    String matchId;
    public Match(String id) { this.matchId = id; }
    @Override
    public String toString() { return matchId; }
}

class Result {
    String matchId;
    String winner;
    public Result(String matchId, String winner) { this.matchId = matchId; this.winner = winner; }
    @Override
    public String toString() { return "Result{" + matchId + ", winner=" + winner + "}"; }
}

class Score implements Comparable<Score> {
    String player;
    int points;
    public Score(String player, int points) { this.player = player; this.points = points; }
    @Override
    public int compareTo(Score o) { return Integer.compare(o.points, this.points); }
    @Override
    public String toString() { return player + " (" + points + ")"; }
}

public class Q21_OnlineGamingTournamentTracker {

    public static void main(String[] args) {
        Set<Player> players = new HashSet<>();
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));

        Queue<Match> matchQueue = new LinkedList<>();
        matchQueue.add(new Match("M1"));
        matchQueue.add(new Match("M2"));

        List<Result> results = new ArrayList<>();
        results.add(new Result("M1", "Alice"));
        results.add(new Result("M2", "Bob"));

        TreeSet<Score> leaderboard = new TreeSet<>();
        leaderboard.add(new Score("Alice", 10));
        leaderboard.add(new Score("Bob", 15));

        System.out.println("Registered players: " + players);
        System.out.println("Upcoming matches: " + matchQueue);
        System.out.println("Match results: " + results);
        System.out.println("Leaderboard (sorted by score): " + leaderboard);
    }
}
