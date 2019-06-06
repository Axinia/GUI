package general;

public class Artist extends Om {

    private final int sumaCeruta;
    private boolean isFree;
    private Eveniment eveniment;
    private final int performingTime; // numar de ore

    public Artist(Gen genul, String nume, String prenume, int zi, int luna, int an, CodJudet judet, int suma, int time){
        super(genul, nume, prenume, zi, luna, an, judet);
        this.sumaCeruta = suma;
        this.isFree = true;
        this.performingTime = time;
    }

    public Eveniment getEveniment() {
        return eveniment;
    }

    public void setEveniment(Eveniment eveniment) {
        this.eveniment = eveniment;
    }

    public int getSumaCeruta() {
        return sumaCeruta;
    }

   public int getPerformingTime() {
        return performingTime;
    }
    public void setIsFree(boolean is){
        this.isFree = is;
    }
}
