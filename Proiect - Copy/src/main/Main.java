package main;

import frame.AppFrame;
import general.*;
import service.*;
import java.util.*;
import java.text.*;


public class Main {

    public static void main(String[] args) {

       /* Service sv = new Service();

        Neversea neversea = sv.creeazaNeversea(50000);
        Untold untold = sv.creeazaUntold(150000);
        Client client1 = new Client(Gen.MASCULIN, "Popescu","George", 23,4,1998,CodJudet.BACAU);
        Client client2 = new Client(Gen.FEMININ, "Popa", "Ana", 29,2,1996, CodJudet.CONSTANTA);
        Client client3 = new Client(Gen.MASCULIN, "Atanasoaiei", "Paul", 10,3,1998, CodJudet.BACAU);
        Client client4 = new Client(Gen.MASCULIN, "Popa","Andrei", 2,12,2010, CodJudet.CLUJ);

        client1.setBuget(600);
        client2.setBuget(400);
        client3.setBuget(1200);
        client4.setBuget(900);


        Artist artist1 = new Artist(Gen.MASCULIN, "Stoian", "Alex", 7,4,2001,
                CodJudet.SUCEAVA, 50000,3);
        Artist artist2 = new Artist(Gen.MASCULIN, "Stoian", "Alex", 7,4,2001,
                CodJudet.SUCEAVA, 25000,3); // are aceleasi date personale dar cnp ul difera fata de cel de sus
        Artist artist3 = new Artist(Gen.FEMININ, "Carlan", "Maria", 12, 8, 1988,
                CodJudet.CALARASI, 4000, 1);
        Artist artist4 = new Artist(Gen.FEMININ, "Gherman", "Larisa", 31, 8, 1995,
                CodJudet.BOTOSANI,3000,2);
        Artist artist5 = new Artist(Gen.MASCULIN, "Crismaru", "Valentin", 8, 3, 1997,
                CodJudet.BACAU, 5000,4);

        sv.vindeBiletVIP(client1, untold);
        sv.vindeBiletVIP(client1, untold);
        sv.vindeBiletVIP(client2, neversea);
        sv.vindeBiletVIP(client2, untold);
        sv.vindeBiletVIP(client4, untold);
        sv.vindeBiletVIP(client3, neversea);
        sv.vindeBiletVIP(client3, neversea);
        sv.vindeBiletVIP(client1, neversea);

        sv.vindeBiletStandard(client4, untold);
        sv.vindeBiletStandard(client4, neversea);
        sv.vindeBiletStandard(client4, untold);
        sv.vindeBiletStandard(client4, untold);
        sv.vindeBiletStandard(client4, untold);

        sv.angajeazaArtist(artist1, neversea);
        sv.angajeazaArtist(artist2, neversea);
        sv.angajeazaArtist(artist3, untold);
        sv.angajeazaArtist(artist4, untold);
        sv.angajeazaArtist(artist5, neversea);
        sv.angajeazaArtist(artist5, untold);
        sv.angajeazaArtist(artist5, neversea);



        // sv.artistiEveniment(neversea);
         //sv.clientiEveniment(neversea);

         //sv.artistiEveniment(untold);
         //sv.clientiEveniment(untold);
*/
       new AppFrame();

    }
}