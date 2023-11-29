//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2020   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eleicoes.core;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import eleicoes.blockchain.Block;
import eleicoes.blockchain.BlockChain;

/**
 *
 * @author manso
 */
public class ElectionBC implements Serializable {

   // private List<Transaction> ledger;
    private BlockChain secureLedger;
    public int dificulty = 4;
    
    public BlockChain getSecureLedger(){
        return secureLedger;
    }
    

    public ElectionBC() {
        secureLedger = new BlockChain();
       // ledger = new ArrayList<>();        
    }

    public List<Vote> getLedger() {
        List<Vote> lst = new ArrayList<>();
        
        for( Block b : secureLedger.getChain()){
            lst.add( Vote.fromText(b.getData()));
        }
        return lst;
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Vote v : getLedger()) {
            txt.append(v.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        secureLedger.save(fileName);
//        try (PrintStream out = new PrintStream(
//                new FileOutputStream(fileName))) {
//            out.print(this.toString());
//        }
    }

    public static ElectionBC load(String fileName) throws Exception {
        ElectionBC tmp = new ElectionBC();
        tmp.secureLedger.load(fileName);
        return tmp;
    }

    
/*
    public boolean isValid(Vote t) throws Exception {
        if (t.getValue() <= 0) {
            throw new Exception("Value " + t.getValue() + " is invalid");
        }
        if (t.getFrom().trim().isEmpty()) {
            throw new Exception("From user is empty");
        }
        if (t.getTo().trim().isEmpty()) {
            throw new Exception("To user is empty");
        }
        double value = getAmount(t.getFrom());
        if (t.getValue() > value) {
            throw new Exception(t.getFrom() + " not have founds \n"
                    + t.getValue() + " is larger than " + value);
        }
        return t.getValue() <= value;
    }
*/

    public void add(Vote t) throws Exception {
        //if (isValid(t)) {
        if (true){
            secureLedger.add(t.toText(),dificulty);
        } else {
            throw new Exception("Transaction not valid");
        }
    }

/*
    public List<String> getUsersBalance() {
        List<String> users = new ArrayList<>();
        //get Users
        for (Vote transaction : getLedger()) {
            if (!users.contains(transaction.getFrom())) {
                users.add(transaction.getFrom());
            }
            if (!users.contains(transaction.getTo())) {
                users.add(transaction.getTo());
            }
        }
        //get amount of users
        ArrayList<String> balance = new ArrayList<>();
        for (String user : users) {
            balance.add(String.format(Locale.ENGLISH,"%-15s %20.8f", user,getAmount(user)));
        }
        return balance;
    }
*/

}
