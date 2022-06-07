import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.xml.transform.ErrorListener;


/**
 * This class is made up operation board with button and spinner.
 * The panel is part of Generate maze panel.
 */
public class ButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    JSpinner spinnerRow;
    JSpinner spinnerColumn;
    JSpinner spinnerDifficulity;
    JTextField textFieldAuthor;
    JTextField textFieldTitle;
    JLabel labelRow;
    JLabel labelColumn;
    JLabel labelAuthor;
    JLabel labelTitle;
    JLabel labelDifficulity;

    JButton buttonStartImage;
    JButton buttonGoalImage;
    JButton buttonLogoImage;
    JButton buttonStart;
    JButton buttonSolution;
    JButton buttonSave;

    /**
     * This constructor is used to made up base of button panel
     */
    public ButtonPanel() {
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.gray);
        this.setLayout(null);
    }

    /**
     * This method is used to create detail design of generate maze page
     */
    public void prepareComponents() {
        //JSpinner
        SpinnerNumberModel model = new SpinnerNumberModel(31, 4, 100, 2);
        spinnerRow = new JSpinner(model);
        spinnerRow.setBounds(80, 30, 100, 30);
        //おまけ：直接編集を禁止する
//        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinnerRow, "#0");
//        spinnerRow.setEditor(editor);
//        JFormattedTextField ftext = editor.getTextField();
//        ftext.setEditable(false);

        labelRow = new JLabel("row");
        labelRow.setBounds(30,30,100,30);

        //column
        SpinnerNumberModel model03 = new SpinnerNumberModel(31, 4, 100, 2);
        spinnerColumn = new JSpinner(model03);
        spinnerColumn.setBounds(80, 60, 100, 30);

        //column-label
        labelColumn = new JLabel("column");
        labelColumn.setBounds(30,60,100,30);

        //difficulity
        SpinnerNumberModel model02 = new SpinnerNumberModel(50, 0, 100, 1);
        spinnerDifficulity = new JSpinner(model02);
        spinnerDifficulity.setBounds(30, 230, 100, 30);

        labelDifficulity = new JLabel("Difficulity(Lv0-Lv100)");
        labelDifficulity.setBounds(30,200,150,30);

        //Author
        textFieldAuthor = new JTextField();
        textFieldAuthor.setBounds(30, 290, 150, 30);
        textFieldAuthor.setCaretColor(Color.BLUE);
        textFieldAuthor.setFont(new Font(null,Font.PLAIN,15));
        //デフォルトで文字を入れておく
        textFieldAuthor.setText("ex) Name");
        //textField.setEditable(false);

        //Author-label
        labelAuthor = new JLabel("Author name");
        labelAuthor.setBounds(38,260,100,30);

        //textFieldTitle
        textFieldTitle = new JTextField();
        textFieldTitle.setBounds(30, 350, 150, 30);
        textFieldTitle.setCaretColor(Color.BLUE);
        textFieldTitle.setFont(new Font(null,Font.PLAIN,15));
        //デフォルトで文字を入れておく
        textFieldTitle.setText("ex) Maze title");
        //textField.setEditable(false);

        //textFieldTitle-label
        labelTitle = new JLabel("Maze title");
        labelTitle.setBounds(38,320,100,40);

        //buttonStartImage
        //ボタンの生成
        buttonStartImage = new JButton("Select start image");
        buttonStartImage.setBounds(30,100,150,30);
//        myButtonListener = new MyButtonListener();

        //buttonGoalImage
        buttonGoalImage = new JButton("Select goal image");
        buttonGoalImage.setBounds(30,130,150,30);

        //buttonLogoImage
        buttonLogoImage = new JButton("Select logo image");
        buttonLogoImage.setBounds(30,160,150,30);

        //buttonStart
        buttonStart = new JButton("Start");
        buttonStart.setBounds(30,400,100,40);
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //buttonSolution
        buttonSolution = new JButton("Solution");
        buttonSolution.setBounds(30,450,100,40);
        buttonSolution.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ErrorListener();
            }
        });

        //buttonSave
        buttonSave = new JButton("Save");
        buttonSave.setBounds(30,500,100,40);


        this.add(spinnerRow);
        this.add(labelRow);
        this.add(spinnerColumn);
        this.add(labelColumn);
        this.add(textFieldAuthor);
        this.add(labelAuthor);
        this.add(textFieldTitle);
        this.add(labelTitle);
        this.add(buttonStartImage);
        this.add(buttonGoalImage);
        this.add(buttonLogoImage);
        this.add(buttonStart);
        this.add(buttonSolution);
        this.add(buttonSave);
        this.add(spinnerDifficulity);
        this.add(labelDifficulity);


    }

//    private class HomeButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GENERATE);
//        }
//
//    }

    /**
     * This method is display error message in the case the maze is not solvable
     */
    private void ErrorListener() {
        JOptionPane.showMessageDialog(this, "This maze is not solvable!",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

}