package spring.nikitasterlit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.nikitasterlit.repository.FilmRepository;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;
}
