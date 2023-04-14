class Parent1{
    message(){
        console.log("this is sample message")
    }
}
interface SampleIntr{
    message():string;
}
class SampleName extends Parent1 implements SampleIntr{
    message(): string {
        return "sample messaeg";
    }

}
let sample = new SampleName();
console.log(sample.message());