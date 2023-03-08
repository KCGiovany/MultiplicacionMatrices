package dev;

import java.util.Scanner;
import java.util.Random;

public class MultMatz {
static float[][] MatrizA =new float[99][99], MatrizB = new float[99][99], MatrizC = new float[99][99];
static int TamA_f,TamA_c,TamB_f,TamB_c,TamC_f,TamC_c;
static Scanner Leer = new Scanner(System.in);
static Random rnd = new Random();

public static void main(String[] args) {
int Opc = 0;
while((Opc = Menu()) != 3) {
AsigTam();

switch(Opc) {
case 1:
LlenMatzMan(MatrizA,"A",TamA_f,TamA_c);
LlenMatzMan(MatrizB,"B",TamB_f,TamB_c);
break;
case 2:
LlenMatzRan(MatrizA,TamA_f,TamA_c);
LlenMatzRan(MatrizB,TamB_f,TamB_c);
break;
}

MultMatz(MatrizA,MatrizB);

System.out.println("La multiplicación de las 2 matrices");
ImprMatz(MatrizA,"A",TamA_f,TamA_c);
ImprMatz(MatrizB,"B",TamB_f,TamB_c);

System.out.println("Es : ");
ImprMatz(MatrizC,"resultado",TamC_f,TamC_c);
}
}

static void AsigTam() {
int auxA_f = 0,auxA_c = 0,auxB_f = 0,auxB_c = 0;
boolean band = false;

do {
if(band) {
System.out.println("El tamaño de las matrices A = " + auxA_f +"x"+ auxA_c + " y B = " + auxB_f +"x"+ auxB_c + " no permiten su multiplicación.");
System.out.println("El númemero de columnas de la matriz A debe ser igual al numero de filas de la matriz B o en su defecto deben ser cuadradas.");
}

System.out.println("-- Digite el tamaño de las matrices --");

System.out.println(" Matriz A");
System.out.println("Filas >");
auxA_f = Leer.nextInt();
System.out.println("Columnas >");
auxA_c = Leer.nextInt();

System.out.println(" Matriz B");
System.out.println("Filas >");
auxB_f = Leer.nextInt();
System.out.println("Columnas >");
auxB_c = Leer.nextInt();

if(auxA_c != auxB_f) {
band = true;
}

}while(band);

TamA_f = auxA_f;
TamA_c = auxA_c;

TamB_f = auxB_f;
TamB_c = auxB_c;
}

static void LlenMatzMan(float [][]Mat, String Nomb,int lenf,int lenc) {
System.out.println("Llena la matriz " + Nomb);
for(int i = 0; i < lenf; i ++) {
for(int j = 0; j < lenc; j ++) {
System.out.print("Inserte el valor de la fila " + i + " y columna " + j + " >");
Mat[i][j] = Leer.nextFloat();
}
}
}

static void LlenMatzRan(float[][] Mat,int lenf,int lenc) {
for(int i = 0; i < lenf; i ++) {
for(int j = 0; j < lenc; j ++) {
Mat[i][j] = rnd.nextFloat(101);
}
}
}

static void MultMatz(float[][] A,float[][] B) {
	TamC_f = TamA_c;
	TamC_c = TamB_f;
	
	for(int i = 0; i < B.length; i ++) {
		for(int j = 0; j < A[0].length; j ++) {
			for(int k = 0; k < B[0].length; k ++) {
				MatrizC[i][j] += MatrizA[i][k] * MatrizB[k][j];
			}
			
		}
	}
	
}

static void ImprMatz(float[][] Mat, String Nom,int lenf,int lenc) {
System.out.println(" ");
System.out.println("Matriz " + Nom);
for(int i = 0; i < lenf; i ++) {
for(int j = 0; j < lenc; j ++) {
System.out.print(Mat[i][j]);
if(j < lenc-1) {
	System.out.print(", ");
}
}
System.out.println(" ");
}
}

static int Menu() {
int Opc = 3;
System.out.println(" ");
System.out.println("-- Programa para multiplicación de matrices --");
System.out.println(" Menú");
System.out.println("1.- Modo manual");
System.out.println("2.- Modo random");
System.out.println("3.- Salir");
System.out.println("Digite una opción >");

Opc = Leer.nextInt();

return Opc;
}
}