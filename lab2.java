
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

	public class Zadatak {
		
		static int bv; //broj vrhova
		static List<Integer>[] polje;
		static Set<Integer> duljinaCiklusa=new TreeSet<Integer>();
		static boolean[] poljeVrhova;
		
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
			polje= new List[i];
			str = br.readLine();
			bv=i;
			poljeVrhova=new boolean[i];
		
			for (int f=0;f<i;f++) {
				str = br.readLine();
				String[] matrica = str.split(" ");
				List<Integer> list=new LinkedList<Integer>();
				for(int x=0;x<i;x++) {
					if(matrica[x].equals("1")) {
						list.add(x);
					}
				}
				polje[f]=list;
				
			}
			
			for (int j = 0; j < bv; j++) {
				for(int z=0;z<bv;z++) {
					poljeVrhova[z]=false;
				}
				rekurzivna(j, poljeVrhova,j);
		
		    }
		int dulj=duljinaCiklusa.size();
		if (bv == 1 && str.charAt(0)=='0'|| duljinaCiklusa.toArray()[dulj-1].equals(2)) System.out.println("0");
		else System.out.println(duljinaCiklusa.toArray()[dulj-1]);
		
		}
		
		static void  rekurzivna(int v,boolean[] poljeVrhova,int krajnji) {
			
			poljeVrhova[v]=true;
			int duljina=polje[v].size();
			
			for(int i=0;i<duljina;i++){
				int nesto=polje[v].get(i);
				
				if(Boolean.valueOf(poljeVrhova[nesto]).equals(false)) {
					rekurzivna(nesto,poljeVrhova,krajnji);
					
				}else {
					if(Integer.valueOf(nesto).equals(Integer.valueOf(krajnji))) {
						int br=0;
						for(int j=0;j<bv;j++) {
							if(Boolean.valueOf(poljeVrhova[j]).equals(true)) {
								br++;	
							}			
						}
						duljinaCiklusa.add(br);
					}	
				}
			}
			poljeVrhova[v]=false;
		}
	
	}
	
//Martina Galić,0036525378
	
	
	
