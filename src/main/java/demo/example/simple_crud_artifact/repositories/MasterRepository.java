/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.example.simple_crud_artifact.repositories;

import demo.example.simple_crud_artifact.entities.Master;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author darma kusumandaru
 */
@Repository
public interface MasterRepository extends CrudRepository<Master, Integer> {
    @Query(value = "SELECT * FROM master WHERE master.deleted = 0", nativeQuery = true)
    public Iterable<Master> getMasterActive();   
}
