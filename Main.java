package CS201LLab3Base;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        //define variables & arrays
        //create 6 arrays for input values
        final int SIZE = 20; // Number of values per coordinate line
        double[] x1 = new double[SIZE];
        double[] y1 = new double[SIZE];
        double[] z1 = new double[SIZE];
        double[] x2 = new double[SIZE];
        double[] y2 = new double[SIZE];
        double[] z2 = new double[SIZE];
        double[] distances = new double[SIZE];

        try {
            //establish File, Scanner, FileWriter and PrintWriter objects
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            FileWriter fileWriter = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //read input file & load the values into the arrays created for input values
            for (int i = 0; i < SIZE; i++) {
                x1[i] = scanner.nextDouble();
            }
            for (int i = 0; i < SIZE; i++) {
                y1[i] = scanner.nextDouble();
            }
            for (int i = 0; i < SIZE; i++) {
                z1[i] = scanner.nextDouble();
            }
            for (int i = 0; i < SIZE; i++) {
                x2[i] = scanner.nextDouble();
            }
            for (int i = 0; i < SIZE; i++) {
                y2[i] = scanner.nextDouble();
            }
            for (int i = 0; i < SIZE; i++) {
                z2[i] = scanner.nextDouble();
            }

            //loop through array values and output distance to the output file
            for (int i = 0; i < SIZE; i++) {
                distances[i] = Math.sqrt(
                    Math.pow(x2[i] - x1[i], 2) +
                    Math.pow(y2[i] - y1[i], 2) +
                    Math.pow(z2[i] - z1[i], 2)
                );
                // Print to file with 3 decimal places
                printWriter.printf("Distance %d: %.2f%n", i + 1, distances[i]);
            }

            //close the files
            scanner.close();
            printWriter.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
        catch (IOException e){
            System.out.println("An error occurred during processing");
            return;
        }

    }

}
