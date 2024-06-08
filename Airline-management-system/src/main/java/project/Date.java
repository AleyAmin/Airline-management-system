package project;

public class Date {

    public Date() {
    }
    
    public int getDay(int date){
        return (date/1000000); 
    }
    public int getMonth(int date){
        date/=10000; 
        return (date%10);
    }
    public int getYear(int date){
        return (date%10000);
    }
    public int CheckIfUpcomingDate(int Currentdate , int date){
        int CurrentDay = getDay(Currentdate);
        int Day = getDay(date);
        int CurrentMonth = getMonth(Currentdate);
        int Month  = getDay(date);
        int CurrentYear = getYear(Currentdate);
        int Year = getYear(date);
        if(CurrentYear > Year)
            return -1;
        else if (CurrentYear == Year){
            if (CurrentMonth > Month)
                return -1;
            else if (CurrentMonth == Month){
                if (CurrentDay > Day)
                    return -1;
                else if (CurrentDay == Day)
                    return -1;
                else 
                    return 0;
            }
        }
        return 1;
    }
}
