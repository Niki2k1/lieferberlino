package de.oszimt.objects;

import de.oszimt.objects.logger.LogType;
import de.oszimt.objects.logger.Logger;

import java.sql.*;

public class SQLConnection {

    private Logger logger;
    private Connection conn;

    /**
     * Constructor from object.
     */
    public SQLConnection(String connString, Logger logger) {
        this.logger = logger;
        try {
            this.conn = DriverManager.getConnection(connString, "lieferberlino", "lieferberlino2020!");
            this.logger.log(LogType.INFO, "Connection to database was successfully opened.");
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.log(LogType.ERROR, "Can't connect to sql database.");
        }
    }
    /**
     * Execute sql query.
     */
    public Boolean execute(String query) {
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.log(LogType.ERROR, "Can't execute sql query: '" + query + "'.");
            return false;
        }
    }
    /**
     * Execute select query.
     */
    public ResultSet select(String query) {
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
            return rs;
        } catch (Exception e) {
            this.logger.log(LogType.ERROR, "Can't execute sql-select query: '" + query + "'.");
            return null;
        }
    }
    /**
     * Return connection.
     */
    public Connection getConnection() {
        return this.conn;
    }
}
