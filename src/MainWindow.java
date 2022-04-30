import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    //フィールド
    ScreenMode screenMode = ScreenMode.TITLE;

    //定数
    //フレームの幅
    final int WIDTH = 800;
    //フレームの高さ
    final int HEIGHT = 600;

    //レイアウト（紙芝居のような設定用）
    CardLayout layout = new CardLayout();

    //コンポーネント
    TitlePanel titlePanel;
    GamePanel gamePanel;

//    MazePanel mazePanel;
//    ButtonPanel buttonPanel;

    MenuBarToGenearateListener menuBarToGenearateListener;
    MenuBarToSearchListener menuBarToSearchListener;

    //コンストラクタ
    MainWindow() {
        //ウインド左下のアイコンとタイトル
        this.setTitle("");

        //いつもの
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //画面サイズの変更を禁止
        this.setResizable(false);
        //背景の色
        this.getContentPane().setBackground(Color.green);
        //細かく設定する場合はこちら
        //this.getContentPane().setBackground(new Color(0xF6F6F6));
        //紙芝居のように設定
        this.setLayout(layout);
        //サイズ設定
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        //自動サイズ設定（これがないと変なサイズになる）
        this.pack();
        //起動時のスクリーンの位置を中央に（packより後で呼ぶ）
        this.setLocationRelativeTo(null);
        //細かく設定する場合はこちら
        //this.setLocation(450, 50);

//        JMenuBar menubar = new JMenuBar();
//
//        JMenu menu1 = new JMenu("File");
//
//
//        menubar.add(menu1);
//
//
//        JMenuItem menuitem1_1 = new JMenuItem("New");
//        JMenuItem menuitem1_2 = new JMenuItem("Open");
//        JMenuItem menuitem1_3 = new JMenuItem("Exit");
//
//
//        menu1.add(menuitem1_1);
//        menu1.add(menuitem1_2);
//        menu1.add(menuitem1_3);
//
//        setJMenuBar(menubar);
    }
    public void prepareMenu() {
        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("Menu");


        menubar.add(menu);


        JMenuItem menuitem1 = new JMenuItem("Generate Maze");
        JMenuItem menuitem2 = new JMenuItem("Search Maze");
        JMenuItem menuitem3 = new JMenuItem("Exit");

        menuBarToGenearateListener = new MenuBarToGenearateListener();
        menuitem1.addActionListener(menuBarToGenearateListener);

        menuBarToSearchListener = new MenuBarToSearchListener();
        menuitem2.addActionListener(menuBarToSearchListener);

        menu.add(menuitem1);
        menu.add(menuitem2);
        menu.add(menuitem3);

        setJMenuBar(menubar);
    }
    private class MenuBarToGenearateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
        }
    }
    private class MenuBarToSearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { Main.mainWindow.setFrontScreenAndFocus(ScreenMode.TITLE);}
    }

    //メソッド
    //コンストラクタが呼ばれた後メインメソッドから最初に手動で呼び出す
    public void preparePanels() {
        //パネルの準備
        gamePanel = new GamePanel();
        this.add(gamePanel, "ゲーム画面");
        titlePanel = new TitlePanel();
        this.add(titlePanel, "タイトル画面");




        this.pack();
    };

    //preparepanels()が呼ばれた後メインメソッドからさらに手動で動かす
    public void prepareComponents() {
        titlePanel.prepareComponents();
        gamePanel.prepareComponents();


    }

    //スクリーンモードを切り替える
    //メインメソッドから最後に手動で呼び出す
    public void setFrontScreenAndFocus(ScreenMode s) {
        screenMode = s;

        //表示される画面の設定
        switch(screenMode) {
            case TITLE:
                layout.show(this.getContentPane(), "タイトル画面");
                titlePanel.requestFocus();
                break;
            case GAME:
                layout.show(this.getContentPane(),"ゲーム画面");
                gamePanel.requestFocus();
                break;
        }
    }
}
