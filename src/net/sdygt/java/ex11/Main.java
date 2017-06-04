package net.sdygt.java.ex11;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Student sYukinoshita = new Student("S001", "Yukinoshita Yukino");
        Student sYuigahama = new Student("S002", "Yuigahama Yui");
        Student sIsshiki = new Student("S003", "Isshiki Iroha");

        Teacher tHikigaya = new Teacher("T001", "Hikigaya Hachiman");
        Teacher tHiratsuka = new Teacher("T001", "Hiratsuka Shizuka");
        Teacher tYamanaka = new Teacher("T003", "Yamanaka Sawako");

        Course cJava = new Course("C001", "Java 101", tHikigaya);
        Course cPython = new Course("C002", "Introduction to Python", tHiratsuka, tYamanaka);
        Course cPHP = new Course("C003", "PHP: The best programming language", tYamanaka);


        ArrayList<Score> scores = new ArrayList<>();

        scores.add(new Score(sYukinoshita, cJava, 95));
        scores.add(new Score(sYuigahama, cPHP, 80));
        scores.add(new Score(sIsshiki, cPython, Grade.A));
        scores.add(new Score(sYuigahama, cJava, Grade.B));

        for (Score entry : scores) {
            System.out.println(entry);
        }
    }


}
