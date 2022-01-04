/* Napisati program koji za date cele brojeve n, 0 <= n <= 40, i r, 1 <= r <= 10,
   ispisuje vrednost elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = f_n-1 + f_n-2 + ... + f_n-r, n >= r
   f_n = n, 0 <= n < r
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */
 class Sedamnaesti {
	 
	static int fDef(int n, int r){
		if(r>n)
			return n;
		else{
			int fn = 0;
			for (int i = 1; i <= r; i++) 
				fn = fn + fDef(n-i, r);
			return fn;
		}
	}
	
	static int fRek1(int f[], int i, int n, int r){
		if(i>n)
			return f[r];
		else{
			f[r] = 0;
		    for (int j = 1; j <= r; j++) 
				f[r] = f[r] + f[r-j];
		    for(int j = 0; j < r; j++) 
				f[j] = f[j+1];
		    return fRek1(f, i+1, n, r);
		}
	}
	
	static int fRek2(int n, int r){
		int f[] = new int[r + 1];
		if (n < r)
		  return n;
		else {
		  for (int j = 0; j < r; j++) 
			f[j] = j;
		  return fRek1(f, r, n, r);
		}
	}
	
	static int fIter(int n, int r) {
		int f[] = new int[r + 1];
		for (int i = 0; i < r; i++) 
		  f[i] = i;
		if (n < r)
		  return f[n];
		else {
		  for (int i = r; i <= n; i++) {
			f[r] = 0;
			for (int j = 1; j <= r; j++) 
			  f[r] = f[r] + f[r-j];
			for (int j = 0; j < r; j++)  
			  f[j] = f[j+1];
			}
		}
		return f[r];
	}
	 
	 
	static final int N_MAX = 40, N_MIN = 0;
	static final int R_MAX = 10, R_MIN = 1;
	
	public static void main (String[] args) {
		int n, r;
		do{
			n = Svetovid.in.readInt("Unesite n:");
		}while(!(n>=N_MIN && n<=N_MAX));
		
		do{
			r = Svetovid.in.readInt("Unesite r:");
		}while(!(r>=R_MIN && r<=R_MAX));
		
		Svetovid.out.println(fDef(n, r));
		Svetovid.out.println(fRek2(n, r));
		Svetovid.out.println(fIter(n, r));
	}
}

