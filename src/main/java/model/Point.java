package model;

import java.io.Serializable;
import java.util.Objects;

public class Point implements Serializable
{
    private static final int MIN_X = -5;
    private static final int MAX_X = 3;

    private static final int MIN_Y = -5;
    private static final int MAX_Y = 3;

    private Double x;
    private Double y;

    public Point()
    {
        x = null;
        y = null;
    }

    public Double getX()
    {
        return x;
    }

    public void setX(Double x)
    {
        if (x < MIN_X || x > MAX_X) {
            final String message =
                    "Неверно указан параметр ‘x’. " +
                            "Пожалуйста, укажите значение из интервала " +
                            "[" + MIN_X + ", " + MAX_X + "]." +
                            "<br>\n";
            throw new IllegalArgumentException(message);
        }
        this.x = x;
    }

    public Double getY()
    {
        return y;
    }

    public void setY(Double y)
    {
        if (y < MIN_Y || y > MAX_Y) {
            final String message =
                    "Неверно указан параметр ‘y’. " +
                            "Пожалуйста, укажите значение из интервала " +
                            "(" + MIN_Y + ", " + MAX_Y + ")." +
                            "<br>\n";
            throw new IllegalArgumentException(message);
        }
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("(%.2f, %.2f)", getX(), getY());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}