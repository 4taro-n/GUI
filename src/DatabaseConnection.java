import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * For database connection
 */
public class DatabaseConnection {
    private static Connection instance = null;

    private DatabaseConnection(){
        Properties props = new Properties();
        FileInputStream in = null;
        try{
            in = new FileInputStream("./db.props");
            props.load(in);
            in.close();

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            String schema = props.getProperty("jdbc.schema");

            instance = DriverManager.getConnection(url + "/" + schema, username,
                    password);
        }catch (SQLException sqle){
            System.err.println(sqle);
        }catch (FileNotFoundException fnfe) {
            System.err.println(fnfe);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * create a connection instance for manipulation on the database.
     * @return
     */
    public static Connection getInstance(){
        if (instance == null) {
            new DatabaseConnection();
        }
        return instance;
    }

}
