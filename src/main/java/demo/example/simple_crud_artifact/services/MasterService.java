/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.example.simple_crud_artifact.services;

import demo.example.simple_crud_artifact.entities.Master;
import demo.example.simple_crud_artifact.interfaces.MasterInterfaces;
import demo.example.simple_crud_artifact.repositories.MasterRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author darma kusumandaru
 */
@Service
public class MasterService implements MasterInterfaces {

    @Autowired
    private MasterRepository masterRepo;
    
    @Override
    public void save(Master master) {
        this.masterRepo.save(master);
    }

    @Override
    public Iterable<Master> getMasterActive() {
        return masterRepo.getMasterActive();
    }

    @Override
    public Optional<Master> getMasterById(Integer id) {
        return masterRepo.findById(id);
    }
    
}
