package general;

public enum CodJudet {
    ALBA("01"), ARAD("02"), ARGES("03"), BACAU("04"), BIHOR("05"), BISTRITA_NASAUD("06"), BOTOSANI("07"),
    BRASOV("08"), BRAILA("09"), BUZAU("10"), CARAS_SEVERIN("11"), CLUJ("12"), CONSTANTA("13"), COVASNA("14"),
    DAMBOVITA("15"), Dolj("16"), GALATI("17"), GORJ("18"), HARGHITA("19"), HUNEDOARA("20"), IALOMITA("21"),
    IASI("22"), ILFOV("23"), MARAMURES("24"), MEHEDINTI("25"), MRUES("26"), NEAMT("27"), OLT("28"), PRAHOVA("29"),
    SATU_MARE("30"), SALAJ("31"), SIBIU("32"), SUCEAVA("33"), TELEORMAN("34"), TIMIS("35"), TULCEA("36"), VASLUI("37"),
    VALCEA("38"), VRANCEA("39"), BUCURESTI("40"), CALARASI("51"), GIURGIU("52");
    private final String cod;
    private CodJudet(String cod){
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }
}
