import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    //コンポーネント
    JLabel gameLabel;

    ButtonPanel buttonPanel;
    MazePanel mazePanel;


    //コンストラクタ
    GamePanel() {
        //パネルサイズと貼り付け位置の設定は不要（Cardlayoutが勝手に画面サイズに合わせてくれる）
        this.setLayout(new BorderLayout());
        this.setBackground(Color.yellow);
        //その他の追加設定をここに追加

        mazePanel = new MazePanel();
        buttonPanel = new ButtonPanel();

        this.add(mazePanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.WEST);

//        mazePanel.prepareComponents();
//        buttonPanel.prepareComponents();

    }

    //コンストラクタが呼ばれたあと手動で呼び出す
    public void prepareComponents() {
        //以降コンポーネントに関する命令(以下は一例)
        //ラベル生成
        gameLabel = new JLabel();

//        mazePanel.prepareComponents();
//        buttonPanel.prepareComponents();

//        mazePanel = new MazePanel();
//        buttonPanel = new ButtonPanel();
//
//        this.add(mazePanel, BorderLayout.CENTER);
//        this.add(buttonPanel, BorderLayout.WEST);
        //ラベルに文字を記入
        gameLabel.setText("ゲーム画面");
        //位置とサイズを指定
        gameLabel.setBounds(100, 200, 100,30);
        //ラベルをこのパネルに貼る
        this.add(gameLabel);

        mazePanel.prepareComponents();
        buttonPanel.prepareComponents();


    }

}