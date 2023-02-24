package PasswordGenerator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Prosze podac nazwe programu dla ktorego chcesz dostac haslo: ");
        Path path = Paths.get("/Users/jakubignatowicz/Documents/Pass/" + scan.nextLine());
        System.out.print("Prosze podac dlugosc hasla: ");
        int length = scan.nextInt();
        Password pass = new Password(length);
        try {
            Files.writeString(path, pass.getPassword(), StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("Invalid path");
        }
        System.out.println("Wszystko przebieglo pomyslnie :)");

    }
}
