/* Napisati program koji za dati ceo broj n, 0 <= n <= 40, ispisuje vrednost
   elementa rekurentnog niza realnih brojeva f_n. Niz je definisan na sledeci nacin:
   f_n = 2 + f_n-1 / g_n-2, n >= 2
   g_n = 1 + g_n-1 / f_n-2, n >= 2
   f_1 = 1, f_0 = 2
   g_1 = 2, g_0 = 1
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */
 
class Petnaesti{
	
	static double fDef(int n){
		if(n==0)
			return 2;
		else if(n==1)
			return 1;
		else
			return 2 + fDef(n-1) / fDef2(n-2);
	}
	
	static double fDef2(int n){
		if(n==0)
			return 1;
		else if(n==1)
			return 2;
		else
			return 1 + fDef2(n-1) / fDef(n-2);
	}
	
	static double fRek1(double f1, double f0, double g1, double g0, int i, int n){
		if(i>n)
			return f1;
		else
			return fRek1(2+f1/g0, f1, 1+g1/f0, g1, i+1, n);
	}
	
	static double fRek2(int n){
		if(n==0)
			return 2;
		else if(n==1)
			return 1;
		else
			return fRek1(1, 2, 2, 1, 2, n);
	}
	
	static double fIter(int n){
		double fn = 0.0, gn = 0.0, f1 = 1.0, f0 = 2.0, g1 = 2.0, g0 = 1.0;
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else{
			for(int i = 2; i<=n; i++){
				fn = 2.0+f1/g0;
				gn = 1.0+g1/f0;
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
		
		Svetovid.out.println(fDef(n));
		Svetovid.out.println(fRek2(n));
		Svetovid.out.println(fIter(n));
	}
}

