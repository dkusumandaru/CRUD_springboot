/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.example.simple_crud_artifact.interfaces;

import demo.example.simple_crud_artifact.entities.Master;
import java.util.Optional;

/**
 *
 * @author darma kusumandaru
 */
public interface MasterInterfaces {
    void save(Master master);
    Iterable<Master> getMasterActive();
    public Optional<Master> getMasterById(Integer id);
//    public String getMaxFaqQuestion();
}
