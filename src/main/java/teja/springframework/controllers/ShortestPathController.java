package teja.springframework.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import teja.springframework.domain.Planet;
import teja.springframework.domain.Route;
import teja.springframework.response.RouteRs;
import teja.springframework.services.PlanetService;
import teja.springframework.services.RouteService;
import tejaspringframework.commands.RouteForm;


@Controller
public class ShortestPathController {
	private PlanetService productService;

	@Autowired
	private RouteService routeService;
	
	@RequestMapping("/")
	public String redirToList(Model model) {
		 model.addAttribute("rootForm", new RouteForm());
	        return "routeform";
	}	
	
	@PostMapping("/route")
	public String minimumCost(@ModelAttribute RouteForm rootForm, Model model) {
		String source = rootForm.getSource();
		String destination = rootForm.getDestination();
		RouteRs rs = null;
		 rs= routeService.findMinimumCost(source, destination);
		 model.addAttribute("route",rs);
		 return "show";
		
	}

	private Set<Route> findAdjacenyNodes(Route r, List<Route> routes) {
		Set<Route> adjacentNodes = new HashSet<>();
		for (Route route : routes) {
			if (route.getDestination().equals(r.getDestination())) {
				adjacentNodes.add(route);
			} else {
				if (route.getOrigin().equals(r.getOrigin())) {
					adjacentNodes.add(route);
				}
			}
		}
		return adjacentNodes;
	}

	
	
}
