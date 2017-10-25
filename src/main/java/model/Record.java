package model;
import java.io.Serializable;
import java.util.Objects;

public class Record implements Serializable
{
    private Point point;
    private Double radius;
    private String result;

    public Double getRadius()
    {
        return radius;
    }

    public void setRadius(Double radius)
    {
        this.radius = radius;
    }

    public Point getPoint()
    {
        return point;
    }

    public void setPoint(Point point)
    {
        this.point = point;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(point, radius, result);
    }

    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof Record) &&
                point.equals(((Record) obj).getPoint()) &&
                radius.equals(((Record) obj).getRadius()) &&
                result.equals(((Record) obj).getResult());
    }
}