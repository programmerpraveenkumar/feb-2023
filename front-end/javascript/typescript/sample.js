console.log("this is console output");
let num1 = 45;
let num2 = 98;
console.log(num1+num2);
function add(num1,num2){
    console.log(num1+num2);
}
add(10,15);
class Calc{
    add(num1,num2){
        console.log(num1+num2);
    }
    sub(num1,num2){
        console.log(num1-num2);
    }

}
let calc = new Calc();
calc.add(10,35);
calc.sub(45,25);