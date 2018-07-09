package src;

import java.io.*;


public class Terminal{    
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    private static String lireString() { // Lire un String
	    String tmp = "";
	    try {
		    tmp = in.readLine();
	    }
	    catch (IOException e) {
		    exceptionHandler(e);
	    }
	    return tmp;
	} // fin de lireString()

    static int lireInt() { // Lire un entier
	    int x = 0;
	    try {
		    x = Integer.parseInt(lireString());
	    }
	    catch (NumberFormatException e) {
		    exceptionHandler(e);
	    }	
	    return x ;
	}

    public static boolean lireBoolean() { // Lire un entier
	    boolean b = true;
	    try {
		    b = Boolean.valueOf(lireString());
	    }
	    catch (NumberFormatException e) {
		    exceptionHandler(e);
	    }	
	    return b;
	}

    public static double lireDouble() { // Lire un double
	    double x = 0.0;
	    try {
		    x = Double.valueOf(lireString());
	    }
	    catch (NumberFormatException e) {
		    exceptionHandler(e);
	    }	
	    return x ;
	}

    public  static char lireChar() { // Lire un caractere
	    String tmp = lireString();
	    if (tmp.length()==0)
		    return '\n';
	    else 
    		return tmp.charAt(0);
	}

	static void ecrireString(String s) { // Afficher un String
        try {
            System.out.print(s);
        } catch (Exception ex){
            exceptionHandler(ex);
        }
    }

    public static void ecrireStringln(String s) { // Afficher un String
	    ecrireString(s);
	    sautDeLigne();
	} // fin de ecrireStringln()

    public static void ecrireInt(int i) { // Afficher un entier
	    ecrireString(String.valueOf(i));
	}
    public static void ecrireIntln(int i) { // Afficher un entier
	    ecrireString(String.valueOf(i));
	    sautDeLigne();
	}
    public static void ecrireBoolean(boolean b) {
	    ecrireString(String.valueOf(b));
    }

    public static void ecrireBooleanln(boolean b) {
        ecrireString(String.valueOf(b));
        sautDeLigne();
    }

    private static void ecrireDouble(double d) { // Afficher un double
	    ecrireString(String.valueOf(d));
	}
    public  static void ecrireDoubleln(double d) { // Afficher un double
        ecrireString(String.valueOf(d));
	    sautDeLigne();
	}

    private static void ecrireChar(char c) { // Afficher un caractere
	    ecrireString(String.valueOf(c));
	}

    public  static void ecrireCharln(char c) { // Afficher un caractere
	    ecrireChar(c);
	    sautDeLigne();
	}

    static void sautDeLigne(){
	    try{
	        System.out.println();
	    }catch(Exception ex){
	        exceptionHandler(ex);
	    }
    }

    private static void exceptionHandler(Exception ex) {
        throw new TerminalException(ex);
    }

    public static void ecrireException(Throwable ex) {
        ecrireString(ex.toString());
        ex.printStackTrace(System.err);
    }
}

class TerminalException extends RuntimeException{
    private Exception ex;
    TerminalException(Exception e){
	    ex = e;
    }
}


