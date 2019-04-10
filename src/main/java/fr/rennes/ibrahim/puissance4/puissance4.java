/**
 * Jeu Puissance 4
 * @author Ibrahim BOUDO
 * @version Univ Rennes1 2015-2016
 */

package fr.rennes.ibrahim.puissance4;

import java.util.Scanner;

public class puissance4 {
	static Scanner _sc = new Scanner(System.in);
//	int saisie = _sc.nextInt();
	static int [][]grille;				//variable globale

	static void initialiseGrille(){		//initialisation de la grille
		int n=6,m=7;
		grille=new int [n][m];
	}	

	static void jouer(int numero,int j){	//faire jouer
		//int i=grille.length-1;
		int i=0;
		boolean bool=true;

		while(i<grille.length && bool){
			if(j<grille[i].length){
				if(grille[i][j]!=0){
					i++;
					bool=true;
				}else{
					grille[i][j]=numero;
					bool=false;
				}
			}else{
				System.out.println("\n");
				System.out.println("Erreur choisisez une nouvelle colonne valide ");
				bool=true;
				j = _sc.nextInt();;
			}
		}
	}


	static void afficheGrille(){			// affichage
		int i=grille.length-1,j=0;			
		boolean bool=true;
		while(bool){
			while(j<grille[i].length){
				System.out.print('|');
				if(grille[i][j]==0){
					System.out.print(' ');
				}else if(grille[i][j]==1){
					System.out.print('X');
					
				}else if(grille[i][j]==2){
					System.out.print('O');
				}j++;
			}System.out.print('|');
			System.out.print("\n");
			j=0;
			i--;
			if(i==-1){
				bool=false;
			}else{
				bool=true;
			}
		}while(j<7){
			System.out.print(' ');
			System.out.print(j);
			j++;
			
		}
	}


	//Detecton d'un alignement de 4 caseS

	static boolean aGagneHor(int numero, int y, int x){		//horizontal
		int a=0;
		boolean bool=true;
		if(y<grille.length && x<grille[y].length-3){		//On ne sort pas du tableau
			while(a<4 && bool){
				if(numero==grille[y][x]){
					bool=true;
					x++;
					a++;
				}else{
					bool=false;
				}
			}
		}else{
			bool=false;
		}return bool;
	}


	static boolean aGagneVer(int numero, int y, int x ){		//vertical
		int a=0;
		boolean bool=true;
		if(y>2 && x<grille[y].length){							//On ne sort pas du tableau
			while(a<4 && bool){
				if(numero==grille[y][x]){
					bool=true;
					y--;
					a++;
				}else{
					bool=false;
				}
			}
		}else{
			bool=false;
		}return bool;
	}
	
	
	static boolean aGagneDiagMont(int numero, int y, int x){		//Diagonal Montant
		int a=0;
		boolean bool=true;
		if(y>2 && x<grille[y].length-3){							//On ne sort pas du tableau
			while(a<4 && bool){
				if(numero==grille[y][x]){
					bool=true;
					y--;
					x++;
					a++;
				}else{
					bool=false;
				}
			}
		}else{
			bool=false;
		}return bool;
	}


	static boolean aGagneDiagDesc(int numero, int y, int x){		//Diagonal Descendant
		int a=0;
		boolean bool=true;
		if(y<3 && x<grille[y].length-3){					//il ne sort pas du tableau, � la sortie a=4
			while(a<4 && bool){
				if(numero==grille[y][x]){
					bool=true;
					y++;
					x++;
					a++;
				}else{
					bool=false;
				}
			}
		}else{
			bool=false;
		}return bool;
	}

	static boolean aGagne(int numero){					//� Gagn�
		int i=0,j=0;
		boolean bool=true,a,b,c,d;
		while(i<grille.length && bool ){
			while(j<grille[i].length && bool){
				a=aGagneHor(numero,i,j);
				b=aGagneVer(numero,i,j);
				c=aGagneDiagMont(numero,i,j);
				d=aGagneDiagDesc(numero,i,j);
				if(a==true | b==true | c==true | d==true){
					bool=false;
				}else{
					bool=true;
					j++;
				}
			}i++;
			j=0;
		}return !bool;
	}	

	static boolean matchNul(){			// Match nul
		int i=5,j=0,numero=1;
		boolean bool=true,a;
		
		while(j<grille[i].length && bool){
			if(grille[i][j]!=0){
				bool=true;
				j++;
			}else{
				bool=false;
			}
		}
		a=aGagne(numero);
		if(bool==true){
			if(a==true){
				bool=false;
			}else if(a==false){
				bool=true;
			}
		}else if(bool==false && a==false){
			bool=false;
		}else if(bool==false && a==true){
			bool=false;
		}
		return bool;
	}
	
	
	static void jeu(){					//La Boucle
		int a;
		boolean bool=true;
		int numero=2;
		initialiseGrille();
		afficheGrille();
		while(bool){
		numero=3-numero;
		System.out.print("\n");
		System.out.println("Quel coup pour le joueur "+numero+" ");
		a = _sc.nextInt();
		jouer(numero,a);
		afficheGrille();
		if(matchNul()==true || aGagne(numero)==true){
			bool=false;
		}else{
			bool=true;
		}
//		_sc.nextLine();
		}System.out.println("\n");
		if(aGagne(numero)==true){
			System.out.println(" Felicitation !! (^_^) !! Le joueur "+numero+" a gagne !!!!!");
		}else{
			System.out.println("!! {':'} !! Match nul");
		}
		_sc.close();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jeu();
		
	}
}
