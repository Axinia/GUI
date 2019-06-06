package frame;

import service.Service;
import general.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;


public class AppFrame extends JFrame {

    Service sv = new Service();
    Neversea neversea;
    Untold untold;

    private JFrame fereastra;

    private JPanel [][]p = new JPanel[2][2];
    private JPanel p2 = new JPanel(new GridLayout(2, 2));

    private JButton bUntold;
    private JButton bNeversea;
    private JButton phU = new JButton();
    private JButton phN = new JButton();

    private Icon untoldIcon = new ImageIcon("photos\\logountold.jpg");
    private Icon neverseaIcon = new ImageIcon("photos\\neversea.png");


    JPanel [][]pp = new JPanel[3][3];
    JPanel pp2 = new JPanel(new GridLayout(3, 3));
    JButton poza = new JButton();
    JButton but1 = new JButton("Arata Artisti");
    JButton but2 = new JButton("Arata Clienti");
    JButton but3 = new JButton("Adauga Clienti");
    JButton but4 = new JButton("Inapoi");


    public AppFrame(){
        this.neversea = sv.creeazaNeversea(90000);
        this.untold = sv.creeazaUntold(150000);
        Artist artist1 = new Artist(Gen.MASCULIN, "Stoian", "Alex", 7,4,2001,
                CodJudet.SUCEAVA, 50000,1);
        Artist artist2 = new Artist(Gen.MASCULIN, "Stoian", "Alex", 7,4,2001,
                CodJudet.SUCEAVA, 25000,1); // are aceleasi date personale dar cnp ul difera fata de cel de sus
        Artist artist3 = new Artist(Gen.FEMININ, "Carlan", "Maria", 12, 8, 1988,
                CodJudet.CALARASI, 4000, 1);
        Artist artist4 = new Artist(Gen.FEMININ, "Gherman", "Larisa", 31, 8, 1995,
                CodJudet.BOTOSANI,3000,1);
        Artist artist5 = new Artist(Gen.MASCULIN, "Crismaru", "Valentin", 8, 3, 1997,
                CodJudet.BACAU, 5000,1);

        sv.angajeazaArtist(artist1, neversea);
        sv.angajeazaArtist(artist2, neversea);
        sv.angajeazaArtist(artist3, untold);
        sv.angajeazaArtist(artist4, untold);
        sv.angajeazaArtist(artist5, neversea);
        sv.angajeazaArtist(artist5, untold);
        sv.angajeazaArtist(artist5, neversea);

        gui();

    }

