/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_Collections_Part_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Oscar Bäck
 * 
 */
public class AnimalInventory {
    
    private BufferedReader in;
    private List<AnimalReport> reports;
    private List<Integer> amounts;
    private List<String> animals;
    private List<String> locations;
    
    public AnimalInventory() throws IOException{
        reports = new ArrayList<>();
        ReadInventory();
        AssignAnimalList();
        
    }
    
    private void ReadInventory() throws FileNotFoundException, IOException{
        String line;
        String filePath = new File("").getAbsolutePath();
        System.out.println(filePath);
        in = new BufferedReader(new FileReader(filePath + "/src/data/amount.txt"));
        
        while((line = in.readLine()) != null){
            //Splits the string and converts to int
            amounts = Arrays.stream(line.replaceAll(" ","").split(",")).map(Integer::parseInt).collect(Collectors.toList());
        }
        
        in = new BufferedReader(new FileReader(filePath + "/src/data/animals.txt"));
        
        while((line = in.readLine()) != null){
            animals = Arrays.asList(line.split(","));
        }
        
        in = new BufferedReader(new FileReader(filePath + "/src/data/country.txt"));
        
        while((line = in.readLine()) != null){
            locations = Arrays.asList(line.split(","));
        }
        
        in.close();
        
    }
    
    private void AssignAnimalList(){
        AnimalReport report;
        for(int i = 0; i < amounts.size(); i++){
            report = new AnimalReport(amounts.get(i),locations.get(i),animals.get(i));
            reports.add(report);
        }
    }
    
    public void DisplayReports(){
        System.out.println("Animal Reports");
        System.out.println("Amount\t\tSpecies\t\tLocation");
        for(AnimalReport report : reports){
            System.out.println(report.getLocation() + ": " + report.getAmount() + " st " + report.getArt());
        }
    }

    public List<AnimalReport> getReports() {
        return reports;
    }
    
    
    
}
