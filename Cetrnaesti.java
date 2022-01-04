/* Napisati program koji za dati ceo broj n, 0 <= n <= 35, ispisuje vrednost
   elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
   f_n = -f_n-1 + f_n-2 - 2*f_n-3, n mod 3 = 2, n >= 3
   f_n = 2f_n-2 - 3*f_n-3, n mod 3 = 1, n >= 3
   f_n = f_n-1 + f_n-3, n mod 3 = 0, n >= 3
   f_2 = 1, f_1 = 2, f_0 = 3
   Element f_n izracunati:
    (a) rekurzivno preko definicije,
    (b) rekurzivno pomocu akumulirajuceg parametra,
    (c) iterativno.
   U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
 */ 
class Cetrnaesti {
	
	static int fDef(int n) {
		if (n == 0)
		  return 3;
		else if (n == 1)
		  return 2;
		else if (n == 2)
		  return 1;
		else if (n % 3 == 2)
		  return -fDef(n-1) + fDef(n-2) - 2*fDef(n-3);
		else if (n % 3 == 1)
		  return 2*fDef(n-2) - 3*fDef(n-3);
		else
		  return fDef(n-1) + fDef(n-3);
	}
	
	static int fRek1(int f2, int f1, int f0, int i, int n){
		if(i>n)
			return f2;
		else{
			if(n%3==2)
				return fRek1(-f2+f1-2*f0, f2, f1, i+1, n);
			else if(n%3==1)
				return fRek1(2*f1-3*f0, f2, f1, i+1, n);
			else
				return fRek1(f2+f0, f2, f1, i+1, n);
		}
	}
	
	static int fRek2(int n){
		if(n==0)
			return 3;
		else if(n==1)
			return 2;
		else if(n==2)
			return 1;
		else
			return fRek1(1, 2, 3, 3, n);
		
	}
	
	static int fIter(int n){
		int fn = 0, f2 = 1, f1 = 2, f0 = 3;
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else if(n==2)
			fn = f2;
		else{
			for(int i = 3; i<=n; i++){
				if(n%3==2)
					fn = -f2+f1-2*f0;
				else if(n%3==1)
					fn = 2*f1-3*f0;
				else
					fn = f2+f0;
				f0 = f1;
				f1 = f2;
				f2 = fn;
			}
		}
		return fn;
	}
	
	static final int N_MAX = 35, N_MIN = 0;
	
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

