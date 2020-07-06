package com.chao.picture;

import java.util.ArrayList;
import java.util.List;

public class TestPic {
    /**
     * 获取不规则多边形重心点
     *
     * @param mPoints
     * @return
     */
    public static LatLng getCenterOfGravityPoint(List<LatLng> mPoints) {
        double area = 0.0;//多边形面积
        double Gx = 0.0, Gy = 0.0;// 重心的x、y
        for (int i = 1; i <= mPoints.size(); i++) {
            double iLat = mPoints.get(i % mPoints.size()).latitude;
            double iLng = mPoints.get(i % mPoints.size()).longitude;
            double nextLat = mPoints.get(i - 1).latitude;
            double nextLng = mPoints.get(i - 1).longitude;
            double temp = (iLat * nextLng - iLng * nextLat) / 2.0;
            area += temp;
            Gx += temp * (iLat + nextLat) / 3.0;
            Gy += temp * (iLng + nextLng) / 3.0;
        }
        Gx = Gx / area;
        Gy = Gy / area;
        return new LatLng(Gx, Gy);
    }

    static class LatLng {
        public double latitude;
        public double longitude;

        public LatLng(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }


    public static void main(String[] args) {
        List<LatLng> points = new ArrayList<>();
        points.add(new LatLng(116.370716,39.910087));
        points.add(new LatLng(116.37196,39.90984));
        points.add(new LatLng(116.371552,39.908663));
        points.add(new LatLng(116.370088,39.909144));
//        [],[],[],[]
        LatLng centerOfGravityPoint = getCenterOfGravityPoint(points);
        System.out.println(centerOfGravityPoint);
    }
}
