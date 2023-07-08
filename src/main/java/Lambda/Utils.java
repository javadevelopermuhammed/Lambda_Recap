package Lambda;

public class Utils {

    public static boolean ciftVePozitifSayiFiltresi(int num){
        return num % 2 == 0 && num>0;
    }

    public static void yazdir(Object obj){
        System.out.print(obj + " ");
    }
}
