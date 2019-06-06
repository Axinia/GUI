package general;

public class BiletVIP extends Bilet{
    static int numarBilet = 0;

    public BiletVIP(){
        this.pret = pret + (pret * 85 / 100);
        numarBilet++;
        this.serie = "VIP" + (int)pret + "#T" + numarBilet;
    }

    public int getNumber(){
        return numarBilet;
    }

    public String toString() {
        return "    Bilet VIP      -> " + "pret = " + pret
                + "\n                      serie = \""
                + serie + "\"\n----------------------------------------------\n";
    }
}
