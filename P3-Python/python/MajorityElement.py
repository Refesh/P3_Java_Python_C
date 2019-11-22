import sys
import os
import time
# Python 3 program to find Majority 
# element in an array 

# Guardamos los argumentos con los que llamamos al programa en arg
arg = sys.argv

#Comprobamos si tenemos que mostrar el resultado
if "-do" in arg:
    out=1
else:
    out=0

# Function to find Majority 
# element in an array 
def findMajority(arr, n): 

    maxCount = 0
    index = -1 # sentinels 
    for i in range(n):	
    	count = 0
    	for j in range(n): 
            
		    if(arr[i] == arr[j]): 
		    	count += 1
		
    	# update maxCount if count of 
    	# current element is greater 
    	if(count > maxCount): 
		
    		maxCount = count 
    		index = i 
	
	# if maxCount is greater than n/2 
	# return the corresponding element 
    if (out==1):
        if (maxCount > n//2): 
        	print(arr[index])
        else: 
    	    print("No Majority Element")

def read(filename):
    if os.path.getsize(filename)>0 :
        return [int(i) for i in (open(filename).read()).split(",")]
    return []

def main():
    if len(arg)==1 :
        print("Error, no has introducido parámetros")
        exit()
    elif ("-h" in arg):
        print('''Python MayorityElement help
    ------------------
    Input switches
        -f filename :   input data from file
        -a length : input initialized with ascending values
    
    Display switches
        -dt : Display time in seconds
        -di : Display input
        -do : Display output''')
        exit()
    else:
        global x1
        if "-f" in arg:
            try:
                x=int(arg.index("-f"))
                if x+1 >= len(arg):
                    print("Error, ningún fichero después de opción -f")
                    exit()
                x1=read(arg[x+1])
            except FileNotFoundError as ex:
                print("Fichero",ex.filename,"no encontrado")
                exit()
        elif "-a" in arg:
            x=int(arg.index("-a"))
            if x+1 >= len(arg):
                print("Error, ningún número después de opción -w")
                exit()
            x1=[i for i in range(0,int(arg[x+1]))]
        else:
            print("Error, no se encuentran los paŕametros para inicializar el vector")
            exit()

        if "-di" in arg :
            print("El array de sobre el que se realizará la operación es:",x1)

# Driver code 
if __name__ == "__main__": 
    main()	
	# Function calling 
    t= time.time()
    findMajority(x1, len(x1))
    t= (time.time()-t)
    if "-dt" in arg:
        print("Time: \t",round(t,6), " s\n",sep="")