    public void gui()  {
        fereastra = new JFrame("Vanzare Bilete");
        fereastra.setVisible(true);
        fereastra.setSize(600,400);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.getContentPane().setBackground(Color.BLACK);

        p[0][0] = new JPanel();
        p[0][1] = new JPanel();
        p[1][0] = new JPanel();
        p[1][1] = new JPanel();

        p[0][1].setBackground(Color.BLACK);
        p[1][0].setBackground(Color.BLACK);
        p[0][0].setBackground(Color.BLACK);
        p[1][1].setBackground(Color.BLACK);

        bUntold = new JButton("Untold");
        phU.setIcon(untoldIcon);
        phU.setPreferredSize(new Dimension(150, 150));


        bNeversea = new JButton("Neversea");
        phN.setIcon(neverseaIcon);
        phN.setPreferredSize(new Dimension(150, 150));


        p[0][0].add(phU);
        p[1][0].add(bUntold);
        p[0][1].add(phN);
        p[1][1].add(bNeversea);

        p2.add(p[0][0]);
        p2.add(p[0][1]);
        p2.add(p[1][0]);
        p2.add(p[1][1]);
        fereastra.add(p2, BorderLayout.CENTER);

        bUntold.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fereastra.removeAll();
                fereastra.dispose();

                fereastra = new JFrame("Untold");
                fereastra.setVisible(true);
                fereastra.setSize(800,500);
                fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fereastra.getContentPane().setBackground(Color.BLACK);

                pp = new JPanel[3][3];
                pp2 = new JPanel(new GridLayout(3, 3));
                poza.setIcon(untoldIcon);
                poza.setPreferredSize(new Dimension(150, 150));

                for(int i = 0; i < 3; i++)
                    for(int j = 0; j < 3; j++) {
                        pp[i][j] = new JPanel();
                        pp[i][j].setBackground(Color.BLACK);
                    }

                pp[0][1].add(poza);
                pp[2][0].add(but1);
                pp[2][1].add(but2);
                pp[2][2].add(but3);
                pp[1][1].add(but4);

                pp2.add(pp[0][0]);
                pp2.add(pp[0][1]);
                pp2.add(pp[0][2]);
                pp2.add(pp[1][0]);
                pp2.add(pp[1][1]);
                pp2.add(pp[1][2]);
                pp2.add(pp[2][0]);
                pp2.add(pp[2][1]);
                pp2.add(pp[2][2]);

                fereastra.add(pp2, BorderLayout.CENTER);

                but4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        homeFrame();

                    }
                } );


                but3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        newClientUntold();

                    }
                } );

                but2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        Set<Client> setClienti = sv.clientiEveniment(untold);
                        int length = setClienti.size();

                        JPanel [][]tabel = new JPanel[length][4];
                        JPanel panel2 = new JPanel(new GridLayout(length, 4));
                        JButton back = new JButton("Inapoi");


                        JFrame fr = new JFrame("Clienti");
                        fr.setVisible(true);
                        fr.setSize(1200,600);
                        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fr.getContentPane().setBackground(Color.BLACK);

                        String[] columns = {"Nume", "Prenume","Varsta","CNP"};
                        String [][]date = new String[length][4];

                        int index = 0;
                        for (Client s : setClienti) {
                            date[index][0] = s.getNume();
                            date[index][1] = s.getPrenume();
                            String aux = Integer.toString(s.getVarsta());
                            date[index][2] = aux;
                            date[index][3] = s.getCNP();
                            index++;
                        }

                        JTable jt = new JTable(date, columns);
                        jt.setPreferredScrollableViewportSize(new Dimension(500,70));
                        jt.setFillsViewportHeight(true);

                        JScrollPane jps = new JScrollPane(jt);

                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){

                                fr.dispose();
                                homeFrame();

                            }
                        } );

                        fr.add(jps);
                        fr.add(back, BorderLayout.SOUTH);


                    }
                } );

                but1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        Set<Artist> setArtisti = sv.artistiEveniment(untold);
                        int length = setArtisti.size();

                        JPanel [][]tabel = new JPanel[length][4];
                        JPanel panel2 = new JPanel(new GridLayout(length, 4));
                        JButton back = new JButton("Inapoi");


                        JFrame fr = new JFrame("Artisti");
                        fr.setVisible(true);
                        fr.setSize(1200,600);
                        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fr.getContentPane().setBackground(Color.BLACK);

                        String[] columns = {"Nume", "Prenume","Varsta","CNP"};
                        String [][]date = new String[length][4];

                        int index = 0;
                        for (Artist s : setArtisti) {
                            date[index][0] = s.getNume();
                            date[index][1] = s.getPrenume();
                            String aux = Integer.toString(s.getVarsta());
                            date[index][2] = aux;
                            date[index][3] = s.getCNP();
                            index++;
                        }

                        JTable jt = new JTable(date, columns);
                        jt.setPreferredScrollableViewportSize(new Dimension(500,70));
                        jt.setFillsViewportHeight(true);

                        JScrollPane jps = new JScrollPane(jt);
                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){

                                fr.dispose();
                                homeFrame();

                            }
                        } );

                        fr.add(jps);
                        fr.add(back, BorderLayout.SOUTH);

                    }
                } );
            }
        } );

        bNeversea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fereastra.removeAll();
                fereastra.dispose();

                fereastra = new JFrame("Neversea");
                fereastra.setVisible(true);
                fereastra.setSize(800,500);
                fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fereastra.getContentPane().setBackground(Color.BLACK);

                pp = new JPanel[3][3];
                pp2 = new JPanel(new GridLayout(3, 3));
                poza.setIcon(neverseaIcon);
                poza.setPreferredSize(new Dimension(150, 150));

                for(int i = 0; i < 3; i++)
                    for(int j = 0; j < 3; j++) {
                        pp[i][j] = new JPanel();
                        pp[i][j].setBackground(Color.BLACK);
                    }

                pp[0][1].add(poza);
                pp[2][0].add(but1);
                pp[2][1].add(but2);
                pp[2][2].add(but3);
                pp[1][1].add(but4);

                pp2.add(pp[0][0]);
                pp2.add(pp[0][1]);
                pp2.add(pp[0][2]);
                pp2.add(pp[1][0]);
                pp2.add(pp[1][1]);
                pp2.add(pp[1][2]);
                pp2.add(pp[2][0]);
                pp2.add(pp[2][1]);
                pp2.add(pp[2][2]);

                fereastra.add(pp2, BorderLayout.CENTER);

                but4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        homeFrame();

                    }
                } );

                but3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                       newClient();

                    }
                } );

                but2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        Set<Client> setClienti = sv.clientiEveniment(neversea);
                        int length = setClienti.size();

                        JPanel [][]tabel = new JPanel[length][4];
                        JPanel panel2 = new JPanel(new GridLayout(length, 4));
                        JButton back = new JButton("Inapoi");


                        JFrame fr = new JFrame("Clienti");
                        fr.setVisible(true);
                        fr.setSize(1200,600);
                        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fr.getContentPane().setBackground(Color.BLACK);

                        String[] columns = {"Nume", "Prenume","Varsta","CNP"};
                        String [][]date = new String[length][4];

                        int index = 0;
                        for (Client s : setClienti) {
                            date[index][0] = s.getNume();
                            date[index][1] = s.getPrenume();
                            String aux = Integer.toString(s.getVarsta());
                            date[index][2] = aux;
                            date[index][3] = s.getCNP();
                            index++;
                        }

                        JTable jt = new JTable(date, columns);
                        jt.setPreferredScrollableViewportSize(new Dimension(500,70));
                        jt.setFillsViewportHeight(true);

                        JScrollPane jps = new JScrollPane(jt);

                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){

                                fr.dispose();
                                homeFrame();

                            }
                        } );

                        fr.add(jps);
                        fr.add(back, BorderLayout.SOUTH);


                    }
                } );

                but1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){

                        Set<Artist> setArtisti = sv.artistiEveniment(neversea);
                        int length = setArtisti.size();

                        JPanel [][]tabel = new JPanel[length][4];
                        JPanel panel2 = new JPanel(new GridLayout(length, 4));
                        JButton back = new JButton("Inapoi");


                        JFrame fr = new JFrame("Artisti");
                        fr.setVisible(true);
                        fr.setSize(1200,600);
                        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        fr.getContentPane().setBackground(Color.BLACK);

                        String[] columns = {"Nume", "Prenume","Varsta","CNP"};
                        String [][]date = new String[length][4];

                        int index = 0;
                        for (Artist s : setArtisti) {
                            date[index][0] = s.getNume();
                            date[index][1] = s.getPrenume();
                            String aux = Integer.toString(s.getVarsta());
                            date[index][2] = aux;
                            date[index][3] = s.getCNP();
                            index++;
                        }

                        JTable jt = new JTable(date, columns);
                        jt.setPreferredScrollableViewportSize(new Dimension(500,70));
                        jt.setFillsViewportHeight(true);

                        JScrollPane jps = new JScrollPane(jt);
                        back.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){

                                fr.dispose();
                                homeFrame();

                            }
                        } );

                        fr.add(jps);
                        fr.add(back, BorderLayout.SOUTH);

                    }
                } );

            }
        } );

    }

    public void homeFrame(){
        fereastra.removeAll();
        fereastra.dispose();
        fereastra = new JFrame("Vanzare Bilete");
        fereastra.setVisible(true);
        fereastra.setSize(600,400);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.getContentPane().setBackground(Color.BLACK);


        fereastra.add(p2, BorderLayout.CENTER);

    }

    public void newClient(){
        JFrame fr;
        fr = new JFrame("Adauga Client");
        fr.setVisible(true);
        fr.setSize(900,700);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.getContentPane().setBackground(Color.BLACK);

        JButton biletstd = new JButton("Bilet Standard");
        JButton biletvip = new JButton("Bilet VIP");

        JLabel gen = new JLabel("Gen:");
        JLabel nume = new JLabel("Nume:");
        JLabel prenume = new JLabel("Prenume:");
        JLabel ziua = new JLabel("Ziua Nasterii:");
        JLabel luna = new JLabel("Luna Nasterii:");
        JLabel anul = new JLabel("Anul Nasterii:");
        JLabel judetul = new JLabel("Judetul:");

        JTextField textGen = new JTextField(20); //doar cu majuscule
        JTextField textNume = new JTextField(20);
        JTextField textPrenume = new JTextField(20);
        JTextField textZiua = new JTextField(20);
        JTextField textLuna = new JTextField(20);
        JTextField textAnul = new JTextField(20);
        JTextField textJud = new JTextField(20); //majuscule


        gen.setForeground(Color.WHITE);
        nume.setForeground(Color.WHITE);
        prenume.setForeground(Color.WHITE);
        ziua.setForeground(Color.WHITE);
        luna.setForeground(Color.WHITE);
        anul.setForeground(Color.WHITE);
        judetul.setForeground(Color.WHITE);


        JPanel [][]panel = new JPanel[8][2];
        JPanel panel2 = new JPanel(new GridLayout(8, 2));
        JButton back = new JButton("Inapoi");


        for(int i = 0; i < 8; ++i){
            panel[i][0] = new JPanel();
            panel[i][1] = new JPanel();
            panel[i][0].setBackground(Color.BLACK);
            panel[i][1].setBackground(Color.BLACK);
        }



        biletstd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textGen2 = textGen.getText();
                String textNume2 = textNume.getText();
                String textPrenume2 = textPrenume.getText();
                String textZiua2 = textZiua.getText();
                String textLuna2 = textLuna.getText();
                String textAnul2 = textAnul.getText();
                String textJud2 = textJud.getText();


                int ziua = Integer.parseInt(textZiua2);
                int luna = Integer.parseInt(textLuna2);
                int anul = Integer.parseInt(textAnul2);

                Gen g = Gen.valueOf(textGen2);
                CodJudet c = CodJudet.valueOf(textJud2);

                Client cl =  new Client(g,textNume2,textPrenume2,ziua,luna,anul,c);
                cl.setBuget(1500);
                sv.vindeBiletStandard(cl, neversea);
                fr.dispose();
            }
        });

        biletvip.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textGen2 = textGen.getText();
                String textNume2 = textNume.getText();
                String textPrenume2 = textPrenume.getText();
                String textZiua2 = textZiua.getText();
                String textLuna2 = textLuna.getText();
                String textAnul2 = textAnul.getText();
                String textJud2 = textJud.getText();


                int ziua = Integer.parseInt(textZiua2);
                int luna = Integer.parseInt(textLuna2);
                int anul = Integer.parseInt(textAnul2);

                Gen g = Gen.valueOf(textGen2);
                CodJudet c = CodJudet.valueOf(textJud2);

                Client cl =  new Client(g,textNume2,textPrenume2,ziua,luna,anul,c);
                cl.setBuget(1500);
                sv.vindeBiletVIP(cl, neversea);
                fr.dispose();
            }
        });


        panel[0][0].add(gen);
        panel[1][0].add(nume);
        panel[2][0].add(prenume);
        panel[3][0].add(ziua);
        panel[4][0].add(luna);
        panel[5][0].add(anul);
        panel[6][0].add(judetul);
        panel[7][0].add(biletstd);

        panel[0][1].add(textGen);
        panel[1][1].add(textNume);
        panel[2][1].add(textPrenume);
        panel[3][1].add(textZiua);
        panel[4][1].add(textLuna);
        panel[5][1].add(textAnul);
        panel[6][1].add(textJud);
        panel[7][1].add(biletvip);


        for(int i = 0; i < 8; ++i){
            panel2.add(panel[i][0]);
            panel2.add(panel[i][1]);
        }

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                fr.dispose();
                homeFrame();

            }
        } );
        fr.add(panel2, BorderLayout.CENTER);
        fr.add(back, BorderLayout.SOUTH);

    }

    public void newClientUntold(){
        JFrame fr;
        fr = new JFrame("Adauga Client");
        fr.setVisible(true);
        fr.setSize(900,700);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.getContentPane().setBackground(Color.BLACK);

        JButton biletstd = new JButton("Bilet Standard");
        JButton biletvip = new JButton("Bilet VIP");

        JLabel gen = new JLabel("Gen:");
        JLabel nume = new JLabel("Nume:");
        JLabel prenume = new JLabel("Prenume:");
        JLabel ziua = new JLabel("Ziua Nasterii:");
        JLabel luna = new JLabel("Luna Nasterii:");
        JLabel anul = new JLabel("Anul Nasterii:");
        JLabel judetul = new JLabel("Judetul:");

        JTextField textGen = new JTextField(20); //doar cu majuscule
        JTextField textNume = new JTextField(20);
        JTextField textPrenume = new JTextField(20);
        JTextField textZiua = new JTextField(20);
        JTextField textLuna = new JTextField(20);
        JTextField textAnul = new JTextField(20);
        JTextField textJud = new JTextField(20); //majuscule


        gen.setForeground(Color.WHITE);
        nume.setForeground(Color.WHITE);
        prenume.setForeground(Color.WHITE);
        ziua.setForeground(Color.WHITE);
        luna.setForeground(Color.WHITE);
        anul.setForeground(Color.WHITE);
        judetul.setForeground(Color.WHITE);


        JPanel [][]panel = new JPanel[8][2];
        JPanel panel2 = new JPanel(new GridLayout(8, 2));
        JButton back = new JButton("Inapoi");


        for(int i = 0; i < 8; ++i){
            panel[i][0] = new JPanel();
            panel[i][1] = new JPanel();
            panel[i][0].setBackground(Color.BLACK);
            panel[i][1].setBackground(Color.BLACK);
        }



        biletstd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textGen2 = textGen.getText();
                String textNume2 = textNume.getText();
                String textPrenume2 = textPrenume.getText();
                String textZiua2 = textZiua.getText();
                String textLuna2 = textLuna.getText();
                String textAnul2 = textAnul.getText();
                String textJud2 = textJud.getText();


                int ziua = Integer.parseInt(textZiua2);
                int luna = Integer.parseInt(textLuna2);
                int anul = Integer.parseInt(textAnul2);

                Gen g = Gen.valueOf(textGen2);
                CodJudet c = CodJudet.valueOf(textJud2);

                Client cl =  new Client(g,textNume2,textPrenume2,ziua,luna,anul,c);
                cl.setBuget(1500);
                sv.vindeBiletStandard(cl, untold);
                fr.dispose();
            }
        });

        biletvip.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textGen2 = textGen.getText();
                String textNume2 = textNume.getText();
                String textPrenume2 = textPrenume.getText();
                String textZiua2 = textZiua.getText();
                String textLuna2 = textLuna.getText();
                String textAnul2 = textAnul.getText();
                String textJud2 = textJud.getText();


                int ziua = Integer.parseInt(textZiua2);
                int luna = Integer.parseInt(textLuna2);
                int anul = Integer.parseInt(textAnul2);

                Gen g = Gen.valueOf(textGen2);
                CodJudet c = CodJudet.valueOf(textJud2);

                Client cl =  new Client(g,textNume2,textPrenume2,ziua,luna,anul,c);
                cl.setBuget(1500);
                sv.vindeBiletVIP(cl, untold);
                fr.dispose();
            }
        });


        panel[0][0].add(gen);
        panel[1][0].add(nume);
        panel[2][0].add(prenume);
        panel[3][0].add(ziua);
        panel[4][0].add(luna);
        panel[5][0].add(anul);
        panel[6][0].add(judetul);
        panel[7][0].add(biletstd);

        panel[0][1].add(textGen);
        panel[1][1].add(textNume);
        panel[2][1].add(textPrenume);
        panel[3][1].add(textZiua);
        panel[4][1].add(textLuna);
        panel[5][1].add(textAnul);
        panel[6][1].add(textJud);
        panel[7][1].add(biletvip);


        for(int i = 0; i < 8; ++i){
            panel2.add(panel[i][0]);
            panel2.add(panel[i][1]);
        }

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                fr.dispose();
                homeFrame();

            }
        } );
        fr.add(panel2, BorderLayout.CENTER);
        fr.add(back, BorderLayout.SOUTH);

    }

}
