// C++ program to find Majority 
// element in an array 
#include <stdio.h>
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <ctime>
#include <unistd.h>
#include <bits/stdc++.h> 
using namespace std; 

int* v1;
int n1  = 0;
int df  = 0;
int dt  = 0;
int di  = 0;
int out = 0;

// Function to find Majority element 
// in an array 
void findMajority(int arr[], int n) 
{ 
	int maxCount = 0; 
	int index = -1; // sentinels 
	for(int i = 0; i < n; i++) 
	{ 
		int count = 0; 
		for(int j = 0; j < n; j++) 
		{ 
			if(arr[i] == arr[j]) 
			count++; 
		} 
		
		// update maxCount if count of 
		// current element is greater 
		if(count > maxCount) 
		{ 
			maxCount = count; 
			index = i; 
		} 
	} 
	
	// if maxCount is greater than n/2 
	// return the corresponding element 
    if (out)
	{if (maxCount > n/2) 
	    cout << arr[index] << endl; 
	
	else
		cout << "No Majority Element" << endl; 
    }
} 

int options(int argc, char *argv[]) 
{
	
	if( argc == 1 ){
		//cout << "Error, debes introducir parámetros\n";
		printf("Error, debes introducir parámetros\n");
		return 1;
	}

	//Comprobamos si el programa se lanzó con la opción -h
	for(int i=1; i<argc;i++){
		if( string(argv[i]) ==  "-h" ){
			cout <<"c++ MayorityElement help \n\
    ------------------\n\
    Input switches\n\
        -f filename :   input data from file\n\
        -a length : input initialized with ascending values\n\
    \n\
    Display switches\n\
    	-dt : Display time in seconds\n\
    	-di : Display input\n\
        -do : Display output\n";
			exit(0);
		}
		if( string(argv[i]) ==  "-f" ){
			df=1;
			//Comprobamos si el fichero existe
			ifstream fileStream(argv[i+1]);
			if (fileStream.fail()) {
				cout << "Error al leer archivo";
    			exit(1);
			}

			string f1,tmp;
			fileStream >> f1;


			//Leemos del fichero	
			//Primero contamos el número de elementos que tiene el archivo para reservar espacio en memoria
			stringstream tmp1(f1);
			while(getline(tmp1,tmp,',')){
				n1++;
			}
			v1 = (int*)malloc(n1*sizeof(int));

			//Guardamos los elementos en el array
			stringstream s1(f1);
			n1=0;
			while(getline(s1,tmp,',')){
				v1[n1] = (atoi(tmp.c_str()));
				n1++;
			}

			
			//Cerramos el fichero
			fileStream.close();
		}
        if( string(argv[i]) ==  "-a" ){
            n1= (atoi(argv[i+1]));
            v1 = (int*)malloc(n1*sizeof(int));
            for(int j=0;j<n1;j++){
                v1[j]=j;
            }
        }
		if( string(argv[i]) ==  "-dt" ){
			dt=1;
		}
		if( string(argv[i]) ==  "-do" ){
			out=1;
		}
		if( string(argv[i]) ==  "-di" ){
			di=1;
		}
		
	}

	return 0;
}

// Driver code 
int main(int argc, char *argv[]) 
{
	options(argc,&argv[0]);

	if(di){
		cout << "El array de sobre el que se realizará la operación es: [";
		for (int i = 0; i<n1; i++){
			if (i != n1-1) cout << v1[i] << ", ";
			else cout << v1[i];
		}
		cout << "]\n";
	}
	

	double t = clock();
    findMajority(&v1[0], n1);
	t = clock()-t;

	if(dt){
		cout<< "Time: \t" << t/ (double) CLOCKS_PER_SEC << " s\n\n";
	}
	free (v1);
	return 0; 
} 
