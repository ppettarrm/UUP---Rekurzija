/* Program koji ucitava string i rekurzivnom metodom 
 odredjuje da li je uneti string palindrom.
*/

class Cetvrti{
	
	static boolean palindrom(String s, int p, int k){
		if(p>=k)
			return true;
		else if(s.charAt(p)==s.charAt(k))
			return palindrom(s, p+1, k-1);
		else
			return false;
	}
	
	public static void main(String[] args){
		System.out.print("Unesite string: ");
		String s = Svetovid.in.readLine();
		if (palindrom(s, 0, s.length()-1)) {
		System.out.println("Uneti string jeste palindrom.");
		}
		else {
		System.out.println("Uneti string nije palindrom.");
		}
	}
}
