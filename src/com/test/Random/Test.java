package com.test.Random;

import java.util.Arrays;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random(47);
		System.out.println(rand.nextInt(100));
		System.out.println(rand.nextInt(100));
		System.out.println(rand.nextInt(100));
		System.out.println(rand.nextInt(100));
		
		int y = Integer.MAX_VALUE;
		int x = -2;
		System.out.println(y);
		System.out.println(y*2);
		System.out.println(x);
		System.out.println((double)y*2);
		
		for(double i=0;i<Double.MAX_VALUE;i++){
			x++;
			if(x==Integer.MAX_VALUE){
				System.out.println(i);
				break;
			}
		}
		
		//
		/*int a=1;
		int b=1;
		int j;
		for(int i=0;i<10;i++){
			j=a+b;
			a=b;
			b=j;
			System.out.println(j);
		}*/
		
		for(int i=10;i<100;i++){
			for(int j1=10;j1<100;j1++){
				int result =i*j1;
				if(result>9999||result<1000||result%100==0||(result-i-j1)%9!=0)continue;
				String resultStr=result+"";
				String[]resultSort = resultStr.split("");
				Arrays.sort(resultSort);
				String []res2 = (String.valueOf(i)+String.valueOf(j1)).split("");
				Arrays.sort(res2);
				if(Arrays.equals(resultSort, res2)){
					System.out.println(resultStr+":"+i+"*"+j1);
				}
			}
		}
		
		
	}

}
