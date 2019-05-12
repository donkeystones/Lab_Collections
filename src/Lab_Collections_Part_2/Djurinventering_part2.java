/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_Collections_Part_2;

import Lab_Collections_Part_1.AnimalInventory;
import Lab_Collections_Part_1.AnimalReport;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Oscar Bäck
 */
public class Djurinventering_part2 {
    private static TreeMap tm;
    private static Scanner scan;
    private static AnimalInventory AI;
    private static boolean running = true;

    public Djurinventering_part2() throws IOException {
        
    }
    
    public static void main(String[]args) throws IOException{
        scan = new Scanner(System.in);
        tm = new TreeMap();
        AI = new AnimalInventory();
        
        AI.getReports().forEach((rep) -> {
            if(tm.containsKey(rep.getArt())){
                tm.put(rep.getArt(),rep.getAmount()+(int)tm.get(rep.getArt()));
            }else{
                tm.put(rep.getArt(), rep.getAmount());
            }
        });
        
        while(running){
            showMenu();
        }
        
    }
    
    private static void showMenu(){
        System.out.println("Animal reporter 2000:");
        System.out.println("1. Search animal.");
        System.out.println("2. Show all animal sorts in total.");
        System.out.println("3. Show indivudial reports.");
        System.out.print("Choice: ");
        
        int choice = Integer.parseInt(scan.nextLine());
        
        switch(choice){
            case 1:
                searchAnimal();
                break;
            case 2:
                showAll();
                break;
            case 3:
                showIndividual();
                break;
            case 4:
                running = false;
                break;
            default:
                System.out.println("Invalid entry... try again!" + "\n\n");
                break;
        }
    }
    
    private static void searchAnimal(){
        System.out.print("Select animal: ");
        String key = scan.nextLine();
        
        if(tm.containsKey(key)){
            System.out.println(key + ", " + tm.get(key) + "\n\n");
        }else{
            System.out.println("No such animal... try again!\n\n");
        }
    }
    
    private static void showAll(){
        Iterator<String> itr = tm.keySet().iterator();
        while(itr.hasNext()){
            System.out.print(itr.next());
            System.out.println(", " + tm.get(itr.next()));
        }
        
        System.out.println("\n\n");
    }
    
    private static void showIndividual(){
        for(AnimalReport rep : AI.getReports()){
            System.out.println(rep.getArt()+", "+rep.getLocation()+", "+rep.getAmount());
        }
        System.out.println("\n\n");
    }
    
}
