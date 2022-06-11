import javax.swing.*;
import java.awt.*;

/**
 * This class is used for displaying generated maze puzzle
 */
public class MazePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    JLabel titleLabel;
    JPanel displayMaze;

    /**
     * This constructor is used to made up base of maze panel
     */
    MazePanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
//        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.yellow);
//        this.setLayout(null);
    }

    /**
     * This method is used to create detail design of generate maze page
     */
    public void prepareComponents() {

        int width = 600;
        int height = 600;

        titleLabel = new JLabel();
        titleLabel.setText("Maze will display here");
        titleLabel.setBounds(100,40,100,30);

        displayMaze = new JPanel();
        displayMaze.setPreferredSize(new Dimension(width, height));
        displayMaze.setBackground(Color.white);


        this.add(titleLabel);
        this.add(displayMaze);
    };

    public void paintComponent(Graphics g) {
        int width = 600;
        int height = 600;

//        titleLabel = new JLabel();
//        titleLabel.setText("Maze will display here");
//        titleLabel.setBounds(100,40,100,30);

        displayMaze = new JPanel();
        displayMaze.setPreferredSize(new Dimension(width, height));
        displayMaze.setBackground(Color.white);

        //セル一つ一つの大きさ
        int cellWidth = width / Map.x;
        int cellHeight = height / Map.y;

        for(int y = 0; y < Map.y; y++) {
            for (int x = 0; x < Map.x; x++) {

                //switch文で一つ一つの迷路の中身を判別する
                switch (Map.terrain[y][x]) {
                    //セルのタイプにより色を変える
                    case BLOCK:
                        g.setColor(Color.black);
                        break;
                    case WALL:
                        g.setColor(Color.gray);
                        break;
                    case PATH:
                        g.setColor(Color.white);
                        break;
                    case GOAL:
                        g.setColor(Color.blue);
                        break;
                }
                if (MazeGenerator.digX == x && MazeGenerator.digY == y) {
                    g.setColor(Color.red);
                }
                g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
            }
        }

//        this.add(titleLabel);
        this.add(displayMaze);
    }

}
