/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;


import distributedMiner.blockchain.Candidate;
import client.Vote;
import static distributedMiner.utils.Converter.objectToByteArray;
import static eleicoes.utils.SecurityUtils.verifySign;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Costa
 */
public class Election {
    String name;
    Date dataI;
    Date dataF;
    String image;
    ArrayList<Person> elector;
    ArrayList<Candidate> candidate;
    ArrayList<String> votes;
    boolean finished;
    public int dificulty = 1;
    

    public Election() {
        this.name = "";
        this.dataI = new Date();
        this.dataF = new Date();
        this.image = "";
        this.elector = new ArrayList<>();
        this.candidate = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.finished = false;
    }

    /**
     * Get and returns an array of electors
     * @return elector - elector array
     */
    // Encapsulamento -- Acesso aos atributos (GET)
    public ArrayList<Person> getElector() {
        return elector;
    }

    /** 
    * Set an array of electors
    * @param elector an array of persons
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setElector(ArrayList<Person> elector) {
        this.elector = elector;
    }

    /** 
    * Get and returns an array of candidates
    * @return candidate - candidate array
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public ArrayList<Candidate> getCandidate() {
        return candidate;
    }
    
    /** 
    * Get and returns a boolean (specify if the election is closed or not)
    * @return finished - boolean permission for finished election
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public boolean isFinished() {
        return finished;
    }

    /** 
    * Set if election is finished or not
    * @param finished a value to control election status (open/closed)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /** 
    * Set an array of candidates
    * @param candidate an array of candidates
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setCandidate(ArrayList<Candidate> candidate) {
        this.candidate = candidate;
    }
    
    /** 
    * Add a Candidate to Candidate array
    * @param c Candidate object
    */
    public void addListCandidate(Candidate c) {
        this.candidate.add(c);
    }
    
    /** 
    * Add a Person to Electors array
    * @param p Person object
    */
    public void addListElector(Person p) {
        this.elector.add(p);
    }
    
    /** 
    * Add the person vote to Votes List
    * @param v Candidate abreviation
    */
    public void addListVotes(String v) {
        this.votes.add(v);
    }
    
    /** 
    * Get and returns the Election Name
    * @return name - election Name
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getName() {
        return name;
    }

    /** 
    * Set the Election Name
    * @param name Election name
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setName(String name) {
        this.name = name;
    }

    /** 
    * Get and returns the Election initial date
    * @return dataI - election initial date
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public Date getDataI() {
        return dataI;
    }

    /** 
    * Set the Election inicial date
    * @param dataI initial date (DATE)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    /** 
    * Get and returns the Election final date
    * @return dataF - election final date
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public Date getDataF() {
        return dataF;
    }

    /** 
    * Set the Election final date
    * @param dataF final date (DATE)
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }

    /** 
    * Get and returns the Election image folderPath Url
    * @return image - image url
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public String getImage() {
        return image;
    }

    /** 
    * Set the Election image folderPath url
    * @param image image url
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setImage(String image) {
        this.image = image;
    }

    /** 
    * Get and returns the Votes array
    * @return votes - Votes array
    */
    // Encapsulamento -- Acesso aos atributos (GET)
    public ArrayList<String> getVotes() {
        return votes;
    }

    /** 
    * Set the Votes array
    * @param votes votes array
    */
    // Encapsulamento -- Acesso aos atributos (SET)
    public void setVotes(ArrayList<String> votes) {
        this.votes = votes;
    }
 
    public void addVoteToBlockChain(Vote t) throws Exception {
        
        if (isValid(t)) {
            //secureLedger.add(t,dificulty);
            try {
               Global.remote.addTransaction(t.toText());
            } catch (Exception ex) {
                System.out.println("Add Transaction "+ ex);
            }
        } else {
            throw new Exception("Vote not valid");
            
        }
    }
    
    public boolean isValid(Vote t) throws Exception {
        if (t.getFrom().trim().isEmpty()) {
            throw new Exception("From user is empty");
        }
        if (t.getTo().trim().isEmpty()) {
            throw new Exception("To user is empty");
        }
        //Verificar assinatura
        Vote v = new Vote(t.getFrom(),t.getTo());
        
        // Assumindo que assinaturaString é a String da assinatura recebida
        byte[] assinatura = Base64.getDecoder().decode(t.getSign());

        return verifySign(objectToByteArray(v), assinatura, Global.loggedP.getPubKey());
    }
}

