/*

let a: number = 5
console.log(a)

function greet(message: String): String {
    return message + ", Welcome to Club!";
}
console.log(greet("Ash"));

*/

/*

interface user {
    s_name: String;
    age?: number;

    display(): void;
}

class UserClass implements user{
    s_name: String;
    age: number;

    constructor(s_name: String, age: number){
        this.s_name = s_name;
        this.age = age;
    }

    display(){
        console.log("name: " + this.s_name + "\nage: " + this.age)
    }
}

let user_1 = new UserClass("adarsh", 23);
user_1.display();

*/

/*

interface paymentInterface{
    pay(amount: number): void;
}

class upiPayment implements paymentInterface{
    pay(amount: number): void{
        console.log("paid via upi: " + amount);
    }
}

class cardPayment implements paymentInterface{
    pay(amount: number): void{
        console.log("paid via card: " + amount);
    }
}

function makePayment(paymentMethod: paymentInterface, amount: number): void {
    paymentMethod.pay(amount)
}

const upi =  new upiPayment();
const card = new cardPayment();

makePayment(upi, 500);
makePayment(card, 200);

*/

/*

class Student {
    name: string;
    age: number;

    constructor(name: string = "Unknown", age: number = 0) {
        this.name = name;
        this.age = age;
    }

    display(): void {
        console.log(`Name: ${this.name}, Age: ${this.age}`);
    }
}

let s1 = new Student();
let s2 = new Student("Adarsh", 23);

s1.display();
s2.display();

*/

/*

class Employee{
    public name: String;
    private id: String;
    protected lapId: String;

    constructor(name: String, id: String, lapId:String) {
        this.name = name;
        this.id = id;
        this.lapId = lapId;
    }

    printName(): void {
        console.log(this.name);
    }

    printId(): void {
        console.log(this.id);
    }

    printLapId(): void {
        console.log(this.lapId);
    }
}

class manager extends Employee{
    testProtected(){
        console.log(this.lapId);
    }
}

const emp = new Employee("adarsh", "93123345", "mcp87192");

emp.printName();
emp.printId();
emp.printLapId();

console.log(emp.name);
// console.log(emp.id);
// console.log(emp.lapId);

*/

/*

class genericClass<T> {
    value: T;

    constructor(value: T) {
        this.value = value;
    }

    display(){
        console.log(this.value);
    }
}

const genericString = new genericClass<String>("i am a string");
const genericNumber = new genericClass<Number>(100);

genericNumber.display();
genericString.display();

*/

/*

let a: any = "Hello";
console.log(a.toUpperCase()); // Allowed

let b: unknown = "Hello";

// console.log(b.toUpperCase()); // Error

if (typeof b === "string") {
    console.log(b.toUpperCase()); // Allowed after type check
}

*/