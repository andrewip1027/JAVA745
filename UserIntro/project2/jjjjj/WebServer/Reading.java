/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author Jacob Lo
 */
public class Reading implements Serializable {
    private int age;
    private String gender;
    private double weight;
    private double height;

    public Reading(){
        this.age = (int) (Math.random() * ((50 + 40) + 1));
        
        Random r = new Random();
	switch (r.nextInt(3)) {
            case 0:
		this.gender = "North West";
            case 1:
		this.gender = "North East";
            case 2:
		this.gender = "South West";
            case 3:
		this.gender = "South East";
            default:
		this.gender = "South East";	
	}
        
        this.weight = ((Math.random() * ((50 + 40) + 1)) + 50);
        this.height = ((Math.random() * (150 + 1)) + 0);
    }
    
    public Reading(int a, String g, double w, double h){
        this.age = a;
        this.gender = g;
        this.weight = w;
        this.height = h;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public double getHeight(){
        return height;
    }
}