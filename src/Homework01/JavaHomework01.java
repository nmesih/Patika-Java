package Homework01;

import java.util.*;

public class JavaHomework01 {
    public static void main(String[] args) {

        Map<String, List<String>> school = new HashMap<>();

        //Ogrencileri sınıflara kaydediyoruz

        List<String> classroomA = new ArrayList<>();
        classroomA.add("Arda Guler");
        classroomA.add("Birsel Vardarlı");
        classroomA.add("Burak Yılmaz");
        classroomA.add("Willian Arao");
        classroomA.add("Enes Oguz");

        List<String> classroomB = new ArrayList<>();
        classroomB.add("Aslıhan Ozmert");
        classroomB.add("Ferdi Kadıoglu");
        classroomB.add("Mert Hakan Yandas");
        classroomB.add("Serdar Aziz");
        classroomB.add("Irfan Can Kahveci");

        List<String> classroomC = new ArrayList<>();
        classroomC.add("Eda Erdem");
        classroomC.add("Altay Bayındır");
        classroomC.add("Edin Dzeko");
        classroomC.add("Hasan Ali Kaldirim");
        classroomC.add("Volkan Demirel");

        school.put("A", classroomA);
        school.put("B", classroomB);
        school.put("C", classroomC);

        // Ismi -an ile bitenlerin isimlerini ve sınıflarını yazdırıyoruz.

        System.out.println("Students whose names end with '-an' :");
        for (String classroom : school.keySet()) {
            List<String> students = school.get(classroom);

            for (String student : students) {
                String[] names = student.split(" ");
                String firstName = names[0];
                String secondName = "";
                if (names.length > 1) {
                    secondName = names[1];
                }
                if (firstName.endsWith("an") || secondName.endsWith("an")) {
                    System.out.println("Name: " + student + "\nClass: " + classroom);
                    System.out.println("-------------");
                }
            }
            System.out.println();
        }
    }
}
