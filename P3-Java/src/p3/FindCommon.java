package p3;

public class FindCommon { 
	// This function prints common elements in ar1 
	static String findCommon(int ar1[], int ar2[], int ar3[]) 
	{ 
                StringBuilder res = new StringBuilder("");
		// Initialize starting indexes for ar1[], ar2[] and ar3[] 
		int i = 0, j = 0, k = 0; 
                int count = 0;
		// Iterate through three arrays while all arrays have elements 
		while (i < ar1.length && j < ar2.length && k < ar3.length) 
		{ 
			// If x = y and y = z, print any of them and move ahead 
			// in all arrays 
			if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) 
			{ res.append(ar1[i]+" "); i++; j++; k++; count++;} 

			// x < y 
			else if (ar1[i] < ar2[j]) 
				i++; 

			// y < z 
			else if (ar2[j] < ar3[k]) 
				j++; 

			// We reach here when x > y and z < y, i.e., z is smallest 
			else
				k++; 
		} 
                return res.toString() + " \n\nNumber of common elements: " + count + ".\n";
	} 
} 

/*This code is contributed by Rajat Mishra */
