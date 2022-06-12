import java.util.ArrayList;
import java.util.Random;

/**
 * Generates maze algorithm
 */
//迷路を生成するクラス、アニメーションのためにthreadを継承（thread.sleep）
public class MazeGenerator extends Thread {

    static int digX, digY;

    public void run() {
        //縦・横
        Map.terrain = new TerrainType[Map.y][Map.x];

        for(int y =0; y < Map.y; y++) {
            for(int x =0; x < Map.x; x++) {
                //迷路の中身を全てwallに
                Map.terrain[y][x] = TerrainType.WALL;

                //迷路の端をblockに置き換える
                Map.terrain[y][x] = TerrainType.WALL;

                //迷路の横が恥かどうかのboolean
                boolean bx = x == 0 || x == Map.x - 1;
                boolean by = y == 0 || y == Map.y - 1;

                if(bx || by) {
                    Map.terrain[y][x] = TerrainType.BLOCK;
                }
            }
        }

        Random rand = new Random();

        //穴掘り
        digX = 1;
        digY = 1;

        //スタート地点入力
        int startX = digX;
        int startY = digY;

        //掘ったところがPATHになる（掘ったところが白くなる）
        Map.terrain[digY][digX] = TerrainType.PATH;

        //掘った位置を格納するためのarray作成
        ArrayList<Integer> arrayX = new ArrayList<>();
        ArrayList<Integer> arrayY = new ArrayList<>();

        arrayX.add(digX);
        arrayY.add(digY);


        while(true) {
            while(isDiggable(digX, digY)) {
                boolean digged = false;
                //自分より一マス上はblock出ないこと、自分より二マス上がPATHでないことは掘って良い
                //下、左、右
                boolean d0 = Map.terrain[digY -1][digX] != TerrainType.BLOCK && Map.terrain[digY - 2][digX] != TerrainType.PATH;
                boolean d1 = Map.terrain[digY +1][digX] != TerrainType.BLOCK && Map.terrain[digY + 2][digX] != TerrainType.PATH;
                boolean d2 = Map.terrain[digY][digX -1] != TerrainType.BLOCK && Map.terrain[digY][digX - 2] != TerrainType.PATH;
                boolean d3 = Map.terrain[digY][digX +1] != TerrainType.BLOCK && Map.terrain[digY][digX + 2] != TerrainType.PATH;

                switch(rand.nextInt(4)) {
                    case 0:
                        if(d0) {
                            //ふたますずつ掘る
                            digged = true;
                            Map.terrain[digY - 1][digX] = TerrainType.PATH;
                            Map.terrain[digY - 2][digX] = TerrainType.PATH;
                            digY -= 2;
                        }
                        break;
                    case 1:
                        if(d1) {
                            digged = true;
                            Map.terrain[digY + 1][digX] = TerrainType.PATH;
                            Map.terrain[digY + 2][digX] = TerrainType.PATH;
                            digY += 2;
                        }
                        break;
                    case 2:
                        if(d2) {
                            digged = true;
                            Map.terrain[digY][digX - 1] = TerrainType.PATH;
                            Map.terrain[digY][digX - 2] = TerrainType.PATH;
                            digX -= 2;
                        }
                        break;
                    case 3:
                        if(d3) {
                            digged = true;
                            //ふたますずつ掘る
                            Map.terrain[digY][digX + 1] = TerrainType.PATH;
                            Map.terrain[digY][digX + 2] = TerrainType.PATH;
                            digX += 2;
                        }
                        break;
                }
                //スピードと調整（なくても良い）
                if(digged) {

                    //掘った箇所をarrayに追加する
                    arrayX.add(digX);
                    arrayY.add(digY);

                    System.out.println(arrayX);
                    System.out.println(arrayY);

                    Main.mainWindow.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            //行き止まりに当たったらひとマス戻ってやり直す
            arrayX.remove(arrayX.size() -1);
            arrayY.remove(arrayY.size() -1);

            digX = arrayX.get(arrayX.size() -1);
            digY = arrayY.get(arrayY.size() -1);

            if(digX == startX && digY == startY) {

                Main.mainWindow.repaint();
                break;
            }
        }
        System.out.println("end");
    }
    //一方向でも掘れるならtrueを返す→よって掘れるまでループが続く
    boolean isDiggable(int x, int y) {
        boolean d0 = Map.terrain[y - 1][x] != TerrainType.BLOCK && Map.terrain[y - 2][x] != TerrainType.PATH;
        boolean d1 = Map.terrain[y + 1][x] != TerrainType.BLOCK && Map.terrain[y + 2][x] != TerrainType.PATH;
        boolean d2 = Map.terrain[y][x - 1] != TerrainType.BLOCK && Map.terrain[y][x - 2] != TerrainType.PATH;
        boolean d3 = Map.terrain[y][x + 1] != TerrainType.BLOCK && Map.terrain[y][x + 2] != TerrainType.PATH;

        return d0 || d1 || d2 || d3;
    }
}
