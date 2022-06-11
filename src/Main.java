/**
 * This method is used for creating main window
 */
public class Main {
    static Menu mainWindow;
    static MazePanel mazePanel;
    static Game game = new Game();
    public static void main(String[] args) {
        //prepare menu
        mainWindow = new Menu(new SearchMazeData());
        mainWindow.prepareMenu();
        //create panels
        mainWindow.preparePanels();
        //create the panels fetures
        mainWindow.prepareComponents();
        mainWindow.add(new MazePanel());
        //make to display the generate maze page after open up this product
        mainWindow.setFrontScreenAndFocus(ScreenMode.GENERATE);
        mainWindow.setVisible(true);

        game.start();
    }
}
