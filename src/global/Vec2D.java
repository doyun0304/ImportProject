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

    public Vec2D add(Vec2D v){
        return new Vec2D(x+v.x, y+v.y);
    }

    public Vec2D sub(Vec2D v){
        return new Vec2D(x-v.x, y-v.y);
    }

    public Vec2D mul(double f){
        return new Vec2D(f*x, f*y);
    }

    public Vec2D div(double f){
        try{
            return new Vec2D(x/f, y/f);
        } catch (Exception e){
            System.out.println("Vec2D Error: divide by 0");
            e.printStackTrace();
        }
        return new Vec2D();
    }
}
