import java.util.*;

class Movie {
    String title;
    String genre;
    public Movie(String title, String genre) { this.title = title; this.genre = genre; }
    @Override
    public String toString() { return title + " (" + genre + ")"; }
}

public class Q29_OnlineStreamingWatchHistory {

    public static void main(String[] args) {
        Stack<Movie> history = new Stack<>();
        List<Movie> allMovies = new ArrayList<>();
        Set<String> genresWatched = new HashSet<>();
        Queue<Movie> upNext = new LinkedList<>();

        Movie m1 = new Movie("Movie A", "Action");
        Movie m2 = new Movie("Movie B", "Drama");
        Movie m3 = new Movie("Movie C", "Action");

        allMovies.add(m1);
        allMovies.add(m2);
        allMovies.add(m3);

        upNext.add(m1);
        upNext.add(m2);

        while (!upNext.isEmpty()) {
            Movie current = upNext.remove();
            System.out.println("Watching: " + current);
            history.push(current);
            genresWatched.add(current.genre);
        }

        System.out.println("History stack: " + history);
        System.out.println("Unique genres watched: " + genresWatched);
    }
}
