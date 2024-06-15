package engine.util;

public class Vector2D {

    public double x, y;

    public Vector2D() { x = 0; y = 0; }

    public Vector2D(double vx, double vy) { x = vx; y = vy; }

    public Vector2D(double v) { this(v, v); }

    public Vector2D(Vector2D v) { this(v.x, v.y); }



    @Override
    public Vector2D clone() throws CloneNotSupportedException {
        super.clone();
        return new Vector2D(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj instanceof Vector2D v) { return (x == v.x) && (y == v.y); }
        return false;
    }

    @Override
    public String toString() { return String.format("[%s, %s]", x, y); }



    public static Vector2D ToCartesian(double magnitude, double angle) {
        return new Vector2D(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
    }

    public static Vector2D Add(Vector2D v1, Vector2D v2) { return new Vector2D(v1.x + v2.x, v1.y + v2.y); }

    public static Vector2D Subtract(Vector2D v1, Vector2D v2) { return new Vector2D(v1.x - v2.x, v1.y - v2.y); }

    public static double Dot(Vector2D v1, Vector2D v2) { return v1.x * v2.x + v1.y * v2.y; }

    public static double Cross(Vector2D v1, Vector2D v2) { return v1.x * v2.x - v1.y * v2.y; }

    public static double Project(Vector2D v1, Vector2D v2) { return Dot(v1, v2) / v1.GetLength(); }

    public static Vector2D GetProjectedVector(Vector2D v1, Vector2D v2) {
        return v1.GetNormalized().GetMultiplied(Dot(v1, v2) / v1.GetLength());
    }



    public void Set(double vx, double vy) { x = vx; y = vy; }

    public void Set(double v) { Set(v, v); }

    public void Set(Vector2D v) { Set(v.x, v.y); }

    public void SetZero() { Set(0); }



    public void Add(double vx, double vy) { x += vx; y += vy; }

    public void Add(double v) { Add(v, v); }

    public void Add(Vector2D v) { Add(v.x, v.y); }



    public double GetSquareDistance(double vx, double vy) {
        vx -= x;
        vy -= y;
        return vx * vx + vy * vy;
    }

    public double GetSquareDistance(Vector2D v) { return GetSquareDistance(v.x, v.y); }

    public double GetDistance(double vx, double vy) {
        vx -= x;
        vy -= y;
        return Math.sqrt(vx * vx + vy * vy);
    }

    public double GetDistance(Vector2D v) { return GetDistance(v.x, v.y); }



    public void Normalize() {
        double magnitude = GetLength();
        x /= magnitude;
        y /= magnitude;
    }

    public Vector2D GetNormalized() {
        double magnitude = GetLength();
        return new Vector2D(x / magnitude, y / magnitude);
    }



    public void Subtract(double vx, double vy) { x -= vx; y =- vy; }

    public void Subtract(double v) { Subtract(v, v); }

    public void Subtract(Vector2D v) { Subtract(v.x, v.y); }



    public void Multiply(double vx, double vy) { x *= vx; y *= vy; }

    public void Multiply(double v) { Multiply(v, v); }

    public void Multiply(Vector2D v) { Multiply(v.x, v.y); }

    public Vector2D GetMultiplied(double scalar) { return new Vector2D(x * scalar, y * scalar); }



    public double Dot(double vx, double vy) { return x * vx + y * vy; }

    public double Dot(Vector2D v) { return Dot(v.x, v.y); }



    public double Cross(double vx, double vy) { return x * vx - y * vy; }

    public double Cross(double v) { return Cross(v, v); }

    public double Cross(Vector2D v) { return Cross(v.x, v.y); }



    public double Project(double vx, double vy) { return Dot(vx, vy) / GetLength(); }

    public double Project(Vector2D v) { return Project(v.x, v.y); }



    public void RotateBy(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        double rx = x * cos - y * sin;
        y = x * sin + y * cos;
        x = rx;
    }



    public void RotateTo(double angle) { Set(ToCartesian(GetLength(), angle)); }


    public void Reverse() { x = -x; y = -y; }

    public Vector2D GetReversed() { return new Vector2D(-x, -y); }

    public Vector2D GetRotatedBy(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Vector2D(x * cos - y * sin, x * sin + y * cos);
    }

    public Vector2D GetRotateTo(double angle) { return ToCartesian(GetLength(), angle); }

    public Vector2D GetProjectedVector(double vx, double vy) { return GetNormalized().GetMultiplied(Dot(vx, vy) / GetLength()); }

    public Vector2D GetProjectedVector(Vector2D v) { return GetProjectedVector(v.x, v.y); }

    public Vector2D GetAdded(Vector2D v) { return new Vector2D(x + v.x, y + v.y); }

    public Vector2D GetSubtracted(Vector2D v) { return new Vector2D(x - v.x, y - v.y); }

    public double GetAngle() { return Math.atan2(y, x); }

    public double GetLength() { return Math.sqrt(x * x + y * y); }

    public double GetSquareLength() { return x * x + y * y; }
}
