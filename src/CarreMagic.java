package src;

import src.Terminal;

//prog qui v�rifie un carr� magique
/* 
 * Le carr� commence � la ligne et colonne 0
*/
public class CarreMagic{
  public static void main(String[] args){
    boolean check=true;

 //tableau - � composer par l'utilisateur 

    int cases, nbmax;
    Terminal.ecrireString("Choisissez la grandeur de votre carr�. exemple : 3 pour un carr� de 3 x 3");
    Terminal.sautDeLigne();
    cases = Terminal.lireInt();
    nbmax = cases * cases;
    Terminal.sautDeLigne();
    Terminal.ecrireString("Remplissez le tableau et v�rifier si votre carr� est magique. La premi�re colonne et premi�re ligne commence � 0. Vous ne pouvez pas utiliser un nombre qui a d�j� �t� entr�");
    Terminal.sautDeLigne();

    int[][] carre = new int[cases][cases];
    int lig, col, nomb;
    boolean[] dejautilise = new boolean[10];
    for (int num=0; num<nbmax; num=num+1){
      do{
        do{
          Terminal.ecrireString("Pour quelle colonne ? ");
          col = Terminal.lireInt();
        }while(col<0 || col>2);
        do{
          Terminal.ecrireString("quelle ligne ? ");
          lig = Terminal.lireInt();
        }while(lig<0 || lig>2);
      }while(carre[col][lig]!=0);
      do{
        Terminal.ecrireString("Entrez un nombre : ");
        nomb = Terminal.lireInt();
      }while(nomb<1 || nomb>nbmax || dejautilise[nomb]);
      carre[col][lig]=nomb;
      dejautilise[nomb]=true;
      for (int l=0; l<cases; l++){
        for (int c=0; c<cases; c++){
          if (carre[c][l]!=0){
            Terminal.ecrireString(" "+carre[c][l]+"|");
          }else{
            Terminal.ecrireString(" |");
          }
        }
        Terminal.sautDeLigne();
      }
    }
    
//check diagonales
    int som1=0,  som2=0;
    for(int i=0; i<cases;i++){
      som1=som1+carre[i][i];
    }
    int mavar=2 ;
    for(int i=0; i<cases && (mavar>=0);i++){
      som2=som2+carre[i][mavar];
      mavar--;        
    }
    if (som2!=som1){
      check=false;
    }else{
      check=true;
    }
    
    
//check ligne par ligne et colonne par colonne
    int nb=0;
    for(int i=0;i<carre.length;i++){
      int som3=0, som4=0;
      for(int j=0;j<carre[carre.length-1].length;j++){
        som3=som3+carre[i][j];//addition pour le total par ligne
        som4=som4+carre[j][i];//addition pour le total par colonne
      }
      //src.Terminal.ecrireStringln("le total par ligne : "+som3);
      //src.Terminal.ecrireStringln("le total par colonne : "+som4);
      
      if (som3!=som1 || som4!=som1 ){
        nb++;
      }else{
        nb--;
      }
    }
    if (nb<0){
      check=true;
    }else{
      check=false;
    }
    
//affichage du check : si c'est un carr� magique ou pas
    if (check){
      Terminal.ecrireString("Bravo ! C'est un carr� magique.");
    }else{
      Terminal.ecrireString("Ce n'est pas un carr� magique. Essai encore une fois!");  
    }
  }
}


/*Jeu de test
 valeur � entrer champs par champs dans le prog : 
 0,0,2,1,0,7,2,0,6,0,1,5,1,1,9,2,1,1,0,2,4,1,2,3,2,2,8 => FAUX ce n'est pas un carr� magique
 0,0,2,1,0,7,2,0,6,0,1,9,1,1,5,2,1,1,0,2,4,1,2,3,2,2,8 => vrai c'est un carr� magique
 
 ou valeur � entrer dans votre code
 {2,7,6}, {5,9,1}, {4,3,8} => FAUX ce n'est pas un carr� magique
 {2,7,6}, {9,5,1}, {4,3,8} => vrai c'est un carr� magique
 */