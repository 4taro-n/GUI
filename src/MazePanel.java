import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;

public class MazePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    //コンポーネント
    JLabel titleLabel;

    //コンストラクタ
    MazePanel() {
        //パネルサイズと貼り付け位置の設定は不要（CardLayoutが勝手に画面サイズに合わせてくれる）
        //レイアウトの設定
        //その他の追加設定をここに追加
        this.setPreferredSize(new Dimension(600, 600));
        //背景の色
        this.setBackground(Color.white);
        this.setLayout(null);
    }

    //コンストラクタが呼ばれた後手動で呼び出す
    public void prepareComponents() {
        //以降コンポーネントに関する命令（以下は一例）
        //ラベル生成
        titleLabel = new JLabel();
        //ラベルに文字を記入
        titleLabel.setText("Maze");
        //位置とサイズを指定
        titleLabel.setBounds(100,40,100,30);
        //ラベルをこのパネルに貼る
        this.add(titleLabel);

    };

}
