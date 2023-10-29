import java.util.Scanner;

public class Menu extends Main{
    boolean gameRunning;
    boolean firstPrint = false;
    Tiles tiles;

    public Menu(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
    public void giveTiles(Tiles tiles){
        this.tiles = tiles;
    }

    Scanner scanner = new Scanner(System.in);
char input;
    public void reload(){
        Main.gameRunning = false;
        System.out.println("░██████╗██╗░░░░░██╗██████╗░██╗███╗░░██╗░██████╗░  ████████╗██╗██╗░░░░░███████╗░██████╗");
        System.out.println("██╔════╝██║░░░░░██║██╔══██╗██║████╗░██║██╔════╝░  ╚══██╔══╝██║██║░░░░░██╔════╝██╔════╝");
        System.out.println("╚█████╗░██║░░░░░██║██║░░██║██║██╔██╗██║██║░░██╗░  ░░░██║░░░██║██║░░░░░█████╗░░╚█████╗░");
        System.out.println("░╚═══██╗██║░░░░░██║██║░░██║██║██║╚████║██║░░╚██╗  ░░░██║░░░██║██║░░░░░██╔══╝░░░╚═══██╗");
        System.out.println("██████╔╝███████╗██║██████╔╝██║██║░╚███║╚██████╔╝  ░░░██║░░░██║███████╗███████╗██████╔╝");
        System.out.println("╚═════╝░╚══════╝╚═╝╚═════╝░╚═╝╚═╝░░╚══╝░╚═════╝░  ░░░╚═╝░░░╚═╝╚══════╝╚══════╝╚═════╝░");
        System.out.println("                                            \uD83C\uDD51\uD83C\uDD68 \uD83C\uDD5A\uD83C\uDD5E\uD83C\uDD5B\uD83C\uDD58\uD83C\uDD5D");
        System.out.println();
        System.out.println("                                             \uD83C\uDD42 - Start");
        System.out.println("                                             \uD83C\uDD37 - Help");
        System.out.println("                                             \uD83C\uDD40 - Quit");

        input = scanner.next().charAt(0);

        if (input == 'S' || input == 's'){
            Main.gameRunning = true;
            tiles.load(0);
            if (!firstPrint){
                tiles.print();
                firstPrint = true;
            }
        }

        if (input == 'H' || input == 'h'){
            System.out.println("This is a game where you have to 'slide' tiles to organize them in a way in which they are ordered 1 - 15.");
            System.out.println("You are given a 4 x 4 grid, and one of the tiles are blank. ");
            System.out.println("Enter either W, A, S, or D and press Enter on your keyboard to slide the tiles surrounding the blank one.");
            System.out.println("Repeat until the tiles are ordered 1 - 15, left - right, top - bottom.");
            System.out.println("Here's a little tip: try to not see it as moving the blank box around, and instead that you are moving the tiles around the blank box. ");
            System.out.println("If you're still confused, here's the Wikipedia page!");
            System.out.println("https://en.wikipedia.org/wiki/Sliding_puzzle");
            System.out.println("\nPress any key to continue.");
            scanner.next();
            this.reload();
        }

        if (input == 'Q' || input == 'q'){
            Main.gameRunning = false;
        }
    }
}
