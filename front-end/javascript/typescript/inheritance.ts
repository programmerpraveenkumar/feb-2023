class Parent{
    message(){
        console.log("this is sample message")
    }
}

//inheritance.extends the parent to the child
class Child extends Parent{
    printMesssage(){
        this.message();//calling the parent method using inheritance
    }
    //method with return type
    getName():string{
        return "sample";
    }
}

let child = new Child();
child.printMesssage();