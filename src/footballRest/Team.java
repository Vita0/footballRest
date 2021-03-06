package footballRest;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name = "Team")
@XmlSeeAlso({LeagueList.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {
    private String symbol;
    private Double price;
    private String currency;
    private String country;
    //private Players playerList;
    //@XmlElement(name = "player")
    private ArrayList<String> playerList;

    public Team() {
    }

    public Team(String symbol,Double price, String currency, String country) {
        this.symbol = symbol;
        this.price = price;
        this.currency = currency;
        this.country = country;
        this.playerList = new Players();
    }
    
//    public Players getPlayerList(){
//    	return playerList;
//    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
