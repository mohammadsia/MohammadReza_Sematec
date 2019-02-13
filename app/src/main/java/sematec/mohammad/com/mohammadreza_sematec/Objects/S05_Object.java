package sematec.mohammad.com.mohammadreza_sematec.Objects;

public class S05_Object {

    String FirstName;
    String LastName;
    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }



    public S05_Object (){}
    public S05_Object(String firstName , String lastName){
        FirstName=firstName;
        LastName=lastName;
    }

    public void setName(String name){
        FirstName=name;
    }

    public String getName(){
        return FirstName;
    }





}
