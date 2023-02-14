public class ArraySample {
    /*
        having multiple values.
        has to declared by the []{};
        value can be access using the index
        disadvantages:
        1.cannot increase or decrease the size of the array.
        2.data manipulation(sorting,custom sorting) are not easy to implement
        3.So Collection will have advantage over the array.
     */
    public static void main(String[] args) {
        //array
        int numbers[] = {45,25};//array declaration-1.
        int numbers2[] = new int[5];//array declartion-2
        numbers2[0] = 45;
        numbers2[4]=45;
        //numbers2[6]=45;//error index value is greater than size
        String name[] = {"test","test2","test3"};
        System.out.println(numbers[1]);//access the value using index
        System.out.println(name[0]);
        //System.out.println(name[10]);//error and crash the code as the index is not exist
        System.out.println(name[1]);
        System.out.println("---for loop--");
        for(int i = 0;i<numbers.length;i++){
            System.out.println( numbers[i]);
        }
        System.out.println("--2nd for loop--");
        for(int num:numbers){
            System.out.println(num);
        }
        //using classes in the array
        Person[] personAry = new Person[5];
        Person person1 = new Person();
        Person person2 = new Person();
        personAry[0]= person1;
        personAry[1]= person2;
        for(Person personObj:personAry){
            //display the values.
        }
    }

}
