/* Napisati program koji za dati ceo broj n, 0 <= n <= 40, ispisuje vrednost
 elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
 f_n = f_n-1 + g_n-2, n >= 2, poslednja cifra n je >= 5
 f_n = f_n-2 - g_n-1, n >= 2, poslednja cifra n je < 5
 g_n = g_n-1 - 2f_n-2, n >= 2, n neparno
 g_n = g_n-2 + 2f_n-1, n >= 2, n parno
 f_1 = 0, f_0 = -1
 g_1 = 1, g_0 = 0
 Element f_n izracunati:
 (a) rekurzivno preko definicije,
 (b) rekurzivno pomocu akumulirajuceg parametra,
 (c) iterativno.
 U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/

class Jedanaesti {
	
	static int fDef(int n){
		if(n==0)
			return -1;
		else if(n==1)
			return 0;
		else{
			if(n%10>=5)
				return fDef(n-1) + fDef2(n-2);
			else
				return fDef(n-2) + fDef2(n-1);
		}
	}
	
	static int fDef2(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else{
			if(n%2==0)
				return fDef2(n-1) - 2*fDef(n-2);
			else
				return fDef2(n-2) + 2*fDef(n-1);
		}
	}
	
	static int fRek1(int f1, int f0, int g1, int g0, int i, int n){
		if(i>n)
			return f1;
		else{
			if(i%10>=5){
				if(i%2==0)
					return fRek1(f1+g0, f1, g1-2*f0, g1, i+1, n);
				else
					return fRek1(f1+g0, f1, g0+2*f1, g1, i+1, n);
			}
			else{
				if(i%2==0)
					return fRek1(f0+g1, f1, g1-2*f0, g1, i+1, n);
				else
					return fRek1(f0+g1, f1, g0+2*f1, g1, i+1, n);
			}
		}
	}
	
	static int fRek2(int n){
		if(n==0)
			return -1;
		else if(n==1)
			return 0;
		else
			return fRek1(0, -1, 1, 0, 2, n);
	}
	
	static int fIter(int n){
		int fn = 0, gn = 0, f0 = -1, f1 = 0, g0 = 0, g1 = 1;
		
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else{
			for(int i = 2; i<=n; i++){
				if(i%10>=5)
					fn = f1+g0;
				else
					fn = f0+g1;
				if(i%2 == 0)
					gn = g1-2*f0;
				else
					gn = g0+2*f1;
				
				f0 = f1;
				f1 = fn;
				g0 = g1;
				g1 = gn;
			}
		}
		return fn;
	}
	
	
	static final int N_MAX = 40, N_MIN = 0;
	
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

