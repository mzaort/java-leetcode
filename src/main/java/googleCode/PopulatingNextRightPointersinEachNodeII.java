package googleCode;

public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while(head != null){
        	TreeLinkNode p = head, q = null;
        	head = null;
        	while(p != null){
        		if(p.left == null){
        			if(p.right == null){
        				//
        			}else{
        				if(q == null){
        					head = q = p.right;
        				}else{
        					q.next = p.right;
        					q = q.next;
        				}
        			}
        		}else{
        			if(p.right == null){
        				if(q == null){
        					head = q = p.left;
        				}else{
        					q.next = p.left;
        					q = q.next;
        				}
        			}else{
        				p.left.next = p.right;
        				if(q == null){
        					head = p.left;
        				}else{
        					q.next = p.left;
        				}
        				q = p.right;
        			}
        		}
        		p = p.next;
        	}
        }
    }
    
    public void connect2(TreeLinkNode root) {
    	if(root == null) return;
    	TreeLinkNode f = new TreeLinkNode(0);
    	f.next = root;
    	while(f.next != null){
    		TreeLinkNode p = f.next, r = f;
    		r.next = null;
    		while(p != null){
    			if(p.left != null){
    				r.next = p.left;
    				r = r.next;   				
    			}
    			if(p.right != null){
    				r.next = p.right;
    				r = r.next;
    			}
    		}
    	}
    }
    
    public void connect3(TreeLinkNode root){
    	TreeLinkNode f = new TreeLinkNode(0), p = root;
    	while(p != null){
    		TreeLinkNode q = f;
    		for(; p != null; p = p.next){
    			if(p.left != null){
    				q.next = p.left;
    				q = q.next;
    			}
    			if(p.right != null){
    				q.next = p.right;
    				q = q.next;
    			}
    		}
    		p = f.next;
    		f.next = null;
    	}
    }
}
