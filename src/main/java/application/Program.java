package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payer: ");
        int n = sc.nextInt();;

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double anualExpenditure = sc.nextDouble();
                list.add(new Individual(name, anualIncome, anualExpenditure));
            } else {
                System.out.print("Number of employees: ");
                int NumberOfemplyees = sc.nextInt();
                list.add(new Company(name, anualIncome, NumberOfemplyees));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");

        for (TaxPayer taxPayer : list) {
            double tax = taxPayer.tax();
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum))  ;

        sc.close();
    }
}
