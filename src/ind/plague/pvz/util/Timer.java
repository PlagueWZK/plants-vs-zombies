package ind.plague.pvz.util;


/**
 * @author PlagueWZK
 * description: Timer
 * date: 2025/5/12 17:46
 */
@SuppressWarnings("unused")
public class Timer {
    private long passedTime;
    private long interval;
    private boolean isPaused;
    private boolean finished;
    private boolean loop;
    private Runnable callback;

    public Timer(long ms, boolean loop, Runnable callback) {
        this.interval = ms * 1000_000;
        this.loop = loop;
        this.callback = callback;
    }

    public Timer(boolean loop, Runnable callback) {
        this.loop = loop;
        this.callback = callback;
    }

    public void update(long deltaTime) {
        if (isPaused) {
            return;
        }
        passedTime += deltaTime;
        if (passedTime >= interval) {
            if (loop || (!finished) && callback != null) {
                callback.run();
                finished = true;
                passedTime = 0;
            }
        }
    }

    public void reset() {
        passedTime = 0;
        finished = false;
    }

    /**
     * 设置计时器的时间间隔
     *
     * @param ms 时间间隔，单位为毫秒
     */
    public void setInterval(long ms) {
        if (ms <= 0 || ms == interval) {
            return;
        }
        interval = ms * 1000_000;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setCallback(Runnable callback) {
        this.callback = callback;
    }

    public void paused() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }
}
