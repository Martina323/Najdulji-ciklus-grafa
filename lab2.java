//Martina Galic 003652537

package dismat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class zad {
	static int bv; //broj vrhova
	static List<Integer>[] polje_susjednih;
	static boolean[] vrhovi;
	static List<Integer>[] polje_nesusjednih;
	static int[] boje;
	static int maksb;
		public static void main(String[] args) throws IOException {
			System.out.println("Unesite ime datoteke: ");
			Scanner sc = new Scanner(System.in);
			String fajl = sc.nextLine();
			String str;
			File dat = new File(fajl);
			BufferedReader br = new BufferedReader(new FileReader(dat));
			int i = 0;
			str = br.readLine();
			i = Integer.parseInt(str);
			polje_susjednih= new List[i];
			polje_nesusjednih= new List[i];
			str = br.readLine();
			bv=i;					
			for (int f=0;f<i;f++) {
				str = br.readLine();
				String[] matrica = str.split(" ");
				List<Integer> list_susjednih=new LinkedList<Integer>();
				List<Integer> list_nesusjednih=new LinkedList<Integer>();
				for(int x=0;x<i;x++) {
					if(matrica[x].equals("1")) {
						list_susjednih.add(x);
					}else {
						list_nesusjednih.add(x);
					}
				}
				polje_susjednih[f]=list_susjednih;
				polje_nesusjednih[f]=list_nesusjednih;
			}
			vrhovi=new boolean[bv];
	    	boje=new int[bv];
	        for (int j = 0; j < bv; j++) {
	            vrhovi[j]=false;
	           boje[j]=0; 
	        }
	         maksb = 1;	       
	        rekurzivna(0, vrhovi, maksb);
	        int max = 0;
	        for (int j = 0; j < bv; j++) {	        	
	            if (boje[j]> max) max = boje[j];	                	            
	        }	
	        
	       	
	        System.out.println(max);
		}
		static void rekurzivna(int v, boolean[] vrhovi, int maxColour) {
		        if (v == 0 && vrhovi[0]== false) {
		        	boje[v]=1;		            
		            vrhovi[v]=true;		            		            	
		            for(Integer s:polje_susjednih[v])			            	
		            	rekurzivna(s, vrhovi, maxColour);		            
		        }		        		        
		        if (vrhovi[v] == false) {
		            vrhovi[v]=true;
		            List<Integer> lista=new ArrayList<Integer>();           
		            	for(Integer s:polje_susjednih[v])	{
		            		if(boje[s]!=0) lista.add(boje[s]);		            				            			
		            	}		              			           
		            int boja = 0;
		            int proba = 0;
		            for(Integer s:polje_nesusjednih[v])	{
		            	proba = 0;
		            	if(boje[s]!=0) {		            				    
		            		for(Integer i:lista) {
		            			if(boja==0) {
		            				if(boje[s]==i) 
		            					proba++;		            				
		            			}		            		
		            		}
		            		if (proba == 0) boja=boje[s];		            		
		            	}
		            }		            		            		            
		            int newMax = maxColour;
			            if (boja != 0) {
			            	boje[v]=boja;
		            }else {
		            	 boje[v]=maxColour+1;
			                newMax = maxColour + 1;
			                maxColour = newMax;
		            }		            
		            for (Integer i:polje_susjednih[v]) rekurzivna(i, vrhovi, maxColour);		            		            
		        }		        		        
		    }		
}
		
		           
		        

