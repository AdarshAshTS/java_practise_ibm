/*

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = "";
        String password = "";

        while(true){
            System.out.println("Enter the name:");
            name = sc.nextLine();
            System.out.println("Enter the password:");
            password = sc.nextLine();

            if(name.equals("adarsh") && password.equals("1234"))
                break;
            else
                System.out.println("Incorrect credentials");
        }

        System.out.print("Welcome " + name);
    }
}

*/

import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = "";
        String password = "";

        System.out.println("Enter the name:");
        name = sc.nextLine();
        System.out.println("Enter the password:");
        password = sc.nextLine();

        do{
            System.out.print("Welcome " + name);
        }
        while(name.equals("adarsh") && password.equals("1234"));
    }
}