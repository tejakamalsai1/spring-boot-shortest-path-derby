package teja.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import teja.springframework.domain.Route;
@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}
