package teja.springframework.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teja.springframework.domain.Planet;
import teja.springframework.repositories.PlanetRepository;


@Service
public class PlanetServiceImpl implements PlanetService {
   
    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public List<Planet> listAll() {
        List<Planet> products = new ArrayList<>();
        planetRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

   }
