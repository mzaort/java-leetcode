package solution;

public class AddBinary {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        
        int surplus = 0;
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        StringBuilder sb = new StringBuilder(ia > ib ? ia+1:ib+1);
        while(ia >= 0 && ib >= 0){
        	int tmp = surplus + a.charAt(ia--) + b.charAt(ib--) - 2 * '0';
        	surplus = tmp / 2;
        	sb.append(tmp % 2);
        }
        
        while(ia >= 0){
        	int tmp = surplus + a.charAt(ia--) - '0';
        	surplus = tmp / 2;
        	sb.append(tmp % 2);
        }
        
        while(ib >= 0){
        	int tmp = surplus + b.charAt(ib--) - '0';
        	surplus = tmp / 2;
        	sb.append(tmp % 2);
        }
        
        if(surplus != 0){
        	sb.append(surplus);
        }
        
        return new String(sb.reverse());
    }
}
