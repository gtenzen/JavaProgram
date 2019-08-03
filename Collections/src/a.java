import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class a {
    public int solution(int[][] A) {
        // write your code in Java SE 8
        
    	int rows=A.length;
    	int col= A[0].length;
    	List<Integer>sumOfRows=new ArrayList<Integer>();
    	List<Integer>sumOfCols=new ArrayList<Integer>();
    	
    	
    	for(int i=0;i<rows;i++) {
    		int sum=0;
    		for(int j=0;j<col;j++) {
        		sum=sum+A[i][j];
    			
        	}
    		sumOfRows.add(sum);
    		
        	
    	}
    	for(int i=0;i<col;i++) {
    		int sum=0;
    		for(int j=0;j<rows;j++) {
        		sum=sum+A[j][i];
    			
        	}
    		sumOfCols.add(sum);
    		
        	
    	}
    	//System.out.println("A");
    	List<Integer>rowEq=new ArrayList<>();
    	for(int i=1;i<sumOfRows.size();i++) {
    		 int up=i-1;
    		 int down=i+1;
    		 int sum=0;
    		 //System.out.println(i);
    		while (up>=0) {
    			
    			sum+=sumOfRows.get(up);
    			up--;
    		}
    		while (down<sumOfRows.size()) {
    			
    			sum-=sumOfRows.get(down);
    			down++;
    		}
    		//System.out.println(sum);
    		if(sum==0) {
    			rowEq.add(i);
    		}
    	}
    	//System.out.println("B");
    	List<Integer>colEq=new ArrayList<>();
    	for(int i=1;i<sumOfCols.size();i++) {
    		 int up=i-1;
    		 int down=i+1;
    		 int sum=0;
    		while (up>=0) {
    			
    			sum+=sumOfCols.get(up);
    			up--;
    		}
    		while (down<sumOfCols.size()) {
    			
    			sum-=sumOfCols.get(down);
    			down++;
    		}
    		if(sum==0) {
    			colEq.add(i);
    		}
    	}
    	
        return rowEq.size() * colEq.size();
    }
    
    public static void main(String[] args) {
		
    	int ab[][] ={{2,7,5},{3,1,1},{2,1,-7},{0,2,1},{1,6,8}};
    	
    	a sol=new a();
    	System.out.println(sol.solution(ab));
    	
	}
}
