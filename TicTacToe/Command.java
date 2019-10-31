

public class Command
{
    private String target;
    private boolean available;
    private int tick;
    
    public Command(String target, boolean availabe,int tick){
        this.available = availabe;
        this.target = target;
        this.tick = tick;
    }
    
    public boolean isAvailable(){
        return available;
    }
    
    public void setAvailable(boolean available) {
    	this.available = available;
    }
    
    public String getTarget(){
        return target;
    }
    
    public int getTick() {
    	return tick;
    }
}
