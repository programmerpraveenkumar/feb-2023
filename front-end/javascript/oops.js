class Person{
    firstName="sample name";//variable declaration.
    //constructor will be called during the object creation of this class.
    // constructor(){
    //     console.log("this is inside the constructor");
    // }
    printName(){
        console.log("this is inside personclass..name is ",this.firstName);
    }
    printAddress(address){
        console.log("this is address.inside the person class",address);
    }
    printDetails(){
        let name = document.getElementById("name").value;
        let address = document.getElementById("address").value;
        if(name == ""){
            alert("please enter the name");
        }else if(address ==""){
            alert("please enter the address");
        }else{
            alert("everyhing is fine.")
        }
        //console.log(name,address);
    }
}