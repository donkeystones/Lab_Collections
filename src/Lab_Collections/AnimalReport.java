/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab_Collections;

/**
 *
 * @author Oscar Bäck
 */
public class AnimalReport {
    
    private int amount;
    private String location, art;
    
    public AnimalReport(){
        amount = 0;
        location = "";
        art = "";
    }

    public AnimalReport(int _amount,String _location, String _art){
        amount = _amount;
        location = _location;
        art = _art;
    }

    public int getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    public String getArt() {
        return art;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setArt(String art) {
        this.art = art;
    }
    
    
    
}
