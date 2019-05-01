package spring.nikitasterlit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.nikitasterlit.controller.ActorController;
import spring.nikitasterlit.model.Actor;
import spring.nikitasterlit.repository.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;
}
