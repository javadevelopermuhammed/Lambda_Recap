package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {


        List<String> meyve = new ArrayList<>(Arrays.asList("elma","portakal","uzum","cilek","greyfurt","nar",
                "mandalina","armut","elma","keciboynuzu","elma"));

        ilkHarfEVeyaCMethodReferenceYazdir(meyve);
        System.out.println();
        elemanlarinBasinaVeSonunaYildizEkleyerekYazdir(meyve);
        System.out.println();
        icindeEVarsaYazdir(meyve);
        System.out.println();
        lHarfleriniSilYazdir(meyve);
        System.out.println();
        karakterSayisinaGoreKucuktenBuyugeLambdaExpressionYazdir(meyve);
        System.out.println();
        karakterSayisinaGoreBuyuktenKucugeLambdaExpressionYazdir(meyve);
        System.out.println();
        karakterSayisinaGoreBuyuktenKucugeMethodReferenceYazdir(meyve);


    }

    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari, Method References ile aralarında bosluk bırakarak yazdıralım
    public static void ilkHarfEVeyaCMethodReferenceYazdir(List<String> meyve){
        meyve.stream().filter(t->t.startsWith("e") || t.startsWith("c")).forEach(Utils::yazdir);
    }

    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void elemanlarinBasinaVeSonunaYildizEkleyerekYazdir(List<String> meyve){
        meyve.stream().map(t->"*"+t+"*").forEach(Utils::yazdir);
    }

    // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
    public static void icindeEVarsaYazdir(List<String> meyve){
        meyve.stream().filter(t->t.contains("e")).forEach(Utils::yazdir);
    }

    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
    public static void lHarfleriniSilYazdir(List<String> meyve){
        meyve.stream().map(t->t.replace("l","")).forEach(Utils::yazdir);
    }

    // SORU5 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreKucuktenBuyugeLambdaExpressionYazdir(List<String> meyve){
        meyve.stream().sorted(Comparator.comparing(t->t.length())).forEach(Utils::yazdir);
    }

    // SORU5.1 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreBuyuktenKucugeLambdaExpressionYazdir(List<String> meyve){
        meyve.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarini, Method References kullanarak
    // karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreBuyuktenKucugeMethodReferenceYazdir(List<String> meyve){
        meyve.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::yazdir);
    }



}
