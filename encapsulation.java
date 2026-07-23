
public class EncapsulationGetterSetters {
   public static void main(String[] args) {
       Encapsulation encap = new Encapsulation();
       encap.setName("Adarsh");
       System.out.println(encap.getName());
   }
}

class Encapsulation {
   private String name;
   public String getName(){
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
}
