import java.util.Random;

public class Tiles {
    int[][] tiles = new int[4][4];
    int[][] data = new int[5][2];
    Menu menu;
    Random random = new Random();
    boolean tilesGenerated;
    int turnNumber;

    public Tiles(Menu menu) {
        this.menu = menu;
    }

    public void print(){
        for (int j=0;j<4;j++){
            System.out.println();
            for (int i=0;i<4;i++){
                if (tiles[i][j] < 10 && tiles[i][j] > 0){
                    System.out.print(" " + tiles[i][j]);
                }else if (tiles[i][j] == 0) {
                    System.out.print("[]");
                }else{
                    System.out.print(tiles[i][j]);
                }
                System.out.print(" ");
            }

            // Turn Display
            System.out.print("   || ");
            if (j == 0){
                System.out.print("Turn " + turnNumber);
            }
        }
    }

    public void setData(){
        // Empty
        for (int j=0;j<4;j++){
            for (int i=0;i<4;i++){
                if(tiles[i][j] == 0){
                    data[0][0] = i;
                    data[0][1] = j;
                    break;
                }
            }
        }

        // Up
        if (data[0][1] == 0){
            data[1][0] = -1;
            data[1][1] = -1;
        }else{
            data[1][0] = data[0][0];
            data[1][1] = data[0][1] - 1;
        }

        // Left
        if (data[0][0] == 0){
            data[2][0] = -1;
            data[2][1] = -1;
        }else{
            data[2][0] = data[0][0] - 1;
            data[2][1] = data[0][1];
        }

        // Down
        if (data[0][1] == 3){
            data[3][0] = -1;
            data[3][1] = -1;
        }else{
            data[3][0] = data[0][0];
            data[3][1] = data[0][1] + 1;
        }

        // Right
        if (data[1][0] == 3){
            data[4][0] = -1;
            data[4][1] = -1;
        }else{
            data[4][0] = data[0][0] + 1;
            data[4][1] = data[0][1];
        }
    }
    public void move(char input){
        // Up
        if (input == 'w'){
            if (data[3][0] == -1){
                if (tilesGenerated){
                    System.out.println("You can't do that!");
                }
            }else{
                tiles[data[0][0]][data[0][1]] = tiles[data[3][0]][data[3][1]];
                tiles[data[3][0]][data[3][1]] = 0;
                turnNumber++;
            }
        }else if (input == 'a'){
            // Left
            if (data[4][0] == -1){
                if (tilesGenerated){
                    System.out.println("You can't do that!");
                }
            }else{
                tiles[data[0][0]][data[0][1]] = tiles[data[4][0]][data[4][1]];
                tiles[data[4][0]][data[4][1]] = 0;
                turnNumber++;
            }
        }else if(input == 's'){
            // Down
            if (data[1][0] == -1){
                if (tilesGenerated){
                    System.out.println("You can't do that!");
                }
            }else{
                tiles[data[0][0]][data[0][1]] = tiles[data[1][0]][data[1][1]];
                tiles[data[1][0]][data[1][1]] = 0;
                turnNumber++;
            }
        }else if(input == 'd'){
            // Right
            if (data[2][0] == -1){
                if (tilesGenerated){
                    System.out.println("You can't do that!");
                }
            }else{
                tiles[data[0][0]][data[0][1]] = tiles[data[2][0]][data[2][1]];
                tiles[data[2][0]][data[2][1]] = 0;
                turnNumber++;
            }
        }else if(input == 'q'){
            // Commands
            menu.reload();
        }else if(input == 'z'){
            this.load(-1);
        }
    }

    public void load(int puzzle){
        turnNumber = 0;
        if (puzzle == -1){
            int k = 0;
            for (int j=0;j<4;j++){
                for (int i=0;i<4;i++){
                    tiles[i][j] = k;
                    k++;
                }
            }
        }
        if (puzzle == 0){
            int k = 0;
            for (int j=0;j<4;j++){
                for (int i=0;i<4;i++){
                    tiles[i][j] = k;
                    k++;
                }
            }
            this.randomizeTiles();
            turnNumber = 0;
        }
    }

    public void randomizeTiles(){
        tilesGenerated = false;
        this.setData();
        int i = random.nextInt(4);
        int j = random.nextInt(4);
        tiles[0][0] = tiles[i][j];
        tiles[i][j] = 0;
        for (i = 0; i< 200; i++){
            this.setData();
            int direction = random.nextInt(5);
            try {
                switch (direction) {
                    case 1 -> this.move('w');
                    case 2 -> this.move('a');
                    case 3 -> this.move('s');
                    case 4 -> this.move('d');
                }
            } catch (ArrayIndexOutOfBoundsException ignored){}
        }
        tilesGenerated = true;
    }
}
