package io.munkush.app;

public class SizeUtils {
    public static float getCenterX(float width){
        return (Window.WIDTH - width) / 2;
    }

    public static float getCenterY(float height){
        return (Window.HEIGHT - height) / 2;
    }
}
