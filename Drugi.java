/* Program koji rekurzivnom metodom racuna i ispisuje
 zbir cifara unetog prirodnog broja.
*/

class Drugi{
	
	static int zbirCifara(int n, int s){
		if(n<10){
			return n;
		}
		else{
			return n%10 + zbirCifara(n/10, s);
		}
	}
	
	public static void main(String[] args){
		int n;
		do{
			n = Svetovid.in.readInt("Unesite prirodan broj: ");
		}while(n<1);
		System.out.println(zbirCifara(n, 0));
		
		
	}
}
