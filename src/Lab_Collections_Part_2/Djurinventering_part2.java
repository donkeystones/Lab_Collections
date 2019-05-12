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
    
    
    private static AnimalInventory AI;

    public Djurinventering_part2() throws IOException {
        
    }
    
    public static void main(String[]args) throws IOException{
        TreeMap tm = new TreeMap();
        AI = new AnimalInventory();
        
        AI.getReports().forEach((rep) -> {
            if(tm.containsKey(rep.getArt())){
                tm.put(rep.getArt(),rep.getAmount()+(int)tm.get(rep.getArt()));
            }else{
                tm.put(rep.getArt(), rep.getAmount());
            }
        });
        
        System.out.println(tm.get("Lejon"));
    }
    
}
