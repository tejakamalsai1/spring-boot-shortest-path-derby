package teja.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planet")
public class Planet {
	@Id
	@GeneratedValue
	private Long id;
	private String planetNode;
	private String planetName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlanetNode() {
		return planetNode;
	}
	public void setPlanetNode(String planetNode) {
		this.planetNode = planetNode;
	}
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	

}
