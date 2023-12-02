/*
TO DO:


- Make enumerators for each player's board indicating how many ships they have
- Make enumerators for each player's board indicating how many parts of each of their ships is damaged
- Make a method that prints a bunch of white spaces so that players will not be able to cheat as easily.
- Make a method that allows each players to attack a ship


*/
import java.util.Scanner;
public class Player{


    int wins;
    int losses;
    int hits;
    int misses;
    int sinks;
    int streak; //work on later
    String name;
    String move;
    int orientation;
    String gridNumber;
    int gridNumberInt;
    String moveInString;
    char gridLetter;
    int fixedNumber;
    char fixedLetter;
    String battleshipGrid[][] = new String[13][14];
    int y;
    int x;
    String battleshipGridBlank[][] = new String[13][14];
    //Will display the grid numbers for the head of each ship on the first row
    //Will display the orientation for each ship on the second row.
    //Will display the size of each ship on the third row.
    String shipHeadLocations[][] = new String[3][5];


    public void playerName(String playerTitle, Scanner s1, int indicator){


        System.out.println();
        System.out.println("What is your name, " + playerTitle+"?");
        name = s1.nextLine();
        if(indicator == 0){
            name = s1.nextLine();
        }


    }
    public void displayPlayerStats(){


        System.out.println();
        System.out.println(name+" Stats:");
        System.out.println();
        System.out.println("Wins: ");
        System.out.println("Losses: ");
        System.out.println("Winning Streak: ");
        System.out.println("Hits: ");
        System.out.println("Misses: ");
        System.out.println("Sinks: ");
        System.out.println();
    }
    public void displaySetupBoard(){
       
        for(int k = 0; k < battleshipGrid.length; k++){
            for(int z = 0; z < battleshipGrid[0].length; z++)
            {
                System.out.print(battleshipGrid[k][z]);
            }
            System.out.println();
        }


    }
    public void displayGameBoard(){
       
        System.out.println(name + "'s Board:");
        for(int k = 0; k < battleshipGridBlank.length; k++){
            for(int z = 0; z < battleshipGridBlank[0].length; z++)
            {
                System.out.print(battleshipGridBlank[k][z]);
            }
            System.out.println();
        }


    }
    public void displayBothBoards(){
        System.out.print(name + "'s Board:");
        System.out.println("                                                              Your Board:");
        for(int k = 0; k < battleshipGridBlank.length; k++){
            for(int z = 0; z < battleshipGridBlank[0].length; z++){
                System.out.print(battleshipGridBlank[k][z]);
            }
            if(k == 0){
                System.out.print("          ");
            }else{
                System.out.print("                            ");
            }
            for(int z = 0; z < battleshipGridBlank[0].length; z++){
                System.out.print(battleshipGrid[k][z]);
            }
            System.out.println();
        }
    }
    public void playerBoardSetup(Scanner s1){


        boardSetupReset();
        boolean eligibleSpot;
        int counter = 0;


        for(int shipLength = 5; shipLength > 0; shipLength--){
            shipHeadLocations[2][shipLength - 1] = Integer.toString(shipLength);
            eligibleSpot = false;
            displaySetupBoard();
            System.out.println();
            while(true){
                userShipPlacement(s1, shipLength);
                if(x >= 13 || y >= 13){
                    if(x >= 13 && y >= 13){
                        System.out.println("You entered both an invalid number and an invalid letter. Please type in a valid position A1 - L12.");
                    }else if(x >= 13){
                        System.out.println("You entered an invalid number. Please type in a letter 1 - 12.");
                    }else if(y >= 13){
                        System.out.println("You entered an invalid letter. Please type in a letter A - L.");
                    }
                }else{
                        break;
                }
               
            }
           
            while(true){
                System.out.println("How would you like your ship to be oriented?");
                System.out.println("1. Horizontal.");
                System.out.println("2. Vertical.");
                orientation = s1.nextInt();
                if(orientation == 1){
                    break;
                }else if(orientation == 2){
                    break;
                }else{
                    System.out.println("Invalid orientation. Please enter either 1 for horizontal or 2 for vertical.");
                }
            }
            if(orientation == 1){
               
                shipHeadLocations[1][shipLength - 1] = "horizontal";
                while(eligibleSpot == false){
                    if(x > 12 - shipLength){
                        x = 13 - shipLength;
                    }
                    for(int h = x; h <= shipLength + x - 1; h++){
                        if(y != 12){
                            if((battleshipGrid[y + 1][h].equals("|_o_")) || battleshipGrid[y][h].equals("|_o_")){
                                counter++;
                            }
                        }
                        if(y != 1){
                            if((battleshipGrid[y - 1][h].equals("|_o_")) || battleshipGrid[y][h].equals("|_o_")){
                                counter++;
                            }
                        }


                    }
                    if(battleshipGrid[y][x - 1].equals("|_o_") || battleshipGrid[y][shipLength + x].equals("|_o_")){
                        counter++;
                    }
                    if(counter == 0){
                        eligibleSpot = true;
                        counter = 0;
                    }else{
                        System.out.println("The spot you picked is not valid because another ship is too close or overlaps with it.");
                        System.out.println("Please make sure there is at least a one grid space between one ship and the other.");
                        while(true){
                            userShipPlacement(s1, shipLength);
                            if(x >= 13 || y >= 13){
                                if(x >= 13 && y >= 13){
                                    System.out.println("You entered both an invalid number and an invalid letter. Please type in a valid position A1 - L12.");
                                }else if(x >= 13){
                                    System.out.println("You entered an invalid number. Please type in a letter 1 - 12.");
                                }else if(y >= 13){
                                    System.out.println("You entered an invalid letter. Please type in a letter A - L.");
                                }else if(x > 12 - shipLength - 1){
                                    System.out.println("Since the ship length exceeds the board with your number choice, please choose another number.");
                                }
                            }else{
                                break;
                            }
                        }
                        counter = 0;
                    }
                }
                if(eligibleSpot == true){
                   
                    if(x <= 12 - shipLength){
                        for(int h = x; h <= shipLength + x - 1; h++){
       
                            battleshipGrid[y][h] = "|_o_";
                        }
                        shipHeadLocations[0][shipLength - 1] = move;
                    }else if(x > 12 - shipLength){
                        for(int h = 13 - shipLength; h <= 12; h++){
                            battleshipGrid[y][h] = "|_o_";
                        }
                        fixedNumber = (13 - shipLength);
                        System.out.println("Since the ship length exceeds the board with your letter choice, we have modified it to " + gridLetter + fixedNumber);
                        moveInString = Character.toString(gridLetter) + Integer.toString(fixedNumber);
                        shipHeadLocations[0][shipLength - 1] = moveInString;
                    }
                }
               


            }else if(orientation == 2){
                shipHeadLocations[1][shipLength - 1] = "vertical";
                while(eligibleSpot == false){
                    if(y > 12 - shipLength){
                        y = 13 - shipLength;
                    }
                    for(int h = y; h <= shipLength + y - 1; h++){


                        if((battleshipGrid[h][x + 1].equals("|_o_")) || (battleshipGrid[h][x - 1].equals("|_o_"))
                            || battleshipGrid[h][x].equals("|_o_")){
                            counter++;
                        }


                    }
                    if(battleshipGrid[y - 1][x].equals("|_o_") || battleshipGrid[y + shipLength - 1][x].equals("|_o_")){
                        counter++;
                    }
                    if(counter == 0){
                        eligibleSpot = true;
                        counter = 0;
                    }else{
                        System.out.println("The spot you picked is not valid because another ship is too close or overlaps with it.");
                        System.out.println("Please make sure there is at least a one grid space between one ship and the other.");
                        while(true){
                            userShipPlacement(s1, shipLength);
                            if(x >= 13 || y >= 13){
                                if(x >= 13 && y >= 13){
                                    System.out.println("You entered both an invalid number and an invalid letter. Please type in a valid position A1 - L12.");
                                }else if(x >= 13){
                                    System.out.println("You entered an invalid number. Please type in a letter 1 - 12.");
                                }else if(y >= 13){
                                    System.out.println("You entered an invalid letter. Please type in a letter A - L.");
                                }else if(y > 12 - shipLength -1){
                                    System.out.println("Since the ship length exceeds the board with your letter choice, please choose another letter.");
                                }
                            }else{
                                break;
                            }
                        }
                        counter = 0;
                    }
                }
                if(eligibleSpot == true){
                    if(y <= 12 - shipLength){
                    for(int h = y; h <= shipLength + y - 1; h++){
                        battleshipGrid[h][x] = "|_o_";
                    }
                    shipHeadLocations[0][shipLength - 1] = move;
                    }else if(y > 12 - shipLength){
                        for(int h = 13 - shipLength; h <= 12; h++){
                            battleshipGrid[h][x] = "|_o_";
                        }
                        fixedLetter = getLetterVal(13 - shipLength);
                        System.out.println("Since the ship length exceeds the board with your letter choice, we have modified it to " + fixedLetter + gridNumber);
                        moveInString = Character.toString(fixedLetter) + gridNumber;
                        shipHeadLocations[0][shipLength - 1] = moveInString;
                    }
                }
            }
        }


    }
    public void boardSetupReset(){


        for(int k = 1; k < battleshipGrid.length; k++)
        {
            for(int z = 1; z < battleshipGrid[0].length - 1; z++)
            {
                battleshipGrid[k][z] = "|___";
            }
        }


        for(int d = 0; d < battleshipGrid[0].length; d++)
        {
            if(d < 1 || d > 12){
                battleshipGrid[0][d] = "    ";
            }else if(d < 10){
                battleshipGrid[0][d] = "__" + d + "_";
            }else{
                battleshipGrid[0][d] = "_" + d + "_";
            }
        }
        for(int d = 1; d < battleshipGrid.length; d++){
            battleshipGrid[d][battleshipGrid[0].length - 1] = "|";
        }
        battleshipGrid[1][0] = "A   ";
        battleshipGrid[2][0] = "B   ";
        battleshipGrid[3][0] = "C   ";
        battleshipGrid[4][0] = "D   ";
        battleshipGrid[5][0] = "E   ";
        battleshipGrid[6][0] = "F   ";
        battleshipGrid[7][0] = "G   ";
        battleshipGrid[8][0] = "H   ";
        battleshipGrid[9][0] = "I   ";
        battleshipGrid[10][0] = "J   ";
        battleshipGrid[11][0] = "K   ";
        battleshipGrid[12][0] = "L   ";


    }


