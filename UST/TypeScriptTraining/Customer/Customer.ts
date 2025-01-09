class Customer {

    private firstName: string;
    private lastName: string;
    private age: number;

    constructor(firstName: string, lastName: string, age: number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

     getFirstName(): string {
        return this.firstName;
    }

     getLastName(): string {
        return this.lastName;
    }

     getAge(): number {
        return this.age;
    }
    public setAge(age: number) {
        this.age = age;
    }

    
    public setFirstName(firstName: string) {
        this.firstName = firstName;
    }
    public setLastName(lastName: string) {
        this.lastName = lastName;
    }
}