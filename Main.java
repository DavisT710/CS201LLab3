package CS201LLab3Completed;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
        String inputFile = "CS201LLab3Completed\\input.txt";
        String outputFile = "CS201LLab3Completed\\output.txt";
        double inputValue;
        double[]x1= new double[40];
        double[]y1= new double[40];
        double[]z1= new double[40]; 
        double[]dist = new double[20]; 
        int count = 0;

        try {
            File file = new File (inputFile);
            Scanner input = new Scanner(file);
            FileWriter output = new FileWriter(outputFile);
            PrintWriter outputForm = new PrintWriter(output);

            //read input file & load the values into an array
            while (input.hasNext()){
                for (int i = 0; i < 6; i++){
                    inputValue = input.nextDouble();
                    switch (i){ 
                    case 0: x1[count] = inputValue;
                            break;
                    case 1: y1[count] = inputValue;
                            break;
                    case 2: z1[count] = inputValue;
                            break;
                    case 3: x1[count+1] = inputValue;
                            break;
                    case 4: y1[count+1] = inputValue;
                            break;
                    case 5: z1[count+1] = inputValue;
                            break;
                    }

                }
                count += 2;
            }  
            //loop through array values and output distance to the output file
            count = 0;
            for (int i = 0; i < x1.length; i +=2){
                dist[count] = Math.pow(( Math.pow((x1[i]-x1[i+1]),2) + 
                                         Math.pow((y1[i]-y1[i+1]),2) + 
                                         Math.pow((z1[i]-z1[i+1]),2)),.5);
                outputForm.printf("%.2f\n", dist[count]);   
                System.out.println(dist[count]);
                count ++;  
            }
            input.close();
            output.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found: " + inputFile);
            return;
        }
        catch (IOException e){
            System.out.println("An error occured during processing");
            return;
        }

    }
    
}
