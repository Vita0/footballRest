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

@Path("/team")
public class TeamResource {
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
    	ArrayList<League> al = new ArrayList<League>();
    	League l = new League();
    	l.league_id = 3;
    	l.name = "RRRR";
    	l.kind = "lol";
    	al.add(l);
    	League ll = new League();
    	ll.league_id = 12;
    	ll.name = "LLLL";
    	ll.kind = "olo";
    	al.add(ll);
    	LeagueList leagueList = new LeagueList(al);
    	return leagueList;
    }

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