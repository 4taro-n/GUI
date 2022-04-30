import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.xml.transform.ErrorListener;

//ゲーム画面上部に貼り付ける
public class ButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    //コンポーネント
    JLabel homeLabel;
    JButton homeButton;
    HomeButtonListener homeButtonListener;

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

    ErrorListener errorListener;




    //コンストラクタ
    public ButtonPanel() {
        //パネルサイズと貼り付け位置の設定は不要（Cardlayoutが勝手に画面サイズに合わせてくれる）
        this.setPreferredSize(new Dimension(200, 600));
        this.setBackground(Color.green);
        this.setLayout(null);
        //その他の追加設定をここに追加
    }

    //コンストラクタが呼ばれたあと手動で呼び出す
    public void prepareComponents() {
        //JSpinner
        //上限下限がなければnull
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
        spinnerColumn = new JSpinner(model);
        spinnerColumn.setBounds(80, 60, 100, 30);

        //column-label
        labelColumn = new JLabel("column");
        labelColumn.setBounds(30,60,100,30);

        //difficulity
        SpinnerNumberModel model02 = new SpinnerNumberModel(50, 0, 100, 1);
        spinnerDifficulity = new JSpinner(model02);
        spinnerDifficulity.setBounds(80, 330, 100, 30);

        labelDifficulity = new JLabel("Difficulity(0-100)");
        labelDifficulity.setBounds(10,330,100,30);

        //Author
        textFieldAuthor = new JTextField();
        textFieldAuthor.setBounds(80, 90, 100, 30);
        textFieldAuthor.setCaretColor(Color.BLUE);
        textFieldAuthor.setFont(new Font(null,Font.PLAIN,15));
        //デフォルトで文字を入れておく
        textFieldAuthor.setText("ex) 100");
        //textField.setEditable(false);

        //Author-label
        labelAuthor = new JLabel("Author name");
        labelAuthor.setBounds(5,90,100,30);

        //textFieldTitle
        textFieldTitle = new JTextField();
        textFieldTitle.setBounds(80, 120, 100, 30);
        textFieldTitle.setCaretColor(Color.BLUE);
        textFieldTitle.setFont(new Font(null,Font.PLAIN,15));
        //デフォルトで文字を入れておく
        textFieldTitle.setText("ex) 100");
        //textField.setEditable(false);

        //textFieldTitle-label
        labelTitle = new JLabel("Maze title");
        labelTitle.setBounds(10,120,100,30);

        //buttonStartImage
        //ボタンの生成
        buttonStartImage = new JButton("Select start image");
        buttonStartImage.setBounds(30,150,150,30);
//        myButtonListener = new MyButtonListener();

        //buttonGoalImage
        buttonGoalImage = new JButton("Select start image");
        buttonGoalImage.setBounds(30,180,150,30);

        //buttonLogoImage
        buttonLogoImage = new JButton("Select logo image");
        buttonLogoImage.setBounds(30,210,150,30);

        //buttonStart
        buttonStart = new JButton("Start");
        buttonStart.setBounds(30,240,100,30);

        //buttonSolution
        buttonSolution = new JButton("Solution");
        buttonSolution.setBounds(30,270,100,30);
        buttonSolution.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ErrorListener();
            }
        });

        //buttonSave
        buttonSave = new JButton("Save");
        buttonSave.setBounds(30,300,100,30);


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

    private class HomeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);
        }

    }

    private void ErrorListener() {
        JOptionPane.showMessageDialog(this, "This maze is not solvable!",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

}