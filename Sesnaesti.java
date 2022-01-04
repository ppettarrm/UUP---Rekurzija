/* Napisati program koji za dati ceo broj n, 0 <= n <= 25, ispisuje vrednost
   elementa rekurentnog niza realnih brojeva f_n. Niz je definisan na sledeci nacin:
   f_n = 2f_n-1 / g_n-2 + f_n-2 / g_n-3, n >= 3, n parno
   f_n = g_n-1 / f_n-2 + 2g_n-2 / f_n-3, n >= 3, n neparno
   g_n = g_n-1 / f_n-1 + g_n-2 / f_n-2 + g_n-3 / f_n-3, n >= 3
   f_2 = 1, f_1 = 3, f_0 = 1
   g_2 = 2, g_1 = 2, g_0 = 2
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/
class Sesnaesti {
	
	static double fDef(int n){
		if(n==0)
			return 1;
		else if(n==1)
			return 3;
		else if(n==2)
			return 1;
		else{
			if(n%2==0)
				return 2*fDef(n-1)/fDef2(n-2) + fDef(n-2)/fDef2(n-3);
			else
				return fDef2(n-1)/fDef(n-2) + 2*fDef2(n-2)/fDef(n-3);
		}
	}
	
	static double fDef2(int n){
		if(n<3)
			return 2;
		else
			return fDef2(n-1)/fDef(n-1) + fDef2(n-2)/fDef(n-2) + fDef2(n-3)/fDef(n-3);
	}
	
	static double fRek1(double f2, double f1, double f0, double g2, double g1, double g0, int i, int n){
		if(i>n)
			return f2;
		else if(i%2==0)
			return fRek1(2*f2/g1+f1/g0, f2, f1, g2/f2+g1/f1+g0/f0, g2, g1, i+1, n);
		else
			return fRek1(g2/f1+2*g1/f0, f2, f1, g2/f2+g1/f1+g0/f0, g2, g1, i+1, n);
	}
	
	static double fRek2(int n){
		if(n==0)
			return 1;
		else if(n==1)
			return 3;
		else if(n==2)
			return 1;
		else
			return fRek1(1, 3, 1, 2, 2, 2, 3, n);
	}
	
	static double fIter(int n){
		double fn = 0, gn = 0, f2 = 1, f1 = 3, f0 = 1, g2 = 2, g1 = 2, g0 = 2;
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else if(n==2)
			fn = f2;
		else{
			for(int i = 3; i<=n; i++){
				if(i%2==0)
					fn = 2*f2/g1+f1/g0;
				else
					fn = g2/f1+2*g1/f0;
				gn = g2/f2+g1/f1+g0/f0;
				f0 = f1;
				f1 = f2;
				f2 = fn;
				g0 = g1;
				g1 = g2;
				g2 = gn;
			}
		}
		return fn;
	}
	
	
	static final int N_MAX = 25, N_MIN = 0;
	
	public static void main (String[] args) {
		int n;
		do{
			n = Svetovid.in.readInt("Unesite n:");
		}while(!(n>=N_MIN && n<=N_MAX));
		
		Svetovid.out.println(fDef(n));
		Svetovid.out.println(fRek2(n));
		Svetovid.out.println(fIter(n));
	}
}

