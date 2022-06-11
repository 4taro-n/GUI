public class Game {

    //generatorのインスタンス作成
    Thread generator;

    //ButtonPanel buttonPanel = new ButtonPanel();

    void start() {
        reset();
    }
    void update() {

    }
    void reset() {
        //ButtonPanel buttonPanel = new ButtonPanel();
        //マップのサイズ
        Map.x = ButtonPanel.row;
        Map.y = ButtonPanel.column;
        //Map.x = 5;
        //Map.y = 5;

        //System.out.println(ButtonPanel.row);

        generator = new MazeGenerator();
        //MazeGeneratorの中にあるpublic void run()が動く
        generator.start();
    }
}
