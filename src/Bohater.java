public class Bohater {
    private final String imie;
    private final int procentZycia;
    private final Typ typ;

    public Bohater(String imie, int procentZycia, Typ typ) {
        this.imie = imie;
        this.procentZycia = procentZycia;
        this.typ = typ;
    }

    public String getImie() {
        return imie;
    }

    public int getProcentZycia() {
        return procentZycia;
    }

    public Typ getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return "Bohater{" +
                "imie='" + imie + '\'' +
                ", procentZycia=" + procentZycia +
                ", typ=" + typ +
                '}';
    }
}