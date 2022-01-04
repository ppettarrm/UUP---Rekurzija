/* Napisati program koji za date cele brojeve n, 0 <= n <= 50, i
 r, 2 <= r <= 20, ispisuje vrednost elementa rekurentnog niza f_n.
 Niz je definisan na sledeci nacin:
 f_n = f_n-1 - g_n-2 + f_n-r - g_n-r, n >= r
 g_n = g_n-1 + f_n-2 - f_n-r - g_n-r, n >= r
 f_n = 1, 0 <= n < r
 g_n = 2, 0 <= n < r
 Element f_n izracunati:
 (a) rekurzivno preko definicije,
 (b) rekurzivno pomocu akumulirajuceg parametra,
 (c) iterativno.
 U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/

class Dvanaesti {
	
	static int fDef(int n, int r){
		if(n<r)
			return 1;
		else
			return fDef(n-1, r) - fDef2(n-2, r) + fDef(n-r, r) - fDef2(n-r, r);
	}
	
	static int fDef2(int n, int r){
		if(n<r)
			return 2;
		else
			return fDef2(n-1, r) + fDef(n-2, r) - fDef(n-r, r) - fDef2(n-r, r);
	}
	
	static int fRek1(int f[], int g[], int i, int n, int r){
		if(i>n)
			return f[r];
		else{
			f[r] = f[r-1] - g[r-2] + f[0] - g[0];
			g[r] = g[r-1] + f[r-2] - f[0] - g[0];
			for(int j = 0; j < r; j++) {
				f[j] = f[j+1];
				g[j] = g[j+1];
			}
			return fRek1(f, g, i+1, n, r);
		}
	}
	
	static int fRek2(int n, int r){
		int f[] = new int[r+1];
		int g[] = new int[r+1];
		if(n<r)
			return 1;
		else{
			for(int j = 0; j<r; j++){
				f[j] = 1;
				g[j] = 2;
			}
			return fRek1(f, g, r, n, r);
		}
	}
	
	static int fIter(int n, int r){
		int f[] = new int[r+1];
		int g[] = new int[r+1];
		
		for(int i = 0; i<r; i++){
				f[i] = 1;
				g[i] = 2;
		}
		
		if(n<r)
			return f[n];
		else{
			for(int i=r; i<=n; i++){
				f[r] = f[r-1] - g[r-2] + f[0] - g[0];
				g[r] = g[r-1] + f[r-2] - f[0] - g[0];
				for(int j = 0; j<r; j++){
					f[j] = f[j+1];
					g[j] = g[j+1];
				}
			}
		}
		return f[r];	
	}
	
	static final int N_MAX = 50, N_MIN = 0;
	static final int R_MAX = 20, R_MIN = 2;
	
	public static void main (String[] args) {
		int n, r;
		do{
			n = Svetovid.in.readInt("Unesite n:");
		}while(!(n>=N_MIN && n<=N_MAX));
		
		do{
			r = Svetovid.in.readInt("Unesite r:");
		}while(!(r>=R_MIN && r<=R_MAX));
		
		Svetovid.out.println(fRek2(n, r));
		Svetovid.out.println(fDef(n, r));
		Svetovid.out.println(fIter(n, r));
	}
}

