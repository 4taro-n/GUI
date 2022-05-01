import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Collections;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

/**
 * This class is made up of database menu panel
 * */
public class SearchMazeMenu extends JPanel {
    private static final long serialVersionUID = 1L;

    JButton buttonAdd;
    JButton buttonSearch;
    JButton buttonSort;
    JList<Title> listMazeTitle;
    CustomListModel<Title> listModel;
    java.util.List<Title> mazeTitles  = new ArrayList<>();

    JButton buttonExport;
    JButton buttonModify;

    ModifyMazewithData modifyMazewithData;

    /**
     * This constructor is used to made up of base of database menu panel
     */
    SearchMazeMenu() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        this.setBackground(Color.gray);
    }

    /**
     * This method is used to create detail design of database page
     */
    public void prepareComponents() {
        //Button for open up the pane for adding new item to database
        buttonAdd = new JButton("Add New Maze Title");
        buttonAdd.setBounds(30,50,150,30);
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMazeTitle();
            }
        });

        //Button for open up the pane for searching item from database
        buttonSearch = new JButton("Search Maze Title");
        buttonSearch.setBounds(350,50,150, 30);
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchMazeTitle();
            }
        });

        //Button for sort the item in list below of the panel
        buttonSort = new JButton("Sort Titles");
        buttonSort.setBounds(650,50,150, 30);
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortMazeTitle();
            }
        });

        //List for displaying the list in the database
        listMazeTitle = new JList<>();
        mazeTitles = new ArrayList<>();
        listMazeTitle.setPreferredSize(new Dimension(400, 400));
        listModel = new CustomListModel<Title>(mazeTitles);
        listMazeTitle.setModel(listModel);

        //Add item in the database
        listModel.addElement(new Title("Maze Title List"));

        //Button for exporting image as JPEG(there is no features at this stage)
        buttonExport = new JButton("Export as JPEG");
        buttonExport.setBounds(50,600,150, 30);
        buttonExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortMazeTitle();
            }
        });

        //Button for modify maze with selected data(Just move to GenerateMaze panel at this stage)
        buttonModify = new JButton("Modify Maze");
        buttonModify.setBounds(650,600,150, 30);
        modifyMazewithData = new ModifyMazewithData();
        buttonModify.addActionListener(modifyMazewithData);

        //Add all features
        this.add(buttonAdd);
        this.add(buttonSearch);
        this.add(buttonSort);
        this.add(listMazeTitle);
        this.add(buttonExport);
        this.add(buttonModify);
    }

    /**
     * This methods is used to open a new pane and add item to database(just maze title list at this stage) by user input
     */
    private void addMazeTitle() {
        String mazeTitle = JOptionPane.showInputDialog(this, "Enter maze Title");
        if(mazeTitle != null) {
            listModel.addElement(new Title(mazeTitle));
        }
    }

    /**
     * This methods is used to open a new pane and sort the items displying by user input
     */
    private void sortMazeTitle() {
        Collections.sort(mazeTitles);
        listModel.fireDateChanged();
    }

    /**
     * This methods is used to open a new pane and search and dispplay the item by user input
     */
    private void searchMazeTitle() {
        String mazeTitle = JOptionPane.showInputDialog(this, "Enter person name to search for:");

        if(mazeTitle == null) {
            return;
        }
        Collections.sort(mazeTitles);

        int foundIndex = Collections.binarySearch(mazeTitles, new Title(mazeTitle));

        if(foundIndex >= 0) {
            listMazeTitle.setSelectedIndex(foundIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Could not find the maze title" + mazeTitle);
        }
    }

    /**
     * This method is used to transition to generate Maze page with user selected data(just trsnsition to generation panel at this stage)
     */
    private class ModifyMazewithData implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GENERATE);
        }

    }

}
