import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Engine.Object2d;

import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.glfw.GLFW.*;

public class Main {

    public Window window = new Window(800, 800, "hello");
    ArrayList<Object2d> objects = new ArrayList<>();
    ArrayList<Object2d> objectRectangle = new ArrayList<>();

    public void init() {
        window.init();
        GL.createCapabilities();

        //Code
        //Contoh
        objects.add(new Object2d(
                Arrays.asList(
                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/sceneWithVerticesColor.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f, 0.5f, 0.0f),
                                new Vector3f(-0.5f, -0.5f, 0.0f),
                                new Vector3f(0.5f, -0.5f, 0.0f)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f, 0.5f, 0.0f),
                                new Vector3f(0.0f, 1.0f, 0.0f),
                                new Vector3f(0.5f, 0.0f, 1.0f)
                        )
                )
        ));
//        objectRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //Nama file disini bisa di custom (yang bagian secene.vart atau scene.frag)
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.vert", GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f, 0.0f, 0.0f),
//                                new Vector3f(0.5f, 0.0f, 0.0f),
//                                new Vector3f(0.0f, 0.5f, 0.0f),
//                                new Vector3f(0.5f, 0.5f, 0.0f)
//                        )
//                ),
//                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f),
//                Arrays.asList(0, 1, 2, 1, 2, 3)
//        ));

    }

    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL.createCapabilities();

            //Code
            //Contoh
            for (Object2d object : objects) {
                object.drawWithVerticesColor();
//                versi sblm vertices color
//                object.draw();
            }

            for (Object2d object : objectRectangle) {
                object.draw();
            }

            //Restore state
            glDisableVertexAttribArray(0);

            //Poll for windows events
            //The key callback above will only be invokes during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}