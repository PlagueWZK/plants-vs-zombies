package ind.plague.pvz.scene;


import java.awt.*;

/**
 * @author PlagueWZK
 * description: Scene
 * date: 2025/5/12 16:59
 */
@SuppressWarnings("unused")
public interface Scene {

    void update(long deltaTime);

    void draw(Graphics2D g);

    void onEnter();

    void onExit();

    void keyPressed(int code);

    void keyReleased(int code);

    void mousePressed(int code);

    void mouseReleased(int code);

    void setMouseX(int mouseX);

    void setMouseY(int mouseY);

    SceneType getSceneType();
}
