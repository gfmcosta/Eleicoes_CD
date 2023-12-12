/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;

import java.io.Serializable;

/**
 *
 * @author Costa
 */
    public class Candidate implements Serializable{
    private String name;
    private String abv;
    private String image;
  
    /** 
    * Class constructor.
    */
    //Construtor por defeito
    public Candidate(){
        name="";
        abv="";
        image="";
    }
    
    /** 
    * Class constructor with parameters.
    * @param n Candidate name
    * @param a Candidate abbreviation
    * @param i Candidate image folderPath url
    */
    //Construtor com parametros
    public Candidate(String n, String a, String i){
        name=n;
        abv=a;
        image=i;
    }
    
    /** 
    * Class constructor copy.
    * @param t Candidate Object
    */
    //Construtor Cópia
    public Candidate(Candidate t){
        name=t.name;
        abv=t.abv;
        image=t.image;
    }
    
    /** 
    * Get and returns the Candidate Name
    * @return name - candidate Name
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getName() {
        return name;
    }
    
    /** 
    * Set the Candidate Name
    * @param name Candidate name
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setName(String name) {
        this.name = name;
    }
    
    /** 
    * Get and returns the Candidate abreviation
    * @return abv - candidate abvreviation
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getAbv() {
        return abv;
    }

    /** 
    * Set the Candidate Abreviation
    * @param abv Candidate Abreviation String
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setAbv(String abv) {
        this.abv = abv;
    }

     /** 
    * Get and returns the Candidate Image URL
    * @return image - candidate Image URL
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getImage() {
        return image;
    }

    /** 
    * Set the Candidate Image
    * @param image candidate Image folderPath Url
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setImage(String image) {
        this.image = image;
    }
    
    
    public String getInfo() {
        return "Nome:" + name
                + "\nAbreviatura    :" + abv;
    }
    
}
