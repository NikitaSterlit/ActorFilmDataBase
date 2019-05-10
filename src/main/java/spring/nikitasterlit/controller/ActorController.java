package spring.nikitasterlit.controller;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.nikitasterlit.model.Actor;
import spring.nikitasterlit.model.Film;
import spring.nikitasterlit.repository.ActorRepository;
import spring.nikitasterlit.repository.FilmRepository;

import java.util.List;
import java.util.Set;

@CrossOrigin(maxAge = 3600)
@RestController
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/actor")
    public List<Actor> getAllActors(){return actorRepository.findAll();}

    @GetMapping("/actor/{id}")
    public Actor getById(@PathVariable ("id")long id){return actorRepository.findById(id).get();}

    @GetMapping("/actor/{filmdid}")
    public Set<Actor> getListByFilmId(@PathVariable ("filmid")long id){
        Film film = filmRepository.findById(id).get();
        Set<Actor> actorSet = film.getActors();
        return actorSet;
    }
    @PostMapping("/actor/{actorid/film/{filmid}")
    public Film addActorByIdinFilmById(@PathVariable("actorid")long actorid, @PathVariable("filmid")long filmid){
        Actor actor = actorRepository.findById(actorid).get();
        Film film = filmRepository.findById(filmid).get();
        Set<Film> filmSet = actor.getFilms();
        filmSet.add(film);
        return filmRepository.save(film); //TODO
    }
    @PostMapping("/actor")
    public Actor post(@RequestBody Actor actor){ return actorRepository.save(actor);}
    @PutMapping("/actor/{actorid}")
    public Actor elitActor(@PathVariable("actorid")long id, @RequestBody Actor actor){
        Actor actor1 = actorRepository.findById(id).get();
        actor1.setFirstName(actor.getFirstName());
        actor1.setLastName(actor.getLastName());
        actor1.setGenre(actor.getGenre());
        return actorRepository.save(actor1);
    }
    @DeleteMapping("/actor/{id}")
    public String deletePost(@PathVariable("id")long id){
        actorRepository.deleteById(id);
        return "actor delete";
    }
    @DeleteMapping("/acttor/{filmid}")
    public void deleteAllByFilmId(@PathVariable("filmid")long id){
        Film film = filmRepository.findById(id).get();
        Set<Actor> setActor = film.getActors();
        setActor.clear();
        //return "Список актоеров был удален";
    }

}
