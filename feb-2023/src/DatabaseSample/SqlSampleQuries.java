package DatabaseSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
username->root
password->""
server address or hostname->127.0.0.1 or localhost
port->3306
database->feb_2023

 */
public class SqlSampleQuries {
    public static void main(String[] args) {
        SqlSampleQuries sample = new SqlSampleQuries();

       // Connection
        //sample.insertRecord();
        //sample.updateRecord();;
        //sample.deleteRecord();
        sample.selectRecord();
        sample.selectCountryRecord();
        //sample.selectRecord();
    }

    public void insertRecord(){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/feb_2023",
//                    "root","");
            //insert the record
            //insert into user(name,email,password,address,dob)value('testname','test@gmail.com','testpassword','testaddress','1991-01-20')
            Statement stmt=this.getConnection().createStatement();
            stmt.execute("insert into user(name,email,address)values('from java','fromjava@gmail.com','fromjavaaddress')");
            this.getConnection().close();
        }catch(Exception e){ System.out.println(e);}
    }
    public void updateRecord(){
        try{

            Statement stmt = this.getConnection().createStatement();
            stmt.execute("update user set email ='updatevalue@gmail@com' where id = 6");
            this.getConnection().close();
        }catch(Exception e){ System.out.println(e);}
    }
    private Connection getConnection()throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feb_2023",
                    "root", "");
            return con;
        }catch (Exception e){
                throw  e;
        }
    }
    public void deleteRecord(){
        try{
            //insert the record
            Statement stmt= this.getConnection().createStatement();
            stmt.execute("delete from user where id = 6");
            this.getConnection().close();
        }catch(Exception e){ System.out.println(e);}
    }
    public void selectRecord(){
        try{

            Statement stmt= this.getConnection().createStatement();
            ResultSet result = stmt.executeQuery("SELECT u.name,u.email,c.name as country_name,u.address FROM user as u join country as c on u.country=c.id");
            while(result.next()){
                System.out.println(result.getString("name")+" "+result.getString("email")+" "+result.getString("country_name"));
            }
            this.getConnection().close();
        }catch(Exception e){ System.out.println(e);}
    }
    public void selectCountryRecord(){
        try{
            Statement stmt=this.getConnection().createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM country");
            while(result.next()){
                System.out.println(result.getString("name"));
            }
            this.getConnection().close();
        }catch(Exception e){ System.out.println(e);}
    }
}
