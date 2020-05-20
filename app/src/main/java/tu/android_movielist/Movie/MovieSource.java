package tu.android_movielist.Movie;

import java.util.ArrayList;
import java.util.Iterator;

public class MovieSource {
    static ArrayList<Movie> movies = new ArrayList<>();

    public static ArrayList<Movie>list() {
        return movies;
    }

    public static void delete(String name)
    {
        Iterator<Movie> itr = movies.iterator();
        while (itr.hasNext())
        {
            Movie movie = itr.next();
            if (movie.getName().equals(name)) {
                itr.remove();
            }
        }
    }

    public static boolean exists(String name)
    {
        int count=0;
        for(Movie movie:movies) {
            if(!movie.getName().equals(name)) count++;
        }
        return count == movies.size();
    }

    public static void add(Movie movie) {
        movies.add(movie);
    }
}
