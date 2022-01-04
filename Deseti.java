/* Napisati program koji za dati ceo broj n, 1 <= n <= 30, ispisuje vrednost
 elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
 f_n = f_n-1 + g_n-1, n >= 2
 g_n = 2g_n-1 - f_n-1, n >= 2
 f_1 = 2
 g_1 = 3
 Element f_n izracunati:
 (a) rekurzivno preko definicije,
 (b) rekurzivno pomocu akumulirajuceg parametra,
 (c) iterativno.
 U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/

class Deseti {
	
	static int fDef(int n){
		if(n==1)
			return 2;
		else{
			return fDef(n-1) + fDef2(n-1);
		}
		
	}
	
	static int fDef2(int n){
		if(n==1)
			return 3;
		else
			return 2*fDef2(n-1)-fDef(n-1);
	}
	
	static int fRek1(int f1, int g1, int i, int n){
		if(i>n)
			return f1;
		else
			return fRek1(f1+g1, 2*g1-f1, i+1, n);
	}
	
	static int fRek2(int n){
		if(n==1)
			return 2;
		else
			return fRek1(2, 3, 2, n);
	}
	
	static int fIter(int n){
		int fn = 0, gn = 0, g1 = 3, f1 = 2;
		
		if(n==1)
			fn = f1;
		else{
			for(int i = 2; i<=n; i++){
				fn = f1+g1;
				gn = 2*g1-f1;
				
				f1 = fn;
				g1 = gn;
			}
		}
		return fn;
	}
	
	static final int N_MAX = 30, N_MIN = 1;
	
	public static void main (String[] args) {
		int n;
		do{
			n = Svetovid.in.readInt("Unesite n:");
		}while(!(n>=N_MIN && n<=N_MAX));
		
		Svetovid.out.println(fRek2(n));
		Svetovid.out.println(fDef(n));
		Svetovid.out.println(fIter(n));
	}
}

