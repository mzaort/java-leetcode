package googleCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
        	if(height[i] < height[j]){
        		int tmp = height[i] * (j - i);
        		if(res < tmp) res = tmp;
        		i++;
        	}else{
        		int tmp = height[j] * (j - i);
        		if(res < tmp) res = tmp;
        		j--;
        	}
        }
        return res;
    }
    public int maxArea2(int[] height) {
        int res = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
        	int area = (j - i) * (height[i] > height[j] ? height[j] : height[i]);
        	if(res < area) res = area;
        	if(height[i] < height[j]){		
        		i++;
        	}else{        		
        		j--;
        	}
        }
        return res;
    }
}
