package footballRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Vita
 */
public class ConnectorDB {
    
    private Connection conn;
    
    ConnectorDB(){
        String dbFile = "E:/Program Files/Firebird/db/SPORT_IS.FDB";
        String dbURL = "jdbc:firebirdsql://localhost:3050/" + dbFile;
        String dbUser = "SYSDBA";
        String dbPassword = "masterkey";
        
        try {
        	// Инициализируемя Firebird JDBC driver.
            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        try {
            conn = null;
            //Создаём подключение к базе данных
            conn = DriverManager.getConnection(dbURL,dbUser, dbPassword);
            if (conn == null) {
                System.err.println("Could not connect to database");
                //System.exit(0);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    void free(){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    FieldList selectFieldList(String fieldType){
        
        FieldList fieldList;
        switch (fieldType){
            case "LEAGUE":
                fieldList = new LeagueList();
                break;
            case "SEASON":
                //fieldList = new SeasonList();
            	fieldList = null;
                break;
            default:
                fieldList = null;
                System.out.println("unknown filedType");
                break;
        }
        try{
            Statement stmt = conn.createStatement();
            String sqlQuery = "SELECT * FROM leagues";
            
            ResultSet res = stmt.executeQuery(sqlQuery);
            ResultSetMetaData md = res.getMetaData();
            
            while(res.next()){
                Field field;
                switch (fieldType){
                    case "LEAGUE":
                        field = new League();
                        break;
                    case "SEASON":
                        //field = new Season();
                    	field = null;
                        break;
                    default:
                        field = null;
                        System.out.println("unknown filedType");
                        break;
                }
                for (int col = 1; col <= md.getColumnCount(); col++) {
                    field.setValue(md.getColumnName(col), res.getString(col));
                }
                fieldList.add(field);
            }
            
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fieldList;
    }
}
