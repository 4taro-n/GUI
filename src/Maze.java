import java.io.Serial;
import java.io.Serializable;

/**
 * Stores variables that hold maze information
 */
public class Maze implements Comparable<Maze>, Serializable {

    @Serial
    private static final long serialVersionUID = 890514783655843673L;
    private String mazeName;

    private String author;

    private String dateCreated;

    private String dateEdited;

    private String mazeID;

    public Maze(){}

    /**
     * Constructor for set values for the Maze's details
     * @param mazeName
     * @param author
     * @param mazeID
     * @param dateCreated
     * @param dateEdited
     */
    public Maze(String mazeName, String author, String mazeID, String dateCreated, String dateEdited){
        this.mazeName = mazeName;
        this.author = author;
        this.mazeID = mazeID;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
    }

    /**
     * @return mazeName
     */
    public String getMazeName(){
        return mazeName;
    }

    /**
     * @param mazeName the name to set
     */
    public void setMazeName(String mazeName){
        this.mazeName = mazeName;
    }

    /**
     * @return author
     */
    public String getAuthor(){
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * @return date Created
     */
    public String getDateCreated(){
        return dateCreated;
    }

    /**
     * @param dateCreated to set
     */
    public void setDateCreated(String dateCreated){
        this.dateCreated = dateCreated;
    }

    /**
     * @return date Edited
     */
    public String getDateEdited(){
        return dateEdited;
    }

    /**
     * @param dateEdited to set
     */
    public void setDateEdited(String dateEdited){
        this.dateEdited = dateEdited;
    }

    /**
     * @return mazeId
     */
    public String getMazeID(){
        return mazeID;
    }

    /**
     * @param mazeID the MazeId to set
     */
    public void setMazeID(String mazeID){
        this.mazeID = mazeID;
    }

    /**
     * Compares this object with the specified object for order. Returns a
     * negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     * @param o The other maze object to compare against.
     * @return a negative integer, zero, or a positive integer as this object is
     *            less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Maze o) {
        return this.mazeName.compareTo(o.mazeName);
    }

    /**
     * set Maze to a string.
     * @return
     */
    public String toString(){
        return mazeName + " " + author + " " + mazeID + " " + dateCreated + " "+ dateEdited;
    }
}
