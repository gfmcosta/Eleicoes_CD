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
package eleicoes.core;

import java.io.Serializable;
import java.util.Locale;
import eleicoes.blockchain.Converter;
import java.util.Arrays;
import java.util.Base64;

/**
 *
 * @author manso
 */
public class Vote2 implements Serializable {

    private String from;
    private String to;
    private byte[] signature;

    public Vote2(String from, String to, byte[] signature) {
        this.from = from;
        this.to = to;
        this.signature = signature;
    }

    public byte[] getSignatue() {
        return signature;
    }

    public void setSignatue(byte[] signature) {
        this.signature = signature;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        //format values to english notation
        String signatureString = Base64.getEncoder().encodeToString(signature);
        return String.format("%-10s -> %20s -> %s", from, signatureString, to);
        //return from + "\t : " + to + "\t -> " + signature;
    }

    public static Vote2 fromString(String txt) throws Exception {
        String[] elem = txt.split(" -> ");
        return new Vote2(elem[0].trim(), elem[2].trim(),elem[1].getBytes());
    }

    
    public String toText(){
       return Converter.objectToHex(this);
    }
    
    public static Vote2 fromText(String obj){
       return (Vote2) Converter.hexToObject(obj);
    }
    
    public static long serialVersionUID = 123;

}