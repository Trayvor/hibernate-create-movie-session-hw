package mate.academy.service.impl;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import mate.academy.dao.MovieDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Movie;
import mate.academy.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).orElseThrow(
                () -> new EntityNotFoundException("No movie with id" + id + " found")
        );
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movies = movieDao.getAll();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("No movies found in database");
        }
        return movies;
    }
}
