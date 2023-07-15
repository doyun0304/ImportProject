package util;

public class DVec2D {
    public double x;
    public double y;
    public DVec2D(){
        this.x = 0;
        this.y = 0;
    }
    public DVec2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(DVec2D v){
        x = x+v.x;
        y = y+v.y;
    }

    public void sub(DVec2D v){
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

    public double dist(DVec2D v){
        return Math.sqrt((x-v.x)*(x-v.x)+(y-v.y)*(y-v.y));
    }
    public static DVec2D add(DVec2D a, DVec2D b){
        return new DVec2D(a.x+b.x, a.y+b.y);
    }

    public static DVec2D sub(DVec2D a, DVec2D b){
        return new DVec2D(a.x-b.x, a.y-b.y);
    }

    public static DVec2D mul(DVec2D a, double f){
        return new DVec2D(f*a.x, f*a.y);
    }

    public static DVec2D div(DVec2D a, double f){
        try{
            return new DVec2D(a.x/f, a.y/f);
        } catch (Exception e){
            System.out.println("Vec2D Error: divide by 0");
            e.printStackTrace();
        }
        return new DVec2D();
    }
}
