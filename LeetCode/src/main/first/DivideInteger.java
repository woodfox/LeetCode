package first;
public class DivideInteger {
	//Will throw TLE error
	public int divide(int a, int b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		long c = (long)a;
		long d = (long)b;
		boolean sign = true;
		if (c < 0 && d < 0) {
			sign = true;
			c = changeSign(c);
			d = changeSign(d);
		} else if (c < 0 && d > 0) {
			sign = false;
			c = changeSign(c);
		} else if (c > 0 && d < 0) {
			sign = false;
			d = changeSign(d);
		}

		long count = 0;
		long plus = 0;
		while(c >= d){
			long tmp = d<<plus;
			if(c >= tmp){
				count += 1<<plus;
				c = c - tmp;
				plus++;
			}else{
				plus--;
			}			
		}
		
		if(!sign){
			count = changeSign(count);
		}
		
		return (int)count;
	}
	
	long changeSign(long a){
		return ~a + 1;
	}
	
	public static void main(String[] args){
		DivideInteger d = new DivideInteger();
		System.out.println(d.divide(5, 2));
		System.out.println(d.divide(9, 1));
		System.out.println(d.divide(-19, 5));
		System.out.println(d.divide(99, -8));
		System.out.println(d.divide(-2147483648, 2));
	}
}
