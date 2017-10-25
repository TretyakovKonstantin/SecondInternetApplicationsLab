package model;

public class Area
{
    private static final int MIN_RADIUS = 1;
    private static final int MAX_RADIUS = 3;

    private double radius;

    public Area(double radius)
    {
        setRadius(radius);
    }

    public boolean contains(Point point)
    {
        double x = point.getX();
        double y = point.getY();
        double halfRadius = (double) getRadius() / 2;

        boolean inTriangle =
                (-halfRadius <= x && x <= 0) &&
                        (0 <= y && y <= halfRadius) &&
                        (y - x) <= halfRadius;

        boolean inCircleQuadrant =
                (x <= 0 && y <= 0) &&
                        (x * x + y * y <= halfRadius * halfRadius);

        boolean inRectangle =
                (0 <= x && x <= radius) &&
                        (0 <= y && y <= halfRadius);

        return inTriangle || inCircleQuadrant || inRectangle;
    }

    public double getRadius()
    {
        return radius;
    }

    private void setRadius(double radius)
    {
        if (radius < MIN_RADIUS || radius > MAX_RADIUS) {
            final String message =
                    "Неверно указан параметр ‘r’. " +
                            "Пожалуйста, укажите целое значение " +
                            "от " + MIN_RADIUS + " до " + MAX_RADIUS + "." +
                            "<br>\n";
            throw new IllegalArgumentException(message);
        }
        this.radius = radius;
    }
}