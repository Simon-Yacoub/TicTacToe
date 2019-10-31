import java.util.*;

public class Game
{
    private Board gameBoard;
    private boolean playerTurn;
    private ArrayList<Command> commands; 
    private Scanner sc;
    private int turnCount;
    
    public Game(){
        gameBoard = new Board();
        commands = new ArrayList<Command>();
        playerTurn = true;
        sc = new Scanner(System.in);
        turnCount = 0;
        commands.add(new Command("TL", true, 1));
        commands.add(new Command("TM", true, 2));
        commands.add(new Command("TR", true, 3));
        commands.add(new Command("ML", true, 4));
        commands.add(new Command("MM", true, 5));
        commands.add(new Command("MR", true, 6));
        commands.add(new Command("BL", true, 7));
        commands.add(new Command("BM", true, 8));
        commands.add(new Command("BR", true, 9));
    }
    
    public boolean isValidCommand(String userInput){
        for(Command command : commands){
            if((command.getTarget().equals(userInput)) && command.isAvailable() == true){
            	//System.out.println("Command Target: " +command.getTarget() + " user_input: " + userInput);
                return true;
            }
        }
        return false;
    }
    
    public void updateCommand(String userInput){
    	for(Command command : commands){
            if((command.getTarget().equals(userInput)) && command.isAvailable() == true){
                command.setAvailable(false);
            }
    	}
    }
    
    public int commandToTick(String commandTarget) {
    	for(Command command : commands) {
    		if(command.getTarget().equals(commandTarget)) {
    			return command.getTick();
    		}
    	}
    	return 0;
    }
    
    public void play(){
        System.out.println("WELCOME");
        System.out.println("HOW TO PLAY\n-----------\nEnter the Row and Column as: RC\nWhere R is the row, and R = {T (top), M (middle), B (bottom)}\n"
        		+ "and C is the column, and C = {L (left), M (middle), R (right)}");
        gameBoard.printBoard();
        String currentCommand = "";
        while(!gameBoard.checkForWin()){
        	if(playerTurn) {
        		System.out.println("It is player X's turn!");
        	}else {
        		System.out.println("It is player O's turn");
        	}
            System.out.println("Enter Location: RC");	
            currentCommand = sc.nextLine();
            if(!isValidCommand(currentCommand)){
                System.out.println("sorry incorrect entry try again :)");
                currentCommand = "";
            }else {
            	this.updateCommand(currentCommand);
                gameBoard.updateBoard(commandToTick(currentCommand), this.playerTurn);
                gameBoard.printBoard();
                this.playerTurn = !playerTurn;
                turnCount++;
            }
            if(turnCount == 9) {
            	System.out.println("Tie Game!");
            	break;
            }
            
        }
    }
    
    public static void main(String [] args) {
    	Game game1 = new Game();
    	game1.play();
    }
}
