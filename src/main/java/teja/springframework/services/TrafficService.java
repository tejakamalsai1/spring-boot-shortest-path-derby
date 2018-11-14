package teja.springframework.services;

import java.util.List;

import teja.springframework.domain.Route;
import teja.springframework.domain.Traffic;
import teja.springframework.response.RouteRs;
import teja.springframework.response.TrafficRs;

public interface TrafficService {
List<Traffic> listAll();

	

	TrafficRs findMinimumCost(String source, String destination);
}
