package seedu.address.api;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.config.TmdbConfiguration;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.keywords.Keyword;
import info.movito.themoviedbapi.model.people.PersonCast;

import javax.imageio.ImageIO;

import info.movito.themoviedbapi.model.tv.TvSeries;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import seedu.address.model.show.Date;
import seedu.address.model.show.Description;
import seedu.address.model.show.Movie;
import seedu.address.model.show.Name;
import seedu.address.model.show.RunningTime;
import seedu.address.model.show.TvShow;

/**
 * Main class for the API to connect to the server
 */
public class ApiMain {
    //API key is to connect with the tmdb server.
    private final static String API_KEY = "44ed1d7975d7c699743229199b1fc26e";
    private final TmdbApi ApiCall;

    public ApiMain() {
        ApiCall = new TmdbApi(API_KEY);
    }

    public List<Movie> getMovieByName(String name) {
        MovieResultsPage page = ApiCall.getSearch().searchMovie(name, null, null, true, null);
        ArrayList<Movie> movies = new ArrayList<>();
        for (MovieDb m : page.getResults()) {
            movies.add(new Movie(new Name(m.getTitle()), new Description(m.getTagline()), false, new Date(m.getReleaseDate()),
                    new RunningTime(m.getRuntime()), null));
        }
        return movies;
    }

    public List<TvShow> getTvShowByName(String name) {
        TvResultsPage page = ApiCall.getSearch().searchTv(name, null, null);
        ArrayList<TvShow> tvShows = new ArrayList<>();
        for (TvSeries tv : page.getResults()) {
            tvShows.add(new TvShow(new Name(tv.getName()), new Description(tv.getOverview()), false,
                    new Date(tv.getFirstAirDate()),
                    new RunningTime(tv.getEpisodeRuntime().get(0)), null, 0,
                    tv.getNumberOfEpisodes(), null));
        }
        return tvShows;
    }

    /**
     * test function
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        TmdbApi tmdbApi = new TmdbApi(API_KEY);
        TmdbMovies movies = tmdbApi.getMovies();
        MovieDb movie = movies.getMovie(5353, null, TmdbMovies.MovieMethod.similar, TmdbMovies.MovieMethod.keywords, TmdbMovies.MovieMethod.credits, TmdbMovies.MovieMethod.images);
        System.out.println(movie.getOriginalTitle());
        p2( movie.getSimilarMovies());
        List<Artwork> artworks = movie.getImages();
        String filePath = artworks.get(0).getFilePath();
        TmdbConfiguration configuration = tmdbApi.getConfiguration();
        final String baseUrl = configuration.getBaseUrl() + "w500";
        BufferedImage img = ImageIO.read(new URL(baseUrl + filePath));
        Graphics g = img.getGraphics();
        g.drawImage(img, 0, 0, null);

        //keywords
        List<Keyword> keywordList = movie.getKeywords();
        p(keywordList);
        List<Genre> genres = movie.getGenres();
        System.out.println("genres");
        p(genres);
        System.out.println("casts");
        List<PersonCast> cast = movie.getCast();
        p(cast);
        System.out.println("crew");
        p(movie.getCrew());
    }

    public static <T> void p (List<T> s) {
        for (T t : s)
            System.out.println(t);
    }

    public static void p2 (List<MovieDb> l) {
        for (MovieDb m : l) {
            System.out.println(m.getOriginalTitle());
        }
    }
}