import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * This is a class for retrieve data by using MazeDataSource for SearchMaze GUI functionality.
 *
 * @author Haotian Ouyang
 */
public class SearchMazeData {
    DefaultListModel listModel;

    MazeDataSource mazeData;

    /**
     * Initialised listModel and database.
     */
    public SearchMazeData(){
        listModel = new DefaultListModel();

        mazeData = new JDBCMazeDataSource();

        Update();

    }

    /**
     * For retrieve data from database to listModel
     */
    public void Update(){
        for (String mazeName: mazeData.mazeNameSet()){
               if(mazeName != null && mazeName != ""){
                listModel.addElement(mazeName);
               }
        }
    }

    /**
     * ADD maze to the database and listModel for showing.
     * @param m maze
     */
    public void add(Maze m){
        if(!listModel.contains(m.getMazeName())){
            listModel.addElement(m.getMazeName());
            mazeData.addMaze(m);
        }
    }

    /**
     * Remove maze from the database and listModel
     * @param k
     */
    public void remove(Object k){
        listModel.removeElement(k);
        mazeData.deleteMaze((String) k);
    }

    /**
     * Keep the data
     */
    public void persist(){ mazeData.close();}

    /**
     * retrieve maze from database
     * @param k input name with string
     * @return the Maze in the database by indicating the name
     */
    public Maze get(Object k){ return mazeData.getMaze((String) k);}

    /**
     * Get the listModel for showing data.
     * @return listModel
     */
    public ListModel getModel(){return listModel;}

    /**
     * find the size of the database
     * @return size of database
     */
    public int getSize(){ return mazeData.getSize();}
}
