package second;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] a) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        int m = a.length;
        if(m == 0){
            return r;
        }
        int n = a[0].length;
        if(n == 0){
            return r;
        }
        for(int i=0;m-2*i>0 && n-2*i > 0; i++){
            visit(r, a, i, m-2*i, n-2*i);
        }
        return r;
    }
    
    void visit(ArrayList<Integer> r, int[][] a, int k, int m, int n){
        if(m == 1){
            for(int i=0;i<n;i++){
                r.add(a[k][k+i]);
            }
        }else if(n == 1){
            for(int i=0;i<m;i++){
                r.add(a[k+i][k]);
            }
        }else {
            for(int i=0;i<n-1;i++){
                r.add(a[k][k+i]);
            }
            for(int i=0;i<m-1;i++){
                r.add(a[k+i][k+n-1]);
            }
            for(int i=0;i<n-1;i++){
                r.add(a[k+m-1][k+n-1-i]);
            }
            for(int i=0;i<m-1;i++){
                r.add(a[k+m-1-i][k]);
            }
        }
    }
}
