package general;

public abstract class Bilet implements Comparable<Bilet> {
    float pret;
    protected String serie;

    public Bilet(){
        pret = 200;
    }

    public float getPret() {
        return pret;
    }

    public String getSerie() {
        return serie;
    }

    @Override
    public int compareTo(Bilet b) {

        return (this.serie).compareTo(b.getSerie());

    }
}
