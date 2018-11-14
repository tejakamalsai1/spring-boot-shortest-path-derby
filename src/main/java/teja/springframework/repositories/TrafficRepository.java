package teja.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import teja.springframework.domain.Traffic;

public interface  TrafficRepository extends CrudRepository<Traffic, Long> {

}
