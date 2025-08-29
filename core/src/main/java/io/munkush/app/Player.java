package io.munkush.app;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class Player {
    private final ShapeRenderer shapeRenderer;
    private final float width;
    private final float height;
    private float x;
    private float y;
    private Color color;

    private boolean isMovingTop;
    private boolean isMovingBottom;
    private boolean isMovingLeft;
    private boolean isMovingRight;

    public Player(float width, float height, Color color) {
        isMovingTop = true;
        isMovingRight = true;

        this.shapeRenderer = new ShapeRenderer();

        this.height = height;
        this.width = width;
        this.color = color;

        this.x = SizeUtils.getCenterX(width);
        this.y = SizeUtils.getCenterY(height);
    }
    public void render(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(color);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }
    public void dispose(){
        shapeRenderer.dispose();
    }
    public void startMoving(){
        if(isMovingTop){
            if(hasReachedTop()){
                changeToRandomColor();
                isMovingTop = false;
                isMovingBottom = true;
            }
            moveTop();
        }
        if(isMovingBottom){
            if(hasReachedBottom()){
                changeToRandomColor();
                isMovingTop = true;
                isMovingBottom = false;
            }
            moveBottom();
        }

        if(isMovingRight){
            if(hasReachedRight()){
                changeToRandomColor();
                isMovingRight = false;
                isMovingLeft = true;
            }
            moveRight();
        }

        if(isMovingLeft){
            if(hasReachedLeft()){
                changeToRandomColor();
                isMovingLeft = false;
                isMovingRight = true;
            }
            moveLeft();
        }
    }
    public void moveTop(){
        y++;
    }
    public void moveBottom(){
        y--;
    }
    public void moveRight(){
        x++;
    }
    public void moveLeft(){
        x--;
    }
    private void changeToRandomColor() {
        float r = (float) Math.random();
        float g = (float) Math.random();
        float b = (float) Math.random();
        this.color = new Color(r, g, b, 1f);
    }
    private boolean hasReachedTop() {
        return y + height >= Window.HEIGHT;
    }
    private boolean hasReachedBottom() {
        return y <= 0;
    }
    private boolean hasReachedLeft() {
        return x <= 0;
    }
    private boolean hasReachedRight() {
        return x + width >= Window.WIDTH;
    }
}
