package teja.springframework.services;

import java.util.List;

import teja.springframework.domain.Route;
import teja.springframework.response.RouteRs;

public interface RouteService {

	List<Route> listAll();

	

	RouteRs findMinimumCost(String source, String destination);
}
