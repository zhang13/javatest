package com.test.gps;

/*****
 * 取两坐标之间的距离
 *****/
public class GetDistance {
    private static double EARTH_RADIUS = 6378.137;//地球半径
    private static double rad(double d)
    {
       return d * Math.PI / 180.0;
    }
    public static double getDistance(double lat1, double lng1, double lat2, double lng2)
    {
       double radLat1 = rad(lat1);
       double radLat2 = rad(lat2);
       double a = radLat1 - radLat2;
       double b = rad(lng1) - rad(lng2);
       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
       s = s * EARTH_RADIUS;
       s = Math.round(s * 10000*1000) / 10000;//米
       return s;
    }
    
    public static double getDistance(){
    	double x1=110.43729658;
    	double y1=33.472249037;
    	double x2=110.569958263;
		double y2=33.453205774;
		return getDistance(y1,x1,y2,x2);
    }
}