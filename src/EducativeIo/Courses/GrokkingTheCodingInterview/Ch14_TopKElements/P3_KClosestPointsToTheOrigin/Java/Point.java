package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P3_KClosestPointsToTheOrigin.Java;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        // ignoring sqrt
        return (x * x) + (y * y);
    }
}
