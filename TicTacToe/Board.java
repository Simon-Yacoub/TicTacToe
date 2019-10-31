import java.util.*;
public class Board
{
    private ArrayList<Tick> gameBoard;
    Tick tick1, tick2, tick3, tick4, tick5;
    Tick tick6, tick7, tick8, tick9;
    
    public Board(){
        gameBoard = new ArrayList<Tick>();
        tick1 = new Tick(false, false);
        tick2 = new Tick(false, false);
        tick3 = new Tick(false, false);
        tick4 = new Tick(false, false);
        tick5 = new Tick(false, false);
        tick6 = new Tick(false, false);
        tick7 = new Tick(false, false);
        tick8 = new Tick(false, false);
        tick9 = new Tick(false, false);
        gameBoard.add(tick1);
        gameBoard.add(tick2);
        gameBoard.add(tick3);
        gameBoard.add(tick4);
        gameBoard.add(tick5);
        gameBoard.add(tick6);
        gameBoard.add(tick7);
        gameBoard.add(tick8);
        gameBoard.add(tick9);
    }
    
    public void printBoard(){
        int count = 0;
        for(Tick tick : gameBoard){
            count++;
            if(tick.getIsX() == true){
                System.out.print("X");
            }else if(tick.getIsO() == true){
                System.out.print("O");
            }else{
                System.out.print(" ");
            }
            
            if(count % 3 != 0){
                System.out.print("|");
            }else{
                if(count != 9){
                    System.out.print("\n-----\n");
                }else{
                    System.out.print("\n");
                }
            }
        }
    }
    
    public void updateBoard(int tick, boolean playerTurn) {
    	if(tick == 1) {
    		if(playerTurn) {
    			tick1.tickX();
    		}else {
    			tick1.tickO();
    		}
    	}else if(tick == 2) {
    		if(playerTurn) {
    			tick2.tickX();
    		}else {
    			tick2.tickO();
    		}
    	}else if(tick == 3) {
    		if(playerTurn) {
    			tick3.tickX();
    		}else {
    			tick3.tickO();
    		}
    	}else if(tick == 4) {
    		if(playerTurn) {
    			tick4.tickX();
    		}else {
    			tick4.tickO();
    		}
    	}else if(tick == 5) {
    		if(playerTurn) {
    			tick5.tickX();
    		}else{
    			tick5.tickO();
    		}
    	}else if(tick == 6) {
    		if(playerTurn) {
    			tick6.tickX();
    		}else{
    			tick6.tickO();
    		}
    	}else if(tick == 7) {
    		if(playerTurn) {
    			tick7.tickX();
    		}else{
    			tick7.tickO();
    		}
    	}else if(tick == 8) {
    		if(playerTurn) {
    			tick8.tickX();
    		}else{
    			tick8.tickO();
    		}
    	}else if(tick == 9) {
    		if(playerTurn) {
    			tick9.tickX();
    		}else{
    			tick9.tickO();
    		}
    	}else {
    		System.out.println("INCORRECT TICK ERROR");
    	}
    }

    public boolean checkForWin(){
        if(tick1.getIsX() == true && tick2.getIsX() == true && tick3.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }else if(tick4.getIsX() == true && tick5.getIsX() == true && tick6.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }else if(tick7.getIsX() == true && tick8.getIsX() == true && tick9.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }
        
        if(tick1.getIsO() == true && tick2.getIsO() == true && tick3.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }else if(tick4.getIsO() == true && tick5.getIsO() == true && tick6.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }else if(tick7.getIsO() == true && tick8.getIsO() == true && tick9.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }
        
        if(tick1.getIsX() == true && tick4.getIsX() == true && tick7.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }else if(tick2.getIsX() == true && tick5.getIsX() == true && tick8.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }else if(tick3.getIsX() == true && tick6.getIsX() == true && tick9.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }
        
        if(tick1.getIsO() == true && tick4.getIsO() == true && tick7.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }else if(tick2.getIsO() == true && tick5.getIsO() == true && tick8.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }else if(tick3.getIsO() == true && tick6.getIsO() == true && tick9.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }
        
        if(tick1.getIsO() == true && tick5.getIsO() == true && tick9.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }else if(tick3.getIsO() == true && tick5.getIsO() == true && tick7.getIsO() == true){
            System.out.println("Player O Wins!");
            return true;
        }
        
        if(tick1.getIsX() == true && tick5.getIsX() == true && tick9.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }else if(tick3.getIsX() == true && tick5.getIsX() == true && tick7.getIsX() == true){
            System.out.println("Player X Wins!");
            return true;
        }
        return false;
    }
}
