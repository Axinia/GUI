package general;

import java.util.Date;
import java.text.*;

public class Data {
    protected int ziua;
    protected int luna;
    protected int anul;

    public Data(){
        Date dateNow = new Date( );
        SimpleDateFormat ft1 = new SimpleDateFormat ("dd");
        SimpleDateFormat ft2= new SimpleDateFormat ("MM");
        SimpleDateFormat ft3 = new SimpleDateFormat ("yyyy");
        String sDay = ft1.format(dateNow);
        String sMonth = ft2.format(dateNow);
        String sYear = ft3.format(dateNow);
        ziua = Integer.parseInt(sDay);
        luna = Integer.parseInt(sMonth);
        anul = Integer.parseInt(sYear);
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
}
