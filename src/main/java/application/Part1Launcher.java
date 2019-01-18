package application;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Part1Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public static void main(String[] args) {
        Part1Launcher launcher = new Part1Launcher();
        launcher.launch();
    }
}