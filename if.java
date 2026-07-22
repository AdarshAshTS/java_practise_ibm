class Main{
    public static void main(String[] args) {
        int age = 18;
        String gender = "woman";

        if(age >= 18)                   // if
            System.out.println("Adult");
        else if(age < 18)               // else if
            System.out.println("Minor");

        if(age >= 18)
            if(gender.equals("woman"))  // nested if
               System.out.println("eligible");
            else
                System.out.println("Not eligible");
    }
}