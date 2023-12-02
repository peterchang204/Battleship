/*
 TO DO:
 - FIX HORIZONTAL SHIPS BEING ABLE TO BE ONE GRID SPACE WITHIN ONE ANOTHER
 - MAKE IT SO THAT BOTH BOARDS ARE
 */
import java.util.Scanner;
public class Battleship{
    public static void main(String args[]){


        Scanner s1 = new Scanner(System.in);
        //Declaring all the variables.
        int ruleDecision = 0;
        int continueDecision = 0;
        int instructionDecision1 = 0;
        int instructionDecision2 = 0;
        boolean quit = false;
        int playerOneShipRemaining;
        int playerTwoShipRemaining;
       
        //Declaring objects.
        Player p1 = new Player();
        Player p2 = new Player();


        System.out.println("=====================");
        System.out.println("Welcome to Battleship");
        System.out.println("=====================");
        System.out.println();
        //rules of the game


        while(true){


            System.out.println("Would you like to read the rules?");
            System.out.println();
            System.out.println("1. YES");
            System.out.println("2. NO, PROCEED TO GAME.");
            System.out.println();
            ruleDecision = s1.nextInt();


            switch(ruleDecision){
                case 1:


                    while(true){


                        System.out.println();
                        System.out.println("**Battleship is a two player game.**");
                        System.out.println();
                        System.out.println("Player 1 and Player 2 will both be given a 12x12 grid board.");
                        System.out.println();
                        System.out.println("Both players have 5 ships at their disposal of varying sizes (one ship may take up 1 grid, while the other may take up to 5.)");
                        System.out.println();
                        System.out.println("Players may place the ships wherever they want on the board in a horizonatal or vertical orientation.");
                        System.out.println();
                        System.out.println("1. Continue --->");
                        instructionDecision1 = s1.nextInt();


                        if(instructionDecision1 == 1){


                            while(true){


                                System.out.println();
                                System.out.println("Once both players are ready, the game may begin.");
                                System.out.println();
                                System.out.println("Note: Once the game begins, the locations of the ships are hidden, and it is the players' goal to guess where they are.");
                                System.out.println();
                                System.out.println("Each players will take turns guessing on which grid numbers each others' ships are.");
                                System.out.println();
                                System.out.println("Once a player \"hits\" a part of the opponent's ship, they get another turn until they \"miss\"");
                                System.out.println();
                                System.out.println("If a player misses, their turn ends.");
                                System.out.println();
                                System.out.println("The game ends when one of the players has \"sunk\" all their opponent's ships");
                                System.out.println();
                                System.out.println("1. Continue --->");
                                instructionDecision2 = s1.nextInt();
                                if(instructionDecision2 == 1){


                                System.out.println();
                                System.out.println("Here is an example board:");
                                System.out.println();
                                exampleBoard();
                                break;


                                }else{


                                    System.out.println("Please press the 1 key.");


                                }
                            }


                            break;


                        }else{


                            System.out.println("Please press the 1 key.");


                        }
                    }
                    //game starts
                    while(true){


                        System.out.println("Are you ready?");
                        System.out.println();
                        System.out.println("1. YES");
                        System.out.println("2. NO, I WANT TO QUIT.");
                        continueDecision = s1.nextInt();
                        if(continueDecision == 1){
                            break;
                        }else if(continueDecision == 2)
                        {
                            break;
                        }else
                        {
                            System.out.println("Invalid input. Please choose a number 1 or 2.");
                        }


                    }
                    if(continueDecision == 1){
                           
                        }else if(continueDecision == 2){


                            break;


                        }
                        //no break statements because I want the code to move on to case 2:
                case 2:


                    p1.playerName("Player 1", s1, 0);
                    p2.playerName("Player 2", s1, 1);


                    while(quit == false){
                        playerOneShipRemaining = 5;
                        playerTwoShipRemaining = 5;
                        //Players set up their boards
                        playerReady(p1, p2, s1);
                        //actual game starts
                        for(int i = 0; i < p1.shipHeadLocations.length; i++){
                            for(int j = 0; j < p1.shipHeadLocations[0].length; j++){
                                System.out.println(p1.shipHeadLocations[i][j]);
                            }
                        }
                        battleshipGame(p1, p2, playerOneShipRemaining, playerTwoShipRemaining, s1); //INCOMPLETE


                        quit = playAgain(p1, p2, s1);


                        if(quit == true){


                            continueDecision = 2;
                            //This ends the program.
                           
                        }


                    }
                    break;


                default:


                    System.out.println();
                    System.out.println("Invalid input. Please choose a number 1 or 2.");
                    break;


            }
            //exit statement.
            if(continueDecision==2){


                System.out.println("Thank you for playing! Have a good day!");
                break;


            }
        }
    }
    //this only prints the board as an example.
    public static void exampleBoard(){


        System.out.println("  __1___2___3___4___5___6___7___8___9__10__11__12_");
        System.out.println("A |___|_@_|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("B |_@_|_X_|_@_|___|___|___|___|___|___|___|___|___|");
        System.out.println("C |_@_|_X_|_@_|___|___|_@_|_@_|_@_|___|___|___|___|");
        System.out.println("D |_@_|_X_|_@_|___|_@_|_@_|_@_|_@_|___|___|___|___|");
        System.out.println("E |_@_|_X_|_@_|_@_|_@_|___|___|___|___|___|___|___|");
        System.out.println("F |___|_@_|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("G |___|___|___|_*_|_*_|_*_|___|___|___|___|___|___|");
        System.out.println("H |___|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("I |___|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("J |___|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("K |___|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println("L |___|___|___|___|___|___|___|___|___|___|___|___|");
        System.out.println();
        System.out.println("Keys:");
        System.out.println("* - Sunk whole ship");
        System.out.println("@ - Missed spots");
        System.out.println("x - Hit part of a ship");
        System.out.println();


    }


    public static void battleshipGame(Player p1, Player p2, int playerOneStatus, int playerTwoStatus, Scanner s1){
        boolean playerOneTurn = true;
        String playerOneMove;
        String playerTwoMove;
        int playerOneVertMove = 0;;
        int playerTwoVertMove = 0;
        int playerOneHorMove = 0;
        int playerTwoHorMove = 0;
        boolean validMove = false;
        boolean hit = true;
        boolean sunk = false;
        int decision = 0;
        p1.gameBoardReset();
        p2.gameBoardReset();
        while(playerOneStatus != 0 && playerTwoStatus != 0){
            if(playerOneTurn == true){
                displayBothBoards(p1, p2);
                while(validMove == false){
                    playerOneMove = returnPlayerMove(s1, p1);
                    playerOneVertMove = convertAlphaToInt(playerOneMove);
                    playerOneHorMove = convertToInt(playerOneMove);
                    validMove = checkIfMoveValid(playerOneVertMove, playerOneHorMove, p2);
                }
                hit = checkIfHit(playerOneVertMove, playerOneHorMove, p2);
                if(hit == true){
                    p2.battleshipGridBlank[playerOneVertMove][playerOneHorMove] = "|_x_";
                    p2.battleshipGrid[playerOneVertMove][playerOneHorMove] = "|_x_";
                    sunk = checkIfSunk(p2, playerOneVertMove, playerOneHorMove);
                    if(sunk == true){
                        playerTwoStatus -= 1;
                        displayBothBoards(p1, p2);
                        System.out.println("Sunk! Please go again.");
                    }else{
                        displayBothBoards(p1, p2);
                        System.out.println("Hit! Please go again.");
                    }
                }else if(hit == false){
                    p2.battleshipGridBlank[playerOneVertMove][playerOneHorMove] = "|_@_";
                    p2.battleshipGrid[playerOneVertMove][playerOneHorMove] = "|_@_";
                    displayBothBoards(p1, p2);
                    System.out.println("Miss!");
                    System.out.println("Please type in any number to clear the screen, and then hand the laptop to " + p2.name);
                    decision = s1.nextInt();
                    if(decision != 0){
                        newLineGenerator();
                    }
                    System.out.println(p2.name + " in order to proceed, type in any number.");
                    decision = s1.nextInt();
                }
                sunk = false;
                validMove = false;
                if(hit == true){
                    playerOneTurn = true;
                }else{
                    playerOneTurn = false;
                }
            }
            if(playerOneTurn == false){ //player two's turn
                displayBothBoards(p2, p1);
                while(validMove == false){
                    playerTwoMove = returnPlayerMove(s1, p2);
                    playerTwoVertMove = convertAlphaToInt(playerTwoMove);
                    playerTwoHorMove = convertToInt(playerTwoMove);
                    validMove = checkIfMoveValid(playerTwoVertMove, playerTwoHorMove, p1);
                }
                hit = checkIfHit(playerTwoVertMove, playerTwoHorMove, p1);
                if(hit == true){
                    p1.battleshipGridBlank[playerTwoVertMove][playerTwoHorMove] = "|_x_";
                    p1.battleshipGrid[playerTwoVertMove][playerTwoHorMove] = "|_x_";
                    sunk = checkIfSunk(p1, playerTwoVertMove, playerTwoHorMove);
                    if(sunk == true){
                        playerOneStatus -= 1;
                        displayBothBoards(p2, p1);
                        System.out.println("Sunk! Please go again.");
                    }else{
                        displayBothBoards(p2, p1);
                        System.out.println("Hit! Please go again.");
                    }
                }else if(hit == false){
                    p1.battleshipGridBlank[playerTwoVertMove][playerTwoHorMove] = "|_@_";
                    p1.battleshipGrid[playerTwoVertMove][playerTwoHorMove] = "|_@_";
                    displayBothBoards(p2, p1);
                    System.out.println("Miss!");
                    System.out.println("Please type in any number to clear the screen, and then hand the laptop to " + p1.name);
                    decision = s1.nextInt();
                    if(decision != 0){
                        newLineGenerator();
                    }
                    System.out.println(p1.name + " in order to proceed, type in any number.");
                    decision = s1.nextInt();
                }
                sunk = false;
                validMove = false;
                if(hit == true){
                    playerOneTurn = false;
                }else{
                    playerOneTurn = true;
                }
            }
        }
        if(playerTwoStatus == 0){
            System.out.println("Congrats, " + p1.name + " you won!");
        }else{
            System.out.println("Congrats, " + p2.name + " you won!");
        }
    }
    public static boolean checkIfSunk(Player p1, int y, int x){
        int[] headY = new int[5];
        int[] headX = new int[5];
        int[] size = new int[5];
        int numHit = 0;
        int numSunkShip = 0;
        for(int i = 0; i < p1.shipHeadLocations[0].length; i++){
            headX[i] = convertToInt(p1.shipHeadLocations[0][i]);
            headY[i] = convertAlphaToInt(p1.shipHeadLocations[0][i]);
        }
        for(int i = 0; i < p1.shipHeadLocations[0].length; i++){
            size[i] = Integer.parseInt(p1.shipHeadLocations[2][i]);
        }
        for(int i = 0; i < p1.shipHeadLocations[0].length; i++){
            for(int j = 0; j < size[i]; j++){
                if(p1.shipHeadLocations[1][i].equals("horizontal")){
                    if(p1.battleshipGridBlank[headY[i]][headX[i] + j] == "|_x_"){
                        numHit++;
                    }
                }else{
                    System.out.println(headY[4]);
                    System.out.println(headY[i] + j);
                    if(p1.battleshipGridBlank[headY[i] + j][headX[i]] == "|_x_"){
                        numHit++;
                    }
                }
            }
            if(numHit == size[i]){
                numSunkShip++;
                for(int j = 0; j < size[i]; j++){
                    if(p1.shipHeadLocations[1][i].equals("horizontal")){
                        if(headY[i] < 12 && headY[i] > 1 && headX[i] < 12 && headX[i] > 1){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                        }else if(headY[i] == 1 && headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j + 1] = "|_@_";
                            }
                        }else if(headY[i] == 12 && headX[i] == 12 - size[i] + 1){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                        }else if(headY[i] == 12 && headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j + 1] = "|_@_";
                            }
                        }else if(headY[i] == 1 && headX[i] == 12 - size[i] + 1){
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                        }else if(headY[i] == 12){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j + 1] = "|_@_";
                            }
                        }else if(headY[i] == 1){
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j + 1] = "|_@_";
                            }
                        }else if(headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                                p1.battleshipGridBlank[headY[i]][headX[i] + j + 1] = "|_@_";
                            }
                        }else if(headX[i] == 12 - size[i] + 1){
                            p1.battleshipGridBlank[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGridBlank[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i] - 1][headX[i] + j] = "|_@_";
                            p1.battleshipGrid[headY[i]][headX[i] + j] = "|_*_";
                            p1.battleshipGrid[headY[i] + 1][headX[i] + j] = "|_@_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i]][headX[i] + j - 1] = "|_@_";
                                p1.battleshipGrid[headY[i]][headX[i] + j - 1] = "|_@_";
                            }
                        }
                    }else /*if vertical*/{
                        if(headY[i] < 12 - size[i] - 1 && headY[i] > 1 && headX[i] < 12 && headX[i] >1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] + j - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j - 1][headX[i]] = "|_@_";
                            }
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 1 && headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 12 - size[i] + 1 && headX[i] == 12){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] + j - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j - 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 12 - size[i] + 1 && headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] - 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 1 && headX[i] == 12){
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 12 - size[i] + 1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] - 1][headX[i]] = "|_@_";
                            }
                        }else if(headY[i] == 1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                        }else if(headX[i] == 1){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGridBlank[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] + 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] - 1][headX[i]] = "|_@_";
                            }
                        }else if(headX[i] == 12){
                            p1.battleshipGridBlank[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            p1.battleshipGrid[headY[i] + j][headX[i] - 1] = "|_@_";
                            p1.battleshipGrid[headY[i] + j][headX[i]] = "|_*_";
                            if(j == size[i] - 1){
                                p1.battleshipGridBlank[headY[i] + j + 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] + j + 1][headX[i]] = "|_@_";
                            }
                            if(j == 0){
                                p1.battleshipGridBlank[headY[i] - 1][headX[i]] = "|_@_";
                                p1.battleshipGrid[headY[i] - 1][headX[i]] = "|_@_";
                            }
                        }
                    }
                }
            }
            numHit = 0;
        }
        if(numSunkShip > 0 && p1.battleshipGridBlank[y][x].equals("|_*_")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkIfHit(int y, int x, Player p){
        if(p.battleshipGrid[y][x].equals("|_o_")){
            return true;
        }else{
            return false;
        }
    }
    public static void displayBothBoards(Player p1, Player p2){
        System.out.print(p2.name + "'s Board:");
        System.out.println("                                                      Your Board:");
        for(int k = 0; k < p2.battleshipGridBlank.length; k++){
            for(int z = 0; z < p2.battleshipGridBlank[0].length; z++){
                System.out.print(p2.battleshipGridBlank[k][z]);
            }
            if(k == 0){
                System.out.print("         ");
            }else{
                System.out.print("            ");
            }
            for(int z = 0; z < p1.battleshipGridBlank[0].length; z++){
                System.out.print(p1.battleshipGrid[k][z]);
            }
            if(k == 5){
                System.out.print("       Keys:");
            }else if(k == 6){
                System.out.print("       X: Sunk whole ship");
            }else if(k == 7){
                System.out.print("       *: Hit part of a ship");
            }else if(k == 8){
                System.out.print("       @ : Missed");
            }
            System.out.println();
        }
    }
    public static boolean checkIfMoveValid(int vert, int hor, Player p){
        if(!(vert <= 12) || !(vert >= 1) || !(hor <=12) || !(hor >= 1)){
            System.out.println("You entered an invalid move, please enter a grid number A1 - L12");
            return false;
        }else if(p.battleshipGridBlank[vert][hor].equals("|_x_") || p.battleshipGridBlank[vert][hor].equals("|_*_" ) || p.battleshipGridBlank[vert][hor].equals("|_@_")){
            System.out.println("You already made a move at this spot, please choose another spot.");
            return false;
        }else{
            return true;
        }
    }
    public static int convertToInt(String move){
        String horNum;
        int returnVal;
        if(move.length() == 2){
            horNum = move.substring(1, 2);
        }else{
            horNum = move.substring(1, 3);
        }
        returnVal = Integer.parseInt(horNum);
        return returnVal;
    }
    public static int convertAlphaToInt(String move){
        char alpha;
        int returnVal;
        alpha = move.charAt(0);
        returnVal = gridLetterNum(alpha);
        return returnVal;
    }
    public static String returnPlayerMove(Scanner s1, Player playerRef){
        String move;
        System.out.println("Where would you like to attack, " + playerRef.name + "? (ex: A1 - L12)");
        move = s1.next();
        return move;
    }
    public static void playerReady(Player p1, Player p2, Scanner s1){


        int boardReady1 = 0;
        int boardReady2 = 0;


        while(true){


            p1.playerBoardSetup(s1);
            p1.displaySetupBoard();
            System.out.println("Are you ready, " + p1.name + "?");


            while(true){


                System.out.println("1. YES");
                System.out.println("2. NO");
                boardReady1 = s1.nextInt();
                if(boardReady1 == 1){


                    break;


                }else if(boardReady1 == 2){


                    break;


                }else{


                    System.out.println("Invalid Input.");


                }


            }
            if(boardReady1 == 1){


                boardReady1 = 0;
                break;


            }else{


                boardReady1 = 0;


            }
        }


        while(true){


            p2.playerBoardSetup(s1);
            p2.displaySetupBoard();
            System.out.println("Are you ready, " + p2.name + "?");


            while(boardReady2 != 1 || boardReady2 !=2){


                System.out.println("1. YES");
                System.out.println("2. NO");
                boardReady2 = s1.nextInt();


                if(boardReady2 == 1){


                    break;


                }else if(boardReady2 == 2){


                    break;


                }else{


                    System.out.println("Invalid Input.");


                }


            }
            if(boardReady2 == 1){


                boardReady2 = 0;
                break;


            }else{


                boardReady2 = 0;


            }
        }
    }


    public static boolean playAgain(Player p1, Player p2, Scanner s1){


        int playerOneAnswer = 0;
        int playerTwoAnswer = 0;


        System.out.println("Congrats (winner)!"); //FINISH THIS CODE. Determine who won.
        while(true){


            System.out.println("Would you like to play again, " + p1.name + "?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            playerOneAnswer = s1.nextInt();


            if(playerOneAnswer == 1){


                break;


            }else if(playerOneAnswer == 2){


                break;


            }else{


                System.out.println("Invalid Input.");


            }


        }
        while(true){


            System.out.println("Would you like to play again, " + p2.name + "?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            playerTwoAnswer = s1.nextInt();


            if(playerTwoAnswer == 1){


                break;


            }else if(playerTwoAnswer == 2){


                break;


            }else{


                System.out.println("Invalid Input.");


            }


        }
        if(playerOneAnswer == 1 && playerTwoAnswer == 1){


            return false;


        }else if(playerOneAnswer == 2 && playerTwoAnswer == 2){


            System.out.println(p1.name + " and " + p2.name + " seem to have come to a mutual decision to quit.");
            return true;


        }else if(playerOneAnswer == 2){


            System.out.println(p1.name + " wants to quit.");
            return true;


        }else{


            System.out.println(p2.name + " wants to quit.");
            return true;


        }


    }
    public static void newLineGenerator(){
        for(int i = 0; i < 40; i++){
            System.out.println();
        }
    }
    public static int gridLetterNum(char gridLetter){


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
}



