package teja.springframework.services;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import teja.springframework.domain.Route;
import teja.springframework.domain.Traffic;
import teja.springframework.response.RouteRs;
import teja.springframework.response.TrafficRs;

public class TrafficServiceImpl implements TrafficService{

	@Override
	public List<Traffic> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrafficRs findMinimumCost(String source, String destination) {
		List<Traffic> routes = listAll();
		Set<Traffic> adjacentNodes = new HashSet<>();
		
		Traffic r = null;
		double cost = 0.0;
		StringBuffer buffer = new StringBuffer();

		adjacentNodes = findAdacentNodes(source, routes);
		r = adjacentNodes.stream().filter(p -> p.getDestination().equals(destination)).findAny().orElse(null);

		if (null == r) {
			r = findMinimumCost(adjacentNodes);
			cost = cost + r.getDistance();
			buffer.append(r.getOrigin() + "->");
			if (r.getDestination().equals(destination)) {

				cost = r.getDistance();
			} else {
				while (adjacentNodes.size() != 0) {
					adjacentNodes = findAdacentNodes(r.getDestination(), routes);
					Traffic s = adjacentNodes.stream().filter(p -> p.getDestination().equals(destination)).findAny()
							.orElse(null);
					if (null == s) {
						buffer.append(r.getDestination() + "->");
						if (adjacentNodes.size() != 0) {
							r = findMinimumCost(adjacentNodes);
							cost = cost + r.getDistance();
							buffer.append(r.getDestination() + "->");
							if (r.getDestination().equals(destination)) {
								break;
							}

						}
					} else {
						r = findMinimumCost(adjacentNodes);
						cost = cost + r.getDistance();
						break;
					}

				}
			}
		} else {
			cost = r.getDistance();
			buffer.append(r.getOrigin() + "->");
		}

		System.out.println(buffer.toString());
		TrafficRs rs = new TrafficRs();
		rs.setSource(source);
		rs.setDestination(destination);
		rs.setPath(buffer.toString());
		rs.setTotalCost(cost);
		
		return rs;
	}
	private Traffic findMinimumCost(Set<Traffic> adjacentNodes) {
		return adjacentNodes.stream().min(Comparator.comparing(Traffic::getDistance))
				.orElseThrow(NoSuchElementException::new);
	}

	private Set<Traffic> findAdacentNodes(String source, List<Traffic> routes) {
		Set<Traffic> adjacentNodes = new HashSet<>();
		for (Traffic route : routes) {
			if (route.getOrigin().equals(source)) {
				adjacentNodes.add(route);
			}
		}
		return adjacentNodes;
	}

}
