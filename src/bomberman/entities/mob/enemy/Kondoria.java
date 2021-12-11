package bomberman.entities.mob.enemy;

import bomberman.graphics.Sprite;
import javafx.scene.image.Image;

public class Kondoria extends Enemy {
    boolean visible = true;

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
        setSprite(Sprite.kondoria_dead);
        setSpeed(1);
        animate = 0;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void move() {
        if (!isRemoved()) {
            if (x % Sprite.SCALED_SIZE == 0 && y % Sprite.SCALED_SIZE == 0) {
                play();
                animate = 0;
            } else {
                animate++;
            }

            switch (getDirection()) {
                case 0: {
                    img = Sprite.movingSprite(Sprite.kondoria_right1, Sprite.kondoria_right2, Sprite.kondoria_right3, animate, 30).getFxImage();
                    x += getSpeed();
                    break;
                }
                case 1: {
                    img = Sprite.movingSprite(Sprite.kondoria_left1, Sprite.kondoria_left2, Sprite.kondoria_left3, animate, 30).getFxImage();
                    x -= getSpeed();
                    break;
                }
                case 2: {
                    y -= getSpeed();
                    break;
                }
                case 3: {
                    y += getSpeed();
                    break;
                }
                default: {
                    break;
                }
            }
            if (!visible) img = Sprite.none.getFxImage();
        }
    }

    public void play() {
        visible = !(Math.random() * 10 <= 2);
        randomMove();
    }
}
