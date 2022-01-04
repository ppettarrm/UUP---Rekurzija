/* Napisati program koji za dati ceo broj n, 0 <= n <= 40, ispisuje vrednost
 elementa rekurentnog niza f_n. Niz je definisan na sledeci nacin:
 f_n = f_n-1 - 2f_n-2, n neparno, n >= 3
 f_n = f_n-2 + 3f_n-3, n parno, n >= 3
 f_2 = 2, f_1 = 3, f_0 = 1
 Element f_n izracunati:
 (a) rekurzivno preko definicije,
 (b) rekurzivno pomocu akumulirajuceg parametra,
 (c) iterativno.
 U slucajevima (b) i (c) voditi racuna o efikasnosti resenja.
*/

class Deveti {
	
	static int fDef(int n){
		if(n==0)
			return 1;
		else if(n==1)
			return 3;
		else if(n==2)
			return 2;
		else{
			if(n%2==0)
				return fDef(n-1) - 2*fDef(n-2);
			else
				return fDef(n-2) + 3*fDef(n-3);
		}
	}
	
	static int fRek2(int n){
		if(n==0)
			return 1;
		else if(n==1)
			return 3;
		else if(n==2)
			return 2;
		else
			return fRek1(2, 3, 1, 3, n);
	}
	
	static int fRek1(int f2, int f1, int f0, int i, int n){
		if(i>n)
			return f2;
		else{
			if(i%2==0)
				return fRek1(f2-2*f1, f2, f1, i+1, n);
			else
				return fRek1(f1+3*f0, f2, f1, i+1, n);
		}
	}
	
	static int fIter(int n){
		int fn=0, f0=1, f1=3, f2=2;
		
		if(n==0)
			fn = f0;
		else if(n==1)
			fn = f1;
		else if(n==2)
			fn=f2;
		else{
			for(int i=3; i<=n; i++){
				if(i%2==0)
					fn = f2-2*f1;
				else 
					fn = f1+3*f0;
				f0 = f1;
				f1 = f2;
				f2 = fn;
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

