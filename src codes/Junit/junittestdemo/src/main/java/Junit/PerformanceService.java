package Junit;

public class PerformanceService {
    public void quickOperation() {
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            System.err.println(e);
        }
        
    }

    public void slowOperation() {
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.err.println(e);
        }
    }
}
