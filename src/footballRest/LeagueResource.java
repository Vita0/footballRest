package footballRest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/league")
public class LeagueResource {
    @Produces({"application/xml", "application/json"})
	@Path("{symbol}")
    @GET
    public Team getStock(@PathParam("symbol") String symb) {

        Team team = TeamService.get(symb);

        if (team == null) {
            return new Team("NOT FOUND", 0.0, "--", "--");
        }

        return team;
    }
    
    @GET
    public LeagueList getLeagueList(){
        ConnectorDB db = new ConnectorDB();
        FieldList fl = new LeagueList();
        fl = db.selectFieldList("LEAGUE");
        LeagueList ll = new LeagueList(fl.getFieldList());
        db.free();
        return ll;
    }
    
    //@Path("/1")
    //@GET
//    public LeagueList getLeagueListTmp(){
//    	LeagueList lll = new LeagueList();
//    	//ArrayList<League> al = new ArrayList<League>();
//    	League l = new League();
//    	l.league_id = 3;
//    	l.name = "RRRR";
//    	l.kind = "lol";
//    	lll.add(l);
//    	League ll = new League();
//    	ll.league_id = 12;
//    	ll.name = "LLLL";
//    	ll.kind = "olo";
//    	lll.add(ll);
//    	return lll;
//    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response addStock(@FormParam("symbol") String symb,
                             @FormParam("currency") String currency,
                             @FormParam("price") String price,
                             @FormParam("country") String country) {

        if (TeamService.get(symb) != null)
            return Response.status(Response.Status.BAD_REQUEST).
                    entity("Stock " + symb +
                    " already exists").type("text/plain").build();

        double priceToUse;
        try {
            priceToUse = new Double(price);
        }
        catch (NumberFormatException e) {
            priceToUse = 0.0;
        }

        TeamService.add(new Team(symb, priceToUse, currency, country));

        return Response.ok().build();
    }
}