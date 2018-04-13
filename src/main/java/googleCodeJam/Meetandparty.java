package googleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Meetandparty {
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sin = new Scanner(new File("B-small-practice.in"));
		PrintWriter pwr = new PrintWriter(new File("B-small-practice.out"));
		int cnt = sin.nextInt();
		for(int k = 1; k <= cnt; k++){
			int line = sin.nextInt();
			List<Rectangle> list = new ArrayList<Rectangle>(line);
			for (int i = 0; i < line; i++) {
				int x1 = sin.nextInt();
				int y1 = sin.nextInt();
				int x2 = sin.nextInt();
				int y2 = sin.nextInt();
				list.add(new Rectangle(x1, y1, x2, y2));
			}
			int[] res = minDistance(list);
			pwr.println("Case #" + k + ": " + res[0] + " " + res[1] + " " + res[2]);
		}
		sin.close();
		pwr.close();
	}
	
	private static int[] minDistance(List<Rectangle> list) {
		Collections.sort(list);
		int[] res = {0, 0, Integer.MAX_VALUE};
		for(int i = 0; i < list.size(); i++){
			Rectangle r = list.get(i);
			int val = r.distance();
			for(int j = 0; j < i; j++){
				val += r.distance(list.get(j));
			}
			for(int j = i + 1; j < list.size(); j++){
				val += r.distance(list.get(j));
			}
			if(val < res[2]){
				res[0] = (r.x1 + r.x2) / 2;
				res[1] = (r.y1 + r.y2) / 2;
				res[2] = val;
			}
		}
		return res;
	}	
}

class Rectangle implements Comparable<Rectangle>{
	int x1;
	int y1;
	int x2;
	int y2;
	public Rectangle(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public int distance(Rectangle o) {
		int x = (x1 + x2) / 2;
		int y = (y1 + y2) / 2;
		int ox = (o.x1 + o.x2) / 2;
		int oy = (o.y1 + o.y2) / 2;
		return (Math.abs(x - ox) + Math.abs(y - oy)) * (o.x2 - o.x1 + 1) * (o.y2 - o.y1 + 1);
	}
	public int distance() {
		int x = (x1 + x2) / 2;
		int y = (y1 + y2) / 2;
		int val = 0;
		for(int i = x1; i <= x2; i++){
			for(int j = y1; j <= y2; j++){
				val += Math.abs(x - i) + Math.abs(y - j);
			}
		}
		return val;
	}
	@Override
	public int compareTo(Rectangle o) {
		int x = (x1 + x2) / 2;
		int y = (y1 + y2) / 2;
		int ox = (o.x1 + o.x2) / 2;
		int oy = (o.y1 + o.y2) / 2;
		if(x > ox){
			return 1;
		}else if(x < ox){
			return -1;
		}else{
			if(y > oy){
				return 1;
			}else if(y < oy){
				return -1;
			}else{
				return 0;
			}
		}
	}
}