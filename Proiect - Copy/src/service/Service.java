package service;

import general.*;
import java.util.*;
import java.text.*;

public class Service implements IService {

    public Neversea creeazaNeversea(float buget){
        Neversea n = new Neversea(buget);
        return n;
    }
    public Untold creeazaUntold(float buget){
        Untold u = new Untold(buget);
        return u;
    }

    public Set<Client> clientiEveniment(Eveniment ev){
        //ev.arataClienti();
        return ev.getClienti();
    }
    public Set<Artist> artistiEveniment(Eveniment ev){
        //ev.arataArtisti();
        return ev.getArtisti();
    }

    public void vindeBiletVIP(Client cl, Eveniment ev){
        ev.vindeBiletVIP(cl);
    }

    public void vindeBiletStandard(Client cl, Eveniment ev){
         ev.vindeBiletStandard(cl);
    }

    public void angajeazaArtist(Artist ar, Eveniment ev){
        ev.adaugaArtist(ar);
    }
}
