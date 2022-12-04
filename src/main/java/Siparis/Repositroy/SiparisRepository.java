package Siparis.Repositroy;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Siparis.Models.SiparisModel;

@Repository
public interface SiparisRepository extends MongoRepository<SiparisModel, String> {

}
