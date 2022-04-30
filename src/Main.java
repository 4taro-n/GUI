
//コーディング時に画面を簡単に切り替える方法
public class Main {
    static MainWindow mainWindow;
    public static void main(String[] args) {
        //ウインドウのみを生成
        mainWindow = new MainWindow();
        //menuを追加
        mainWindow.prepareMenu();
        //ペインに直接貼るパネルのみを生成
        mainWindow.preparePanels();
        //その他のコンポーネントを生成
        mainWindow.prepareComponents();
        //起動後最初に表示すべき画面を手前に持ってきてそれに注目させる
        mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
        //最後にウインド可視化
        mainWindow.setVisible(true);
    }
}
