package first;


public class ContainerWithMostWater {
	//Brute force with time O(n^2)
	public static int getLargestContainerForce(int[] a){
		if(a.length <= 1){
			return 0;
		}
		
		int max = 0;
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				int h = Math.min(a[i], a[j]);
				if(h*(j-i) > max){
					max = h*(j-i);
				}
			}
		}
		return max;
	}
	
	//Time: O(n)
	public static int getLargestContainer(int[] a){
		int max = 0;
		int i = 0;
		int j = a.length -1;
		while(i < j){
			int h = Math.min(a[i], a[j]);
			if(h*(j-i) > max){
				max = h*(j-i);
			}
			if(a[i] == a[j]){
				i++;
				j--;
			}else if(a[i] < a[j]){
				i++;
			}else{
				j--;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
	}
}
