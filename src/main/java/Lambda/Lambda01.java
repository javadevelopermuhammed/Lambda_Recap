package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
        System.out.println(sayi);
        ciftVePozitifLambdaExpression(sayi);
        System.out.println();
        kareleriYazdir(sayi);
        System.out.println();
        kareleriTekrarsizYazdir(sayi);
        System.out.println();
        buyuktenKucugeYazdir(sayi);
        System.out.println();
        pozitifKupuBesIleBitenleriYazdir(sayi);
        System.out.println();
        toplamiYazdirMethodReference(sayi);
        System.out.println();
        toplamiYazdirLambdaExpression(sayi);
        System.out.println();
        System.out.print(pozitifCarpimLambdaExpression(sayi));
        System.out.println();
        System.out.println(ciftlerinKareleriniKucuktenBuyugeSiralaListOlarakVer(sayi));


    }

    //SORU1: List elemanlarının çift ve pozitif olanlarını, Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifLambdaExpression(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t > 0 && t % 2 == 0).
                forEach(t -> System.out.print(t + " "));
    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını, Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifMethodReference(List<Integer> sayi) {
        sayi.stream().
                filter(Utils::ciftVePozitifSayiFiltresi).
                forEach(Utils::yazdir);
    }

    //SORU3 : List elemanlarının karelerini, aralarında bosluk olacak sekilde yazdırın
    public static void kareleriYazdir(List<Integer> sayi) {
        sayi.
                stream().
                map(t -> t * t).
                forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareleriTekrarsizYazdir(List<Integer> sayi) {
        sayi.
                stream().
                map(t -> t * t).
                distinct().
                forEach(Utils::yazdir);
    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın
    public static void buyuktenKucugeYazdir(List<Integer> sayi) {
        sayi.
                stream().
                sorted(Comparator.reverseOrder()).
                forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız
    public static void pozitifKupuBesIleBitenleriYazdir(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t > 0).
                map(t -> t * t * t).
                filter(t -> t % 10 == 5).
                forEach(Utils::yazdir);
    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
    public static void toplamiYazdirMethodReference(List<Integer> sayi){
        int sonuc = sayi.stream().reduce(Integer::sum).get();
        System.out.print(sonuc);
    }

    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın
    public static void toplamiYazdirLambdaExpression(List<Integer> sayi){
        int sonuc = sayi.stream().reduce(0,(t,u)->t+u);
        System.out.print(sonuc);
    }

    //SORU9 : Listin pozitif elemanlarının, carpımını Lambda Expression ile return ederek yazdırın
    public static int pozitifCarpimLambdaExpression(List<Integer> sayi){
        return sayi.
                stream().
                filter(t->t>0).
                reduce(1,(t,u)->t*u);
    }

    //SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız
    public static List<Integer> ciftlerinKareleriniKucuktenBuyugeSiralaListOlarakVer(List<Integer> sayi){
        return sayi.
                stream().
                filter(t->t%2==0).
                map(t->t*t).
                sorted().
                collect(Collectors.toList());
    }


}
