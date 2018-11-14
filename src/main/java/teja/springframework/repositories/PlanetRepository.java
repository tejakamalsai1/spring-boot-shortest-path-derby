package teja.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import teja.springframework.domain.Planet;
@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

}
