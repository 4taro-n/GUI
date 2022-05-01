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
        titleLabel = new JLabel();
        titleLabel.setText("Maze will display here");
        titleLabel.setBounds(100,40,100,30);

        displayMaze = new JPanel();
        displayMaze.setPreferredSize(new Dimension(500, 500));
        displayMaze.setBackground(Color.white);

        this.add(titleLabel);
        this.add(displayMaze);
    };
}
