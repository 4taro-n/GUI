import java.util.Set;

public interface MazeDataSource {
    /**
     * Add maze information to database
     * @param m
     */
    void addMaze(Maze m);

    /**
     * retrieve maze information by passing string value indicating the maze name
     * @param mazeName
     * @return
     */
    Maze getMaze(String mazeName);

    /**
     * calculate the size of the database
     * @return
     */
    int getSize();

    /**
     * remove the information from database by indicating the name.
     * @param mazeName
     */
    void deleteMaze(String mazeName);

    /**
     * Finalizes any resources used by the data source and ensure data is persisted
     */
    void close();

    /**
     * Retrieves a set of maze details from the data source that used in maze list.
     * @return set of maze details
     */
    Set<String> mazeNameSet();



}
