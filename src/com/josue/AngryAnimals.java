package com.josue;
import java.util.ArrayList;
import java.util.List;

public class AngryAnimals {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<String> pair = new ArrayList<String>();
		List<String> angryPair = new ArrayList<String>();
		
		int n = 8;
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(3);
		b.add(8);
		b.add(5);
		b.add(6);
		b.add(4);
		
		for (int i=0; i< a.size(); i++) {
			angryPair.add(a.get(i)+ ","+b.get(i));
		}
		
		String bVal = ""; boolean exit = false;
        for (int i=1; i<= n; i++) {
            bVal = String.valueOf(i);
            pair.add(bVal);
            for (int j=i; j<=n; j++) {
                if (!verify(angryPair, String.valueOf( i ), String.valueOf( (j+1))) 
                    && j+1 <= n ) {
                	bVal += "," + (j+1);
//                    String valsB[] = bVal.split(",");
//                    for (int k=0; k<valsB.length; k++) {
//                        if (exit) break;
//                        for (int h=0; h<valsB.length; h++) {
//                            if (verify(angryPair, valsB[k]+","+valsB[h])) {
//                                exit = true;
//                                break;
//                            }
//                        }
//                    }
                    if (exit) {
                        exit = false;
                        break;
                    }
                    pair.add(bVal);
                }
                if (verify(angryPair, String.valueOf( i ), String.valueOf( (j+1)))
                    && j+1 <= n) {
                    break;
                }
            }
        }
        
		
		System.out.println(pair.size());
	}
	
	public static boolean verify(List<String> angryPair, String valA, String valB) {
		for (String string : angryPair) {
			if (string.indexOf(valA) !=-1 && string.indexOf(valB) != -1) {
				return false;
				
			}
		}
		return true;
	}
}
