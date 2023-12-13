/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicoes.lib;

import eleicoes.remote.RemoteInterface;
import eleicoes.lib.Election;
import eleicoes.lib.Person;

/**
 *
 * @author gonca
 */
//This is a global class to access all my variables pratically.
public class Global {
    public static boolean isFirst=true;
    //default password to admin login
    public static String myPassword="Admin123";
    //verify if shows admin menu
    public static boolean isAdmin=false;
    //Eleitoral class to acces all classes/GUI class
    public static Election eleitoral = new Election();
    public static Election eleitoralSearch = new Election();
    //Person logged
    public static Person loggedP = new Person();
    
    public static RemoteInterface remote;
    
    public static String ip = "//10.10.209.229:10010/RemoteMiner";

}