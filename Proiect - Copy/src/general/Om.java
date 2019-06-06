package general;

public abstract class Om {
    private final String nume;
    private final String prenume;
    private final String CNP;
    private final int varsta;
    private final DataNasterii dataNasterii;
    private final Gen gen;
    private final CodJudet judet;
    //ArrayList <Bilet>
    static int numarOm = 0;

    public Om(Gen genul, String nume, String prenume, int zi, int luna, int an, CodJudet judetul) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = new DataNasterii(zi, luna, an);
        this.varsta = dataNasterii.getAge();
        this.gen = genul;
        this.judet = judetul;
        String cnp;
        cnp = "";
        if (genul == Gen.FEMININ){
            cnp = "2";
        }
        else if(genul == Gen.MASCULIN) {
            cnp = "1";
        }
        String aux;
        aux = Integer.toString(an);
        cnp += aux.charAt(2);
        cnp += aux.charAt(3);
        if(luna < 10) {
            cnp = cnp + "0";
        }
        aux = Integer.toString(luna);
        cnp = cnp +  aux;
        if(zi < 10) {
            cnp = cnp + "0";
        }
        aux = Integer.toString(zi);
        cnp = cnp + aux;
        cnp = cnp + judet.getCod();
        aux = "";
        numarOm++;
        int auxNumar = numarOm;
        int index = 0;
        while(auxNumar != 0){
            index++;
            auxNumar /= 10;
        }
        for(int i = 0; i < 4 - index; i++)
            cnp = cnp + "0";
        aux = Integer.toString(numarOm);
        cnp = cnp + aux;
        this.CNP = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getDataNasterii() {
        return dataNasterii.toString();
    }

    public Gen getGen() {
        return gen;
    }

    public CodJudet getJudet() {
        return judet;
    }

    public static int getNumarOm() {
        return numarOm;
    }
}
