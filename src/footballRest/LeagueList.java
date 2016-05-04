package footballRest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="LeagueList")
public class LeagueList implements FieldList{
	private int count;
	private ArrayList<Field> list;

	public LeagueList() {
        list = new ArrayList<Field>();
        count = 0;
	}
	
	public LeagueList(ArrayList<Field> leagueList) {
		this.list = leagueList;
		this.count = leagueList.size();
	}

	@Override
	@XmlElement(name="count")
	public int getCount() {
		return count;
	}
	@Override
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	@XmlElement(name="league")
	public ArrayList<Field> getFieldList() {
		return list;
	}
	@Override
	public void setList(ArrayList<Field> leagueList) {
		this.list = leagueList;
		this.count = leagueList.size();
	}
	@Override
	public void add(Field field){
        list.add(field);
        count = list.size();
	}
}