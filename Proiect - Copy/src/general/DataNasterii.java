package general;

import exceptions.InvalidDateException;

public class DataNasterii extends Data {
    private final int ziuaNasterii;
    private final int lunaNasterii;
    private final int anulNasterii;
    private boolean isLeapYear;

    public DataNasterii(int day, int month, int year){
        if(year % 4 == 0) {
            isLeapYear = true;
        }
        else {
            isLeapYear = false;
        }
        anulNasterii = year;
        lunaNasterii = month;
        ziuaNasterii = day;
    }

    public int getZiua() {
        return ziua;
    }

    public int getLuna() {
        return luna;
    }

    public int getAnul() {
        return anul;
    }
    public int getAge() {
        int age = anul - anulNasterii - 1; //inca nu stiu daca a fost ziua anul acesta
        boolean isYearValid = true;
        boolean isMonthValid = true;
        boolean isDayValid = true;

        if (anulNasterii >= anul || anulNasterii < 1900)
            isDayValid = false;

        if (lunaNasterii < 1 || lunaNasterii > 12)
            isMonthValid = false;

        if(lunaNasterii == 1               //ianuarie
                || lunaNasterii == 3       //martie
                || lunaNasterii == 5       //mai
                || lunaNasterii == 7       //iulie
                || lunaNasterii == 8       //august
                || lunaNasterii == 10      //octombrie
                || lunaNasterii == 12){    //decembrie

            if(ziuaNasterii < 1 || ziuaNasterii > 31)
                isDayValid = false;

        }
        else if(lunaNasterii == 2){
                if(isLeapYear){
                    if(ziuaNasterii < 1 || ziuaNasterii > 29)
                        isDayValid = false;
                }
                else{
                    if(ziuaNasterii < 1 || ziuaNasterii > 28)
                       isDayValid = false;
                }
        }
        else {
            if(ziuaNasterii < 1 || ziuaNasterii > 30)
                isDayValid = false;
        }

        if(isDayValid && isMonthValid && isYearValid){
            if(lunaNasterii > luna){
                return age;
            }
            if(lunaNasterii < luna){
                return age + 1;
            }
            if(lunaNasterii == luna){
                if(ziuaNasterii <= ziua)
                    return age + 1;
                return age;
            }
        }
        else{
              throw new InvalidDateException("\n\nInvalid Date:\nDay: " + ziuaNasterii + "\nMonth: " + lunaNasterii + "\nYear: " + anulNasterii + "\n");
        }
    return -1;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DataNasterii:\n" +
                "-> ziua = " + ziuaNasterii +
                "\n-> lunaNasterii = " + lunaNasterii +
                "\n-> anulNasterii = " + anulNasterii;
    }

    public int getZiuaNasterii() {
        return ziuaNasterii;
    }

    public int getLunaNasterii() {
        return lunaNasterii;
    }

    public int getAnulNasterii() {
        return anulNasterii;
    }

    public boolean isLeapYear() {
        return isLeapYear;
    }
}
