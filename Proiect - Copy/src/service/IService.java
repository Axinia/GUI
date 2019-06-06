package service;

import general.*;
import java.util.*;
import java.text.*;

public interface IService {
    public Neversea creeazaNeversea(float buget);
    public Untold creeazaUntold(float buget);
    public Set<Client> clientiEveniment(Eveniment ev);
    public Set<Artist> artistiEveniment(Eveniment ev);
    public void vindeBiletVIP(Client cl, Eveniment ev);
    public void vindeBiletStandard(Client cl, Eveniment ev);
    public void angajeazaArtist(Artist ar, Eveniment ev);
}
