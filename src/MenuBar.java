import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuBar extends JFrame {

    //コンポーネント
    MenuBarListener menuBarListener;

    //コンストラクタ
    MenuBar() {

    }
    public void prepareComponents() {
        JMenuBar menubar = new JMenuBar();

        JMenu menu = new JMenu("File");


        menubar.add(menu);


        JMenuItem menuitem1 = new JMenuItem("New");
        JMenuItem menuitem2 = new JMenuItem("Open");
        JMenuItem menuitem3 = new JMenuItem("Exit");

        menuBarListener = new MenuBarListener();
        menuitem1.addActionListener(menuBarListener);


        menu.add(menuitem1);
        menu.add(menuitem2);
        menu.add(menuitem3);

        setJMenuBar(menubar);
    }


    private class MenuBarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
        }
    }

}
