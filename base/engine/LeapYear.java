package leapyear.base.engine;

public class LeapYear{

 
    public static Boolean calLeapYear(int year){

        if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
            System.out.println("This is a leap year");
            return true;
        }

        else {
            System.out.println("This is not a leap year");
            return false;
        }

    }
  
}
