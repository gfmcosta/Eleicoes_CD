/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;

import eleicoes.blockchain.Block;
import eleicoes.blockchain.BlockChain;
import static eleicoes.blockchain.Converter.objectToByteArray;
import eleicoes.core.Vote2;
import static eleicoes.utils.SecurityUtils.verifySign;
import java.util.ArrayList;
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
    private BlockChain secureLedger;
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
        this.secureLedger = new BlockChain();
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
    
    
    
    
     public BlockChain getSecureLedger(){
        return secureLedger;
    }
      
    public List<Vote2> getLedger() {
        List<Vote2> lst = new ArrayList<>();
        
        for( Block b : secureLedger.getChain()){
            // Remover os colchetes e dividir a string em votos individuais
            String[] votesA = b.getData().substring(1, b.getData().length() - 1).split(",");
            for (String voteString : votesA) {
                try {
                    Vote2 vote = Vote2.fromString(voteString.trim());
                    lst.add(vote);
                } catch (Exception e) {
                    // Tratar exceção, se necessário
                    System.err.println("Erro ao converter voto: " + e.getMessage());
                }
            }
        }
        return lst;
    }
    
    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Vote2 v : getLedger()) {
            txt.append(v.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedger.save(fileName);
    }

    public static Election load(String fileName) throws Exception {
        Election tmp = new Election();
        tmp.secureLedger.load(fileName);
        return tmp;
    }
    
    public void addVoteToBlockChain(Vote2 t) throws Exception {
        
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
    
    public boolean isValid(Vote2 t) throws Exception {
        if (t.getFrom().trim().isEmpty()) {
            throw new Exception("From user is empty");
        }
        if (t.getTo().trim().isEmpty()) {
            throw new Exception("To user is empty");
        }
        //Verificar assinatura
        Vote2 v = new Vote2(t.getFrom(),t.getTo(),null);
        return verifySign(objectToByteArray(v), t.getSignatue(), Global.loggedP.getPubKey());
    }
}

