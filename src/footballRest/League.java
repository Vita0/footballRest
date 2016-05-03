package footballRest;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "league")
@XmlAccessorType(XmlAccessType.FIELD)
public class League {
    public int league_id;
    public String name;
    public String kind;
    
    League(){
        league_id = 0;
        name = "";
        kind = "";
    }
    
    public void setValue(String valType, String value){
        switch (valType){
            case "LEAGUE_ID":
                league_id = Integer.parseInt(value);
                break;
            case "NAME":
                name = value;
                break;
            case "KIND":
                kind = value;
                break;
            default:
                System.out.println("unknown column");
                break;
        }
    }
}