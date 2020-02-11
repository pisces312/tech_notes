package com.zeus.software.preventscreenlock;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zhang Jinzhong
 * @version V1.0
 * @since 2019-10-08 14:36
 */
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("开始执行防止屏幕lock");
        Random random = new Random();
        final int max = 800;
        while (true) {
            logger.info("执行操作");
            pressSingleKeyByNumber(KeyEvent.VK_PAUSE);
            try {
                final int millis = 180000;
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 模拟按下键盘单个按键，比如文档下一页：PgDn，上一页是PgUp等
     *
     * @param keycode：按键的值,如：KeyEvent.VK_PAGE_UP
     */
    public static final void pressSingleKeyByNumber(int keycode) {
        try {
            /** 创建自动化测试对象  */
            Robot robot = new Robot();
            /**按下按键*/
            robot.keyPress(keycode);
            /**松开按键*/
            robot.keyRelease(keycode);
            /**可以稍作延时处理*/
            robot.delay(500);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动将鼠标移动到指定的位置
     * 如果参数x与y为null,则默认将鼠标放在屏幕右侧中间隐藏
     *
     * @param x：x坐标 ,左上角 为0----设定值超过屏幕分辨率也没关系
     * @param y：y坐标 ,左上角 为0----设定值超过屏幕分辨率也没关系
     */
    public static final void mouseMoveToXY(Integer x, Integer y) {
        try {
            /**创建工具包对象*/
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            /**创建自动化对象*/
            Robot robot = new Robot();
            /**利用工具包对象获取屏幕分辨率*/
            if (x == null) {
                x = toolkit.getScreenSize().width;
            }
            if (y == null) {
                y = toolkit.getScreenSize().height / 2;
            }
            /**
             * 移动鼠标到指定位置
             *  robot.delay(100);延时100毫秒
             */
            robot.mouseMove(x, y);
            robot.delay(100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
