import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<DemoWindow> hry = new ArrayList<>();
        String separator = "-";
        String soubor = "deskovky.txt";

        try(Scanner sc = new Scanner(
                new BufferedReader(
                    new FileReader(soubor)
                )))
        {
            while (sc.hasNextLine()){
                String[] parametry;
            String line = sc.nextLine();
            parametry = line.split(separator);
           boolean jeZakoupeno;

           if(parametry[1].equals("Ano")){
               jeZakoupeno = true;
           } else if (parametry[1].equals("Ne")) {
               jeZakoupeno = false;
           } else {
               throw new InputMismatchException("Wrong information provided (" + parametry[1] + ").");
           }

                int oblibenost = Integer.parseInt(parametry[2]);
           hry.add(new DemoWindow(parametry[0].trim(),jeZakoupeno,oblibenost));
        }
        }

        catch (FileNotFoundException e){
            System.err.println("File not found.");
        }
        catch (NumberFormatException e){
            System.err.println("Parametr Zakoupeno musí být číslo ("+e+")");
        }
    }
}
