import java.util.Scanner;

public class Main {
    static boolean gameRunning = false;
    public static void main(String[] args) {

        Menu menu = new Menu(gameRunning);
        Tiles tiles = new Tiles(menu);
        menu.giveTiles(tiles);
        Scanner scanner = new Scanner(System.in);
        char input;

        menu.reload();

        while (gameRunning){
            input = scanner.next().charAt(0);
            tiles.setData();
            tiles.move(input);
            tiles.print();

        }
    }
}