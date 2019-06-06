package general;

public enum Gen {
    MASCULIN(1), FEMININ(2);
    private final int prefix;
    private Gen(int prefix){

        this.prefix = prefix;
    }
}
