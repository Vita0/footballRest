package footballRest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

//@XmlRootElement(name = "LeagueList")
//@XmlSeeAlso({League.class})
//public class LeagueList extends ArrayList<League>{
//}

@XmlRootElement(name="LeagueList")
public class LeagueList {
	private int count;
	private ArrayList<League> leagueList;

	public LeagueList() {}
	
	public LeagueList(ArrayList<League> leagueList) {
		this.leagueList = leagueList;
		this.count = leagueList.size();
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="league")
	public ArrayList<League> getLeagueList() {
		return leagueList;
	}
//	public void setList(ArrayList<League> leagueList) {
//		this.leagueList = leagueList;
//		this.count = leagueList.size();
//	}
	
}