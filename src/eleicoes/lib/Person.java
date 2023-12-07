/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;

import eleicoes.core.Vote2;
import eleicoes.utils.SecurityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
public class Person {
    private String name;
    private String cc;
    private String password;
    private Date dataNasc;
    private String image;
    private String sexo;
    private boolean voted;
    
    private PublicKey pubKey;
    private PrivateKey privKey;    
    private List<Vote2> votos;
    
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
            KeyPair kp = SecurityUtils.generateRSAKeyPair();
            privKey = kp.getPrivate();
            pubKey = kp.getPublic();
            votos = new ArrayList<>();
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
        KeyPair kp = SecurityUtils.generateRSAKeyPair();
        privKey = kp.getPrivate();
        pubKey = kp.getPublic();
        votos = new ArrayList<>();
    }
    
    public Person(String cc, String p, PublicKey pubKey, PrivateKey privKey,List<Vote2> votos) {
        this.cc = cc;
        this.password=p;
        this.pubKey = pubKey;
        this.privKey = privKey;       
        this.votos = votos;
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
    
    
    public void addVote(Vote2 t) throws Exception {
        Files.write(Path.of(getUserFileName(t.getTo())), (t.toText() + "\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(Path.of(getUserFileName(t.getFrom())), (t.toText() + "\n").getBytes(), StandardOpenOption.APPEND);
        votos.add(t);
    }

    @Override
    public String toString() {
        String pub = Base64.getEncoder().encodeToString(pubKey.getEncoded());
        String priv = privKey != null ? Base64.getEncoder().encodeToString(privKey.getEncoded()) : "unknow";        
        String txt = "CC\t: " + cc
                + "\nPub\t: " + pub
                + "\nPrv\t: " + priv
                + "\nVotos \n";
        for (Vote2 v : votos) {
            txt += v.toString() + "\n";
        }
        return txt;

    }

    public static String getUserFileName(String cc) throws Exception {
        return cc + ".user";
    }

    public void save(String password) throws Exception {
        //String fileName = getUserFileName(cc);
        String fileName = "keys" + File.separator + getUserFileName(cc);

        PrintStream out = new PrintStream(new FileOutputStream(fileName));
        out.println(cc);
        out.println(Base64.getEncoder().encodeToString(pubKey.getEncoded()));
        out.println(Base64.getEncoder().encodeToString(SecurityUtils.encrypt(privKey.getEncoded(), password)));
        for (Vote2 v : votos) {
            out.println(v.toText());
        }
        out.close();
    }

    public static Person loadUser(String... params) throws Exception {
        params[0] = getUserFileName(params[0]);
        return load(params);
    }

    /**
     * loads an user from filename
     *
     * @param params array of parameters
     * <br>params[0] - filename (mandatory)
     * <br>params[1] - password (optional)
     *
     * @return User
     * @throws Exception
     */
    private static Person load(String... params) throws Exception {
        String filePath = "keys" + File.separator + params[0];
        Scanner file = new Scanner(new FileInputStream(filePath));
        String cc = file.nextLine();
        String pub = file.nextLine();
        String priv = file.nextLine();
        String pwd = params[1];

        PublicKey pubKey = SecurityUtils.getPublicKey(Base64.getDecoder().decode(pub));
        PrivateKey privKey = null;        
        List<Vote2> votes = new ArrayList<>();
        //try to load keys 
        try {
            privKey = SecurityUtils.getPrivateKey(SecurityUtils.decrypt(Base64.getDecoder().decode(priv), params[1]));            
            while (file.hasNext()) {
                votes.add(Vote2.fromText(file.nextLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Person(cc,pwd,
                SecurityUtils.getPublicKey(Base64.getDecoder().decode(pub)),
                privKey, votes);
    }


    public PublicKey getPubKey() {
        return pubKey;
    }

    public PrivateKey getPrivKey() {
        return privKey;
    } 

    public List<Vote2> getTransactions() {
        return votos;
    }
}
