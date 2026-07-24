class goodMorning extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.print("Good Morning\n");
        }
        catch(Exception e){
            System.out.print("Error");
        }
    }
}

class goodEvening extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.print("Good Evening\n");
        }
        catch(Exception e){
            System.out.print("Error");
        }
    }
}

class goodAfternoon extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
            System.out.print("Good Afternoon\n");
        }
        catch(Exception e){
            System.out.print("Error");
        }
    }
}
class LoopedThread extends Thread{
    public synchronized void run(){
        System.out.print("Thread: " + Thread.currentThread().getName() + "\n");
        // System.out.println("Is Alive: " + this.isAlive());
        // Thread.dumpStack();
    }
}

class Main{
    public static void main(String[] args){
        goodMorning statement1 = new goodMorning();
        goodEvening statement2 = new goodEvening();
        goodAfternoon statement3 = new goodAfternoon();
        
        statement3.setPriority(Thread.MAX_PRIORITY);
        statement2.setPriority(Thread.NORM_PRIORITY);
        statement1.setPriority(Thread.MIN_PRIORITY);
        
        statement1.start();
        statement2.start();
        statement3.start();
        
        for(int i=0; i<10; i++){
            LoopedThread t = new LoopedThread();
            t.start();
        }
    }
}