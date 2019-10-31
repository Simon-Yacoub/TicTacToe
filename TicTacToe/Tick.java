
public class Tick
{
    private boolean isX;
    private boolean isO;
    
    public Tick(boolean isX, boolean isO){
        this.isX = isX;
        this.isO = isO;
    }
    
    public boolean getIsX(){
        return isX;
    }
    
    public boolean getIsO(){
        return isO;
    }
    
    public void tickX(){
        isX = true;
    }
    
    public void tickO(){
        isO = true;
    }
}
