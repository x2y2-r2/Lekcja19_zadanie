import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Na konsoli ma się pojawic:

//  Bohaterowie ktorych ilosc zycia przekracza 50% to:
//
//  Bohater{imie='Staszek', procentZycia=100, typ=BARBARZYNCA}
//  Bohater{imie='Sabina', procentZycia=55, typ=ZABOJCZYNI}
//  Bohater{imie='Zbyszek', procentZycia=70, typ=NEKROMANTA}
//  Bohater{imie='Katarzyna', procentZycia=80, typ=CZARODZIEJKA}
//  Bohater{imie='Roman', procentZycia=55, typ=DRUID}
//  *****************************
//  Bohaterki to (Amazonka, Zabojczyni, Czarodziejka):
//
//  Bohater{imie='Natasza', procentZycia=10, typ=AMAZONKA}
//  Bohater{imie='Sabina', procentZycia=55, typ=ZABOJCZYNI}
//  Bohater{imie='Katarzyna', procentZycia=80, typ=CZARODZIEJKA}
//  *****************************
//  NEKTORMANTA WKRACZA DO AKCJI!
//  Wszyscy bohaterowie oprócz niego staja sie Szkieletami
//  R.I.P. :
//  Szkielet{imie='Koscisty(a) Staszek'}
//  Szkielet{imie='Koscisty(a) Natasza'}
//  Szkielet{imie='Koscisty(a) Sabina'}
//  Szkielet{imie='Koscisty(a) Roman'}
//  Szkielet{imie='Koscisty(a) Katarzyna'}
//  Szkielet{imie='Koscisty(a) Roman'}
//
//  Nekromanta ma pod swoim wladaniem 6 szkieletow,
//   z czego 5 ma unikatowe imie!
//

public class Main {
    public static void main(String[] args) {

        List<Bohater> bohaterowie = new ArrayList<>();
        bohaterowie.add(new Bohater("Staszek", 100, Typ.BARBARZYNCA));
        bohaterowie.add(new Bohater("Natasza", 10, Typ.AMAZONKA));
        bohaterowie.add(new Bohater("Sabina", 55, Typ.ZABOJCZYNI));
        bohaterowie.add(new Bohater("Zbyszek", 70, Typ.NEKROMANTA));
        bohaterowie.add(new Bohater("Roman", 30, Typ.PALADYN));
        bohaterowie.add(new Bohater("Katarzyna", 80, Typ.CZARODZIEJKA));
        bohaterowie.add(new Bohater("Roman", 55, Typ.DRUID));

        List<Bohater> calkiemZdrowiBohaterowie = new ArrayList<>();
        calkiemZdrowiBohaterowie= bohaterowie.stream()
                .filter(heros -> heros.getProcentZycia() > 50)
                .collect(Collectors.toList());


        wypisywaczkaBohaterow("Bohaterowie ktorych ilosc zycia przekracza 50% to:",
                calkiemZdrowiBohaterowie);

        List<Bohater> bohaterki = new ArrayList<>();
        bohaterki = bohaterowie.stream()
                        .filter(bohater -> bohater.getTyp() == Typ.AMAZONKA || bohater.getTyp() == Typ.CZARODZIEJKA || bohater.getTyp() == Typ.ZABOJCZYNI)
                                .collect(Collectors.toList());

        wypisywaczkaBohaterow("Bohaterki to (Amazonka, Zabojczyni, Czarodziejka):",
                bohaterki);

        System.out.println("NEKTORMANTA WKRACZA DO AKCJI!");
        System.out.println("Wszyscy bohaterowie oprócz niego staja sie Szkieletami");

        System.out.println("R.I.P. :");
        //        Tutaj uzupelnij liste za pomoca streama
        List<Szkielet> szkielety = new ArrayList<>();
        szkielety = bohaterowie.stream()
                .filter(bohater -> bohater.getTyp() != Typ.NEKROMANTA)
                .map(bohater -> new Szkielet(bohater.getImie()))
                .collect(Collectors.toList());

        wypisywaczkaSzkieletow(szkielety);


        System.out.println("\nNekromanta ma pod swoim wladaniem " + szkielety.size() + " szkieletow,");

        long unikatoweImiona = 0;

//        Wylicz za pomoca streama ile Szkieletow ma unikatowe imie
        unikatoweImiona = szkielety.stream()
                .map(szkielet -> szkielet.getImie())
                .distinct()
                .count();


        System.out.println(" z czego " + unikatoweImiona + " ma unikatowe imie!");
    }

    private static void wypisywaczkaSzkieletow(List<Szkielet> szkielety) {
        for (Szkielet szkielet : szkielety) {
            System.out.println(szkielet);
        }
    }

    private static void wypisywaczkaBohaterow(String tekst, List<Bohater> heroski) {
        System.out.println(tekst + "\n");
        for (Bohater bohater : heroski) {
            System.out.println(bohater);
        }
        System.out.println("*****************************");
    }
}