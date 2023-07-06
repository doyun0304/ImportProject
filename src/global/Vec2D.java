package global;

public class Vec2D {
    double x;
    double y;

    public Vec2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vec2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vec2D v){
        x = x+v.x;
        y = y+v.y;
    }

    public void sub(Vec2D v){
        x = x-v.x;
        y = y-v.y;
    }

    public void mul(double f){
        x = f*x;
        y = f*y;
    }

    public void div(double f){
        try{
            x = x/f;
            y = y/f;
        } catch (Exception e) {
            System.out.println("Vec2D Error: div");
            e.printStackTrace();
        }
    }

    public static Vec2D add(Vec2D a, Vec2D b){
        return new Vec2D(a.x+b.x, a.y+b.y);
    }

    public static Vec2D sub(Vec2D a, Vec2D b){
        return new Vec2D(a.x-b.x, a.y-b.y);
    }

    public static Vec2D mul(Vec2D a, double f){
        return new Vec2D(f*a.x, f*a.y);
    }

    public static Vec2D div(Vec2D a, double f){
        try{
            return new Vec2D(a.x/f, a.y/f);
        } catch (Exception e){
            System.out.println("Vec2D Error: divide by 0");
            e.printStackTrace();
        }
        return new Vec2D();
    }
}
