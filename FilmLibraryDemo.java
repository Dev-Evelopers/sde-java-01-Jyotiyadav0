import java.util.*;

interface IFilm {
    String getTitle();
    String getDirector();
    int getYear();
}

class Film implements IFilm {
    private String title;
    private String director;
    private int year;

    public Film(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getDirector() { return director; }

    @Override
    public int getYear() { return year; }

    @Override
    public String toString() {
        return title + " (" + year + ") by " + director;
    }
}

interface IFilmLibrary {
    void addFilm(IFilm film);
    void removeFilm(String title);
    List<IFilm> getFilms();
    List<IFilm> searchFilms(String query);
    int getTotalFilmCount();
}

class FilmLibrary implements IFilmLibrary {
    private List<IFilm> films = new ArrayList<>();

    @Override
    public void addFilm(IFilm film) { films.add(film); }

    @Override
    public void removeFilm(String title) {
        films.removeIf(f -> f.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public List<IFilm> getFilms() { return films; }

    @Override
    public List<IFilm> searchFilms(String query) {
        List<IFilm> result = new ArrayList<>();
        for (IFilm film : films) {
            if (film.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                film.getDirector().toLowerCase().contains(query.toLowerCase())) {
                result.add(film);
            }
        }
        return result;
    }

    @Override
    public int getTotalFilmCount() { return films.size(); }
}

public class FilmLibraryDemo {
    public static void main(String[] args) {
        FilmLibrary library = new FilmLibrary();

        Film f1 = new Film("HarryPotter", "DavidYates", 2007);
        Film f2 = new Film("TheLordOfTheRings", "PeterJackson", 2001);

        library.addFilm(f1);
        library.addFilm(f2);

        System.out.println("All Films: " + library.getFilms());

        System.out.println("Search Results: " + library.searchFilms("DavidYates"));

        library.removeFilm("TheLordOfTheRings");
        System.out.println("After Removal: " + library.getFilms());

        System.out.println("Total Films: " + library.getTotalFilmCount());
    }
}

