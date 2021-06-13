/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.example.simple_crud_artifact.controllers;

import demo.example.simple_crud_artifact.entities.Master;
import demo.example.simple_crud_artifact.services.MasterService;
import java.util.Optional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author darma kusumandaru
 */
@Controller
@RequestMapping
public class MasterController {
    @Autowired
    private MasterService masterService;
    
    @GetMapping("/master")
    public String getConsultattionStatus(Model model) {
        Iterable<Master> master = masterService.getMasterActive();
        model.addAttribute("masters", master);

        Master masterCrud = new Master();

//        model.addAttribute("masterAdd", masterCrud);        
//        model.addAttribute("masterEdit", masterCrud);
        model.addAttribute("masterRemove", masterCrud);

        return "master/v_page.html";
    }
    
    @GetMapping("/master/add")
    public String masterAdd(
            Model model
    ) 
    {
//        Iterable<Master> master = masterService.getMasterActive();
//        model.addAttribute("masters", master);
//        
        Master masterCrud = new Master();

        model.addAttribute("masterAdd", masterCrud);  
        return "master/v_page_add.html";
    }

    @GetMapping("/master/edit/{id}")
    public String masterEdit(
            Model model,
            @PathVariable Integer id
    ) 
    {
        Optional<Master> master = masterService.getMasterById(id);
        model.addAttribute("masterEdit", master);
        return "master/v_page_edit.html";
    }
    
    
    @PostMapping("/master/insert")
    public String masterInsert(
            @ModelAttribute("masterAdd") Master master
    ) 
    {
        this.masterService.save(master);
        return "redirect:/master";
    }
    
    @PostMapping(value = "/master/update")
    public String masterUpdate(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "deleted", required = false) Boolean deleted
    ) {
        Master master = new Master(id, name, deleted);
        master.setId(id);
        master.setName(name);
        master.setDeleted(deleted);

        this.masterService.save(master);
        return "redirect:/master";
        
    }
    
    @GetMapping(value = "/master/remove/{masterId}")
    public String masterRemove(
            @PathVariable Integer masterId
    ) {
        Optional<Master> masters = masterService.getMasterById(masterId);
        Integer id = masters.get().getId();
        String name = masters.get().getName();
        Boolean deleted = true;
        
        Master master = new Master(masterId, name, deleted);
        master.setId(id);
        master.setName(name);
        master.setDeleted(deleted);

        this.masterService.save(master);
        return "redirect:/master";
        
    }
    
}
