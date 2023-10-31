public class Szkielet {
    private final String imie;

    public Szkielet(String imie) {
        this.imie = "Koscisty(a) " + imie;
    }

    @Override
    public String toString() {
        return "Szkielet{" +
                "imie='" + imie + '\'' +
                '}';
    }

    public String getImie() {
        return imie;
    }
}