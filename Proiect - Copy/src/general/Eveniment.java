package general;

import java.util.*;
import java.text.*;

public abstract class Eveniment {
    protected ArrayList<BiletStandard> stockBileteStandard = new ArrayList<BiletStandard>();
    protected ArrayList<BiletVIP> stockBileteVIP = new ArrayList<BiletVIP>();
    protected int numarBileteStandard;
    protected int numarBileteVIP;

    protected ArrayList<BiletStandard> bileteStandardVandute = new ArrayList<BiletStandard>();
    protected ArrayList<BiletVIP> bileteVIPVandute = new ArrayList<BiletVIP>();
    protected int numarBileteStandardVandute;
    protected int numarBileteVIPVandute;

    protected Set<Client> clienti = new HashSet<Client>();
    protected Set<Artist> artisti = new HashSet<Artist>();

    public Eveniment(){
        numarBileteStandard = 1000;
        numarBileteVIP = 1000;
        ArrayList <BiletStandard> tickets = new ArrayList<BiletStandard>();

        for(int i = 0; i < 1000; i++){
            BiletStandard b = new BiletStandard();
            tickets.add(b);
        }
        stockBileteStandard = tickets;
        ArrayList<BiletVIP> tickets2 = new ArrayList<BiletVIP>();

        for(int i = 0; i < 1000; i++){
            BiletVIP b = new BiletVIP();
            tickets2.add(b);
        }
        stockBileteVIP = tickets2;
        numarBileteStandardVandute = 0;
        numarBileteVIPVandute = 0;
    }
    public void adaugaArtist(Artist ar) { }
    public void vindeBiletStandard(Client client){ }
    public void vindeBiletVIP(Client client){ }
    public void arataClienti(){ }
    public void arataArtisti(){ }
    public Set<Client> getClienti(){ return null;}
    public Set<Artist> getArtisti(){ return null;}

}
