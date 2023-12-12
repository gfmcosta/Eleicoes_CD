/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;

import client.Vote;
import eleicoes.utils.SecurityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Costa
 */
public class Person implements Serializable{
    private String name;
    private String cc;
    private String password;
    private Date dataNasc;
    private String image;
    private String sexo;
    private boolean voted;
    
    /** 
    * Class constructor.
    */
    //Construtor por defeito
    public Person(){
        try {
            name="";
            cc="";
            password="";
            voted = false;
            dataNasc=new Date();
            image="";
            sexo="";
        } catch (Exception ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /** 
    * Class constructor with parameters.
    * @param n Person name
    * @param c Person CC
    * @param d Person Birth Date
    * @param i Person image folderPath url
    * @param s Person gender
     * @param v
    */
    //Construtor com parametros
    public Person(String n, String c, Date d,String i, String s, boolean v, String p) throws Exception{
        name=n;
        cc=c;
        password = p;
        voted=v;
        dataNasc=d;
        image= i;
        sexo=s;
    
    }
    
    public Person(String cc, String p) {
        this.cc = cc;
        this.password=p;    
    }
    
    /** 
    * Get and returns the Person Name
    * @return name - person Name
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getName(){
        return name;
    }
    
    /** 
    * Set the Person Name
    * @param n Person name
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setName(String n){
        name= n;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    /** 
    * Get and returns the Person identification
    * @return cc - person cc (identification)
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getCC(){
        return cc;
    }
    
    /** 
    * Set the Person identification
    * @param c Person cc (identification)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setCC(String c){
        cc= c;
    }
    
    /** 
    * Get and returns the voted boolean (if the person has voted or not).
    * @return voted - person voted bool
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public boolean getVoted(){
        return voted;
    }
    
    /** 
    * Set the Person voted boolean
    * @param v Person voted permission
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setVoted(boolean v){
        voted= v;
    }

     /** 
    * Get and returns the person birth date
    * @return dataNasc - Person Birth date
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public Date getDataNasc() {
        return dataNasc;
    }

     /** 
    * Set the Person birth date
    * @param dataNasc Person birth Date (DATE)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    /** 
    * Get and returns the Person image folderPath url
    * @return image - person image url
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getImage() {
        return image;
    }

     /** 
    * Set the Person image folderPath url
    * @param image Person image
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setImage(String image) {
        this.image = image;
    }

    /** 
    * Get and returns the person gender
    * @return sexo - person gender (M or F)
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getSexo() {
        return sexo;
    }

     /** 
    * Set the Person gender sex
    * @param sexo - Person sex (M or F)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /** 
    * Generate a random Person object
    * @param Sexo char sexo to know if the person is male or female (M or F)
    * @param apelidos List of Surnames
    * @param nomes List of names (female or Male depends from gender) 
    * @return x - Person object
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public Person randomPerson(char Sexo, ArrayList<String> apelidos,ArrayList<String> nomes){
            try{
                    String name="";
                    //new Person
                    Person x= new Person();
                    Random r = new Random();
                    //random cc
                    int cc = r.nextInt(99999999-10000000) + 10000000;
                    int ano = r.nextInt(1950, 2004);
                    //random birth date
                    Date data = new Date();
                    Calendar c = Calendar.getInstance();
                    c.setTime(data);
                    c.set(Calendar.YEAR, ano);
                    data=c.getTime();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String dataString = formato.format(data);
                    Date dateF=new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
                    
                    if(Sexo=='M'){
                        String pName = nomes.get(r.nextInt(nomes.size()-1)+1);
                        pName = pName.substring(pName.indexOf(",\""), pName.lastIndexOf("\","));
                        pName = pName.substring(2,pName.length());
                        String pApelido = apelidos.get(r.nextInt(apelidos.size()-1)+1);
                        x = new Person(pName+" "+pApelido,cc+"", data, "/resources/defaultMale.png","M", false,"123");
                        return x;
                    }else{
                        String pName = nomes.get(r.nextInt(nomes.size()-1)+1);
                        pName = pName.substring(pName.indexOf(",\""), pName.lastIndexOf("\","));
                        pName = pName.substring(2,pName.length());
                        String pApelido = apelidos.get(r.nextInt(apelidos.size()-1)+1);
                        x = new Person(pName+" "+pApelido,cc+"", data, "/resources/defaultFemale.png","F", false,"123");
                        return x;
                    }            
            }catch (Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
    }
    
    public String getInfo() {
        return "CC:    " + cc
                + "\nNome    :" + name
                + "\nDataNasc    :" + dataNasc
                + "\nSexo    :" + sexo;
    }
}
