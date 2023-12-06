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
//::                                                               (c)2022   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////
package eleicoes.blockchain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created on 22/08/2022, 09:23:49
 * 
 * Block with consensus of Proof of Work
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Block implements Serializable {

    String previousHash; // link to previous block
    String data;         // data in the block
    int nonce;           // proof of work 
    String currentHash;  // Hash of block
    String merkleTreeRoot; //Root of MerkelTree

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public int getNonce() {
        return nonce;
    }

    public String getCurrentHash() {
        return currentHash;
    }


    
    
    public Block(String previousHash, ArrayList data, int nonce) {
        this.previousHash = previousHash;
        this.data = data.toString();
        this.nonce = nonce;
        this.currentHash = calculateHash();
        this.merkleTreeRoot= generateMerkleTree(data);
    }

    public String calculateHash() {
        return Hash.getHash(nonce + previousHash + data);
    }

    public String toString() {
        return // (isValid() ? "OK\t" : "ERROR\t")+
                 String.format("[ %8s", previousHash) + " <- " + 
                   String.format("%-10s", data) +  String.format(" %7d ] = ", nonce) + 
                String.format("%8s",currentHash);

    }

    public boolean isValid() {
        return currentHash.equals(calculateHash());
    }

    private String generateMerkleTree(ArrayList data) {
        MerkleTreeString mk = new MerkleTreeString(data);
        return mk.getRoot();
    }

}
