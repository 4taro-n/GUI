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
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class TitlePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    //コンポーネント
    JLabel titleLabel;

    JButton buttonAdd;
    JButton buttonSearch;
    JButton buttonSort;
    JList<Title> listMazeTitle;
    CustomListModel<Title> listModel;
    java.util.List<Title> mazeTitles  = new ArrayList<>();
    JScrollPane displayMazeTitle;

    JButton buttonExport;
    JButton buttonModify;

    ModifyMazewithData modifyMazewithData;

    //コンストラクタ
    TitlePanel() {
        //パネルサイズと貼り付け位置の設定は不要（CardLayoutが勝手に画面サイズに合わせてくれる）
        //レイアウトの設定
//        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        //背景の色
        this.setBackground(Color.red);
        //その他の追加設定をここに追加
    }

    //コンストラクタが呼ばれた後手動で呼び出す
    public void prepareComponents() {
        //以降コンポーネントに関する命令（以下は一例）
        //ラベル生成
//        titleLabel = new JLabel();
//        //ラベルに文字を記入
//        titleLabel.setText("タイトル画面");
//        //位置とサイズを指定
//        titleLabel.setBounds(100,0,100,30);
//        //ラベルをこのパネルに貼る
//        this.add(titleLabel);

//        setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));

        JPanel panelButton = new JPanel();
        panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonAdd = new JButton("All New Title");
        buttonAdd.setBounds(30,50,150,30);
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addMazeTitle();
            }
        });

        buttonSearch = new JButton("Search Persons");
        buttonSearch.setBounds(350,50,150, 30);
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchMazeTitle();
            }
        });

        buttonSort = new JButton("Sort Titles");
        buttonSort.setBounds(650,50,150, 30);
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortMazeTitle();
            }
        });

        listMazeTitle = new JList<>();
        mazeTitles = new ArrayList<>();

//        setLayout(new BorderLayout());
//        listMazeTitle  = new JList<>();
//        displayMazeTitle = new JScrollPane(listMazeTitle);
//        listMazeTitle.setLayoutOrientation(JList.VERTICAL);
//        displayMazeTitle.setBounds(30,30, 400, 400);


        listMazeTitle.setPreferredSize(new Dimension(400, 400));

        listModel = new CustomListModel<Title>(mazeTitles);
        listMazeTitle.setModel(listModel);

        listModel.addElement(new Title("Maze Title List"));

        buttonExport = new JButton("Export as JPEG");
        buttonExport.setBounds(50,600,150, 30);
        buttonExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortMazeTitle();
            }
        });

        buttonModify = new JButton("Modify Maze");
        buttonModify.setBounds(650,600,150, 30);
        modifyMazewithData = new ModifyMazewithData();
        buttonModify.addActionListener(modifyMazewithData);


        this.add(buttonAdd);
        this.add(buttonSearch);
        this.add(buttonSort);
        this.add(listMazeTitle);
//        this.add(displayMazeTitle);
        this.add(buttonExport);
        this.add(buttonModify);


    }

    private void addMazeTitle() {
        String mazeTitle = JOptionPane.showInputDialog(this, "Enter maze Title");
        if(mazeTitle != null) {
            listModel.addElement(new Title(mazeTitle));
        }
    }

    private void sortMazeTitle() {
        Collections.sort(mazeTitles);
        listModel.fireDateChanged();
    }

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

    private class ModifyMazewithData implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
        }

    }

}
