package spring.nikitasterlit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.nikitasterlit.model.LableCompany;
import spring.nikitasterlit.model.Manager;
import spring.nikitasterlit.repository.LableCompanyRepository;
import spring.nikitasterlit.repository.ManagerRepository;

import java.util.List;

@RestController
public class LableController {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    LableCompanyRepository lableCompanyRepository;

    @GetMapping("/lable")
    public List<LableCompany> getAllLable(){return lableCompanyRepository.findAll();}
    @GetMapping("/lable/{id}")
    public LableCompany getLableById(@PathVariable ("id")long id){return lableCompanyRepository.findById(id).get();}
    @PostMapping("/lable")
    public LableCompany addLable(@RequestBody LableCompany lableCompany){return lableCompanyRepository.save(lableCompany);}
    @PostMapping("/lable/manager/{managerid}")
    public Manager addLableByManagerId(@PathVariable ("managerid")long id,@RequestBody LableCompany lableCompany){
        Manager manager = managerRepository.findById(id).get();
        manager.setLableCompany(lableCompany);
        return managerRepository.save(manager);
    }
    @PutMapping("/lable/{id}")
    public LableCompany putLable(@PathVariable ("id")long id, @RequestBody LableCompany lableCompany){
        LableCompany lableCompany1 = lableCompanyRepository.findById(id).get();
        lableCompany1.setAgeCompany(lableCompany.getAgeCompany());
        lableCompany1.setCompany(lableCompany.getCompany());
        lableCompany1.setColors(lableCompany.getColors());
        return lableCompanyRepository.save(lableCompany);
    }
    @PutMapping("/lable/manager/{id}")
    public Manager putLableByManagerId(@PathVariable ("id")long id, @RequestBody LableCompany lableCompany){
        Manager manager = managerRepository.findById(id).get();
        LableCompany lableCompany1 = manager.getLableCompany();
        lableCompany1.setColors(lableCompany.getColors());
        lableCompany1.setCompany(lableCompany.getCompany());
        lableCompany1.setAgeCompany(lableCompany.getAgeCompany());
        manager.setLableCompany(lableCompany1);
        return managerRepository.save(manager);
    }

    @DeleteMapping("/lable/{id}")
    public String deleteLable(@PathVariable ("id")long id){
        lableCompanyRepository.deleteById(id);
        return "Lable has been delete";
    }
}
