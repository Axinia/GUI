package general;

import java.util.*;

public class Client extends Om {
    private float buget;
    private final int numarMaximBilete = 5;
    private int numarBilete;
    private ArrayList<Bilet> bilete = new ArrayList<Bilet>();

    public Client(Gen genul, String nume, String prenume, int zi, int luna, int an, CodJudet judet){
        super(genul, nume, prenume, zi, luna, an, judet);
        this.buget = 0;
        this.numarBilete = 0;
    }

    public float getBuget() {
        return buget;
    }

    public void setBuget(float buget) {
        this.buget = buget;
    }

    public boolean adaugaBilet(Bilet b){
        if(numarBilete < 5 && numarBilete > -1) {
            if (this.buget >= b.getPret()) {
                buget = buget - b.getPret();
                bilete.add(b);
                numarBilete++;
                return true;
            }
            else{
                System.out.println("Clientul " + this.getNume() + " " + this.getPrenume()
                        + "(CNP:" + this.getCNP() + ") nu are suma de bani pentru a cumpara biletul"
                        + " cu seria: " + b.getSerie() + ".");
            }
        }
        else{
            System.out.println("Clientul " + this.getNume() + " " + this.getPrenume()
                    + "(CNP:" + this.getCNP() + ") nu poate cumpara mai mult de 5 bilete.");
        }
        return false;
    }
    public void sortareBileteDupaSerie(){
            Collections.sort(bilete);

    }

    public Bilet cautaBiletDupaIndex(int ind){
        if(numarBilete == 0 || ind < 1 || ind > 5)
            return null;
        int i = -1;
        for(Bilet index  : bilete){
            i++;
            if(i ==  ind){
                return index;
            }
        }
        return null;
    }

    public Bilet cautaBiletDupaSerie(String str){
        if(numarBilete == 0)
            return null;

        for(Bilet index  : bilete){
            if( ( index.getSerie() ).equals(str) )
                return index;
        }
        return null;
    }

    public boolean cautaBiletDupaObiect(Bilet b){
        if(numarBilete == 0)
            return false;

        for(Bilet index  : bilete){
            if( (index.getSerie()).equals(b.getSerie()) )
                return true;
        }
        return false;
    }

    public boolean stergeBiletDupaSerie(String str){
        if(numarBilete == 0)
            return false;

        for(Bilet index  : bilete){
            if( ( index.getSerie() ).equals(str) ) {
                this.buget = this.buget + index.getPret();
                bilete.remove(index);
                return true;
            }
        }
        return false;
    }

    public boolean stergeBiletDupaObiect(Bilet b){
        if(numarBilete == 0)
            return false;

        for(Bilet index  : bilete){
            if( ( index.getSerie() ).equals( b.getSerie() ) ) {
                this.buget = this.buget + index.getPret();
                bilete.remove(b);
                return true;
            }
        }
        return false;
    }

    public boolean stergeBiletDupaIndex(int ind){
        if(numarBilete == 0 || ind < 1 || ind > 5)
            return false;
        int i = -1;
        for(Bilet index  : bilete){
            i++;
            if(i ==  ind){
                this.buget = this.buget + index.getPret();
                bilete.remove(index);
            }
        }
        return false;
    }

    public void arataBilete() {
        if (numarBilete == 0){
            System.out.println("Clientul " + this.getNume() + " " + this.getPrenume()
                    + "(CNP:" + this.getCNP() + ") nu are niciun bilet.");
        }
        else{
            System.out.println("Clientul " + this.getNume() + " " + this.getPrenume()
                    + "(CNP:" + this.getCNP() + ") are urmatoarele bilete:");
            for(Bilet index  : bilete){
                System.out.print(index.toString());
            }
        }
    }

    public ArrayList<Bilet> getBilete() {
        return bilete;
    }
}
