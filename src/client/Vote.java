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
package client;

import java.io.Serializable;
import distributedMiner.utils.Serializer;

/**
 *
 * @author manso
 */
public class Vote implements Serializable {

    private String from;
    private String to;
    private String sign;
    

    public Vote(String from, String to) {
        this.from = from;
        this.to = to;  
    }

    public Vote(String from, String to, String sign) {
        this.from = from;
        this.to = to;
        this.sign =sign;
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
         return     "From : "+from
                + "\nTo   : " + to
                + "\nSignature: " + sign;                
    }

    public String toText() {
        return Serializer.objectToBase64(this);
    }

    public static Vote fromText(String obj) {
        return (Vote)Serializer.base64ToObject(obj);
    }

    @Override
    public int hashCode() {
        return toText().hashCode();
    }

    @Override
    public boolean equals(Object t) {
        if (t instanceof Vote) {
            return this.toText().equals(((Vote) t).toText());
        }
        return false;
    }
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202312050910L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