    public int gridLetterNum(char gridLetter){


        if(gridLetter == 'A'){
            return 1;
        }
        if(gridLetter == 'B'){
            return 2;
        }
        if(gridLetter == 'C'){
            return 3;
        }
        if(gridLetter == 'D'){
            return 4;
        }
        if(gridLetter == 'E'){
            return 5;
        }
        if(gridLetter == 'F'){
            return 6;
        }
        if(gridLetter == 'G'){
            return 7;
        }
        if(gridLetter == 'H'){
            return 8;
        }
        if(gridLetter == 'I'){
            return 9;
        }
        if(gridLetter == 'J'){
            return 10;
        }
        if(gridLetter == 'K'){
            return 11;
        }
        if(gridLetter == 'L'){
            return 12;
        }else{
            return 13;
        }


    }
    // public char toChar(){
    //     if(fixedNumber == 1){
    //         return 'A';
    //     }
    //     if(fixedNumber == 2){
    //         return 'B';
    //     }
    //     if(fixedNumber == 3){
    //         return 'C';
    //     }
    //     if(fixedNumber == 4){
    //         return 'D';
    //     }
    //     if(fixedNumber == 5){
    //         return 'E';
    //     }
    //     if(fixedNumber == 6){
    //         return 'F';
    //     }
    //     if(fixedNumber == 7){
    //         return 'G';
    //     }
    //     if(fixedNumber == 8){
    //         return 'H';
    //     }
    //     if(fixedNumber == 9){
    //         return 'I';
    //     }
    //     if(fixedNumber == 10){
    //         return 'J';
    //     }
    //     if(fixedNumber == 11){
    //         return 'K';
    //     }
    //     if(fixedNumber == 12){
    //         return 'L';
    //     }else{
    //         return 'M';
    //     }
    // }
    public char getLetterVal(int gridNum){
        if(gridNum == 1){
            return 'A';
        }
        if(gridNum == 2){
            return 'B';
        }
        if(gridNum == 3){
            return 'C';
        }
        if(gridNum == 4){
            return 'D';
        }
        if(gridNum == 5){
            return 'E';
        }
        if(gridNum == 6){
            return 'F';
        }
        if(gridNum == 7){
            return 'G';
        }
        if(gridNum == 8){
            return 'H';
        }
        if(gridNum == 9){
            return 'I';
        }
        if(gridNum == 10){
            return 'J';
        }
        if(gridNum == 11){
            return 'K';
        }
        if(gridNum == 12){
            return 'L';
        }else{
            return '?';
        }
    }
    public void userShipPlacement(Scanner s1, int shipLength){
        System.out.println(name + " where would you like your " + shipLength + " grid ship to be? (ex. A1 - L12)");
        move = s1.next();
        gridLetter = move.charAt(0);
        gridNumber = move.substring(1);
        x = Integer.parseInt(gridNumber);
        y = gridLetterNum(gridLetter);
    }
    public void gameBoardReset(){
        for(int k = 1; k < battleshipGridBlank.length; k++)
        {
            for(int z = 1; z < battleshipGridBlank[0].length - 1; z++)
            {
                battleshipGridBlank[k][z] = "|___";
            }
        }


        for(int d = 0; d < battleshipGridBlank[0].length; d++)
        {
            if(d < 1 || d > 12)
            {
                battleshipGridBlank[0][d] = "    ";
            }else if(d < 10)
            {
                battleshipGridBlank[0][d] = "__" + d + "_";
            }else
            {
                battleshipGridBlank[0][d] = "_" + d + "_";
            }
        }
        for(int d = 1; d < battleshipGridBlank.length; d++)
        {
            battleshipGridBlank[d][battleshipGridBlank[0].length - 1] = "|";
        }
        battleshipGridBlank[1][0] = "A   ";
        battleshipGridBlank[2][0] = "B   ";
        battleshipGridBlank[3][0] = "C   ";
        battleshipGridBlank[4][0] = "D   ";
        battleshipGridBlank[5][0] = "E   ";
        battleshipGridBlank[6][0] = "F   ";
        battleshipGridBlank[7][0] = "G   ";
        battleshipGridBlank[8][0] = "H   ";
        battleshipGridBlank[9][0] = "I   ";
        battleshipGridBlank[10][0] = "J   ";
        battleshipGridBlank[11][0] = "K   ";
        battleshipGridBlank[12][0] = "L   ";
    }
}



