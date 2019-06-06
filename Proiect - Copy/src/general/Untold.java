package general;

import exceptions.InstatiationExceededException;
import java.util.*;

public class Untold extends Eveniment{
    private static int count = 0;
    private float buget;
    private float venit;
    private float profit;
    private float cheltuieli;
    private final int varstaMinima = 15;
    private final int durataMaximaShow = 12; // ore
    private int durataCurenta;
    private final int durataMinima = 8; //numarul minim de ore de show pentru a nu se anula evenimentul

    public Untold(float buget){
        this.count++;
        this.buget = buget;
        this.venit = 0;
        this.profit = 0;
        this.cheltuieli = 0;
        this.durataCurenta = 0;
        if(count > 1)
            throw new InstatiationExceededException("Evenimentul Untold nu poate fi instantiat decat o singura data.");
        durataCurenta = 0;
    }

    @Override
    public void adaugaArtist(Artist ar){
        if(this.buget >= ar.getSumaCeruta()){
            if(this.durataCurenta + ar.getPerformingTime() <= this.durataMaximaShow ){
                artisti.add(ar);
                ar.setEveniment(this);
                ar.setIsFree(false);
                this.durataCurenta = this.durataCurenta + ar.getPerformingTime();
                this.buget = this.buget - ar.getSumaCeruta();
                this.cheltuieli = this.cheltuieli + ar.getSumaCeruta();
            }
            else{
                System.out.println("Artistul nu are loc pentru a performa la eveniment.");
            }
        }
        else{
            System.out.println("Suma ceruta de artist depaseste bugetul ramas evenimentului.");
        }
    }
    public boolean areLocEvenimentul(){
        if(durataCurenta >= durataMinima){
            return true;
        }
        return false;
    }

    @Override
    public void vindeBiletVIP(Client client){
        if(numarBileteVIP > 0){
            if(client.getVarsta() >= varstaMinima){
                if(client.adaugaBilet(stockBileteVIP.get(0))){
                    clienti.add(client);
                    venit = venit + (stockBileteVIP.get(0)).getPret();
                    numarBileteVIPVandute++;
                    numarBileteVIP--;
                    bileteVIPVandute.add(stockBileteVIP.get(0));
                    stockBileteVIP.remove(0);
                }
            }
            else{
                System.out.println("Clientul " + client.getNume() + " " + client.getPrenume()
                        + "(CNP:" + client.getCNP() + ") nu are varsta minima pentru a cumpara bilet.");
            }
        }
        else {
            System.out.println("Toate bilete VIP s-au vandut.");
        }
    }

    @Override
    public void vindeBiletStandard(Client client){
        if(numarBileteStandard > 0){
            if(client.getVarsta() >= varstaMinima){
                if(client.adaugaBilet(stockBileteStandard.get(0))){
                    clienti.add(client);
                    venit = venit + (stockBileteStandard.get(0)).getPret();
                    numarBileteStandardVandute++;
                    numarBileteStandard--;
                    bileteStandardVandute.add(stockBileteStandard.get(0));
                    stockBileteStandard.remove(0);
                }
            }
            else{
                System.out.println("Clientul " + client.getNume() + " " + client.getPrenume()
                        + "(CNP:" + client.getCNP() + ") nu are varsta minima pentru a cumpara bilet.");
            }
        }
        else {
            System.out.println("Toate bilete STANDARD s-au vandut.");
        }
    }
    private void setProfit(){
        profit = venit - cheltuieli;
    }

    public float getProfit(){
        this.setProfit();
        return profit;
    }
    public void anulareEveniment(){
        /*
          banii inapoi clientilor fara a cere biletele inapoi
          artistii isi pastreaza banii
         */
        if(this.areLocEvenimentul() == false){
           for(Client index : clienti){
               ArrayList<Bilet> tickets = index.getBilete();
               float bani =  index.getBuget();
               for(Bilet bilet : tickets){
                  bani = bani + bilet.getPret();
               }
               index.setBuget(bani);
           }
           venit = 0;
           for(Artist index : artisti){
               index.setIsFree(true);
           }
        }
    }

    @Override
    public void arataClienti(){
        if(clienti.size() != 0) {
            System.out.println("-----------------------\nUrmatorii clienti au cumparat bilete la Untold:\n");
            for (Client index : clienti) {
                System.out.println("-> " + index.getNume() + " " + index.getPrenume() + ":" + index.getCNP());
            }
        }
        else{
            System.out.println("Evenimentul nu are clienti.");
        }
    }
    @Override
    public void arataArtisti(){
        if(artisti.size() != 0) {
            System.out.println("-----------------------\nUrmatorii artisti vor performa la Untold:\n");
            for (Artist index : artisti) {
                System.out.println("-> " + index.getNume() + " " + index.getPrenume() + ":" + index.getCNP());
            }
        }
        else{
            System.out.println("Evenimentul nu are artisti.");
        }
    }

    @Override
    public Set<Client> getClienti(){
        return clienti;
    }

    @Override
    public Set<Artist> getArtisti(){
        return artisti;
    }

}
