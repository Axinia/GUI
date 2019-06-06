package general;

public class BiletStandard extends Bilet{
    static int numarBilet = 0;

    public BiletStandard(){
        this.pret = pret;
        numarBilet++;
        this.serie = "STD" + (int)pret + "#T" + numarBilet;
    }

    public int getNumber(){
        return numarBilet;
    }

    public String toString() {
        return "    Bilet Standard -> " + "pret = " + pret
                + "\n                      serie = \""
                + serie + "\"\n----------------------------------------------\n";
    }
}
