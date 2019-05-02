package spring.nikitasterlit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.nikitasterlit.model.Actor;
import spring.nikitasterlit.model.Manager;
import spring.nikitasterlit.repository.ActorRepository;
import spring.nikitasterlit.repository.ManagerRepository;

import javax.print.attribute.standard.Finishings;
import java.util.List;
import java.util.Set;

@RestController
public class ManagerController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    ManagerRepository managerRepository;

    @GetMapping("/manager")
    public List<Manager> getAllManager(){return managerRepository.findAll();}
    @PostMapping("/manager")
    public Manager addManager(@RequestBody Manager manager){return managerRepository.save(manager);}
    @PostMapping("/manager/actor/{actorid}")
    public Actor addManagerByActor(@RequestBody Manager manager, @PathVariable("actorid")long id){
        Actor actor = actorRepository.findById(id).get();
        actor.setManager(manager);
        return actorRepository.save(actor);
    }
    @PostMapping("/manager/{managerid}/actor/{actorid}")
    public Actor addManagerByIdInActorById(@PathVariable ("managerid")long managerid,
                                           @PathVariable ("actorid")long actorid){
        Manager manager = managerRepository.findById(managerid).get();
        Actor actor = actorRepository.findById(actorid).get();
        actor.setManager(manager);
        return actorRepository.save(actor);
    }
    @PutMapping("/manager/{id}")
    public Manager putManager(@PathVariable ("id")long id, @RequestBody Manager manager){
        Manager manager1 = managerRepository.findById(id).get();
        manager1.setNickname(manager.getNickname());
        manager1.setStatus(manager.getStatus());
        manager1.setTelephoneNumber(manager.getTelephoneNumber());
        return managerRepository.save(manager1);
    }
    @DeleteMapping("/manager/{id}")
    public String deleteManager(@PathVariable("id")long id){
        managerRepository.deleteById(id);
        return "manager has been delete";
    }
}
