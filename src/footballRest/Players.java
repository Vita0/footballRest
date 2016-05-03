package footballRest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class Players extends ArrayList<String>{
	public Players(){
		this.add("Dzyuba");
		this.add("Shatov");
	}
	//@XmlElement(name = "player")
	public ArrayList<String> getPlayers(){
		return this;
	}
}
