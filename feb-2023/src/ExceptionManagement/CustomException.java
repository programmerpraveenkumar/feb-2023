package ExceptionManagement;

/*
    single point to handle all the error in the project.
    control over the error.based on the error,can take necessary action(send email to developer or writing the log)
 */
public class CustomException extends Exception {
    //constructor method name same as class name
    //constructor is called during the object creation.
    CustomException(String message){
        super(message);//calling the parentclass constructor
    }
}
