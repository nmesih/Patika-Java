package Homework02.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmApp {

    static Scanner input = new Scanner(System.in);

    static List<Film> films = new ArrayList<>();

    static ArrayList<String> categoryList = new ArrayList<>();


    public static void main(String[] args) {
        /*
    hangi platformda hangi film var onu görmek istiyorum
    veritabanı var. ordaki filmleri kaydetsin. category,
    her kategoride kaç film var görmek istiyorum(Count ile güncellicez)
    program çalışınca admin misin client mısın onu sor. (1-2 diye basarak)
    admin iken 0' a basınca client moduna geçsin.
    category seçmek için scanner'dan 1-2-3 e basarak seçsin.
    kullanıcı kategorileri görmeli, kategoriye tıklayınca ordaki filmleri(ad, yönetmen, platform, gösterim saati) görmeli

 */

        categoryList.add("Korku");
        categoryList.add("Komedi");
        categoryList.add("Bilim Kurgu");
        categoryList.add("Romantik");
        categoryList.add("Aksiyon");

        System.out.println("Film programına hos geldiniz." +
                "\n Giriş için tuşlama yapınız(Admin için 1'e client için 2'ye basınız)");

        int enter = input.nextInt();
        if (enter == 1) {
            adminMode();
        } else if (enter == 2) {
            clientMode();
        } else
            System.out.println("Yanlıs giriş yaptınız!");

    }

    private static void adminMode() {
        System.out.println("Hoş geldiniz! Film kaydetmek için 1'e kategori kaydetmek için 2'ye basınız");
        int number = input.nextInt();
        while(true) {
            if (number == 1) {
                addFilm();
            } else if (number == 2) {
                addCategory();
            } else
                System.out.println("Yanlıs giriş yaptınız!");

            System.out.println("Film eklemek için 1'e categori eklemek için 2'ye çıkış yapmak için 0'a basınız");
            number = input.nextInt();
            if(number == 0){
                break;
            }else {
                continue;
            }
        }
        System.out.println("Client moda geçmek istiyorsanız 0'a basınız");
        int a = input.nextInt();
        if(a==0){
            clientMode();
        }
    }

    private static void addFilm() {
        input.nextLine();
        System.out.println("Filmin adını giriniz");
        String name = input.nextLine();
        System.out.println();

        System.out.println("Filmin yılını giriniz");
        int year = input.nextInt();

        input.nextLine();
        System.out.println("Filmin yönetmenini giriniz");
        String director = input.nextLine();

        System.out.println("Filmin imdb puanını giriniz");
        double imdb = input.nextDouble();

        System.out.println("Kategoriyi giriniz");
        List<Category> categoryArr = new ArrayList<>();

        for (int i=0;i<categoryList.size();i++){
            System.out.println((i+1)+"-"+categoryList.get(i));
        }
        int catNum = input.nextInt();

        System.out.println("Filmin süresini giriniz");
        int time = input.nextInt();

        System.out.println("Filmin yayınlandığı platformları giriniz(Platform girme işlemini sonlandırmak için 0'a basınız)");
        List<String> platformList = new ArrayList<>();
        while (true) {
            String platform = input.next();
            if(platform.equals("0")){
                break;
            }
            platformList.add(platform);
        }

        System.out.println("Filmin gösterim saatlerini giriniz (Gösterim saati girme işlemini sonlandırmak için 0'a basınız)");
        List<String> sessions = new ArrayList<>();
        while (true) {
            String session = input.next();
            if(session.equals("0")){
                break;
            }
            sessions.add(session);

        }

        Film film = new Film(name, year, director, imdb, time, categoryArr, platformList, sessions);

        Category tempCat = new Category();
        tempCat.setName(categoryList.get(catNum-1));
        ArrayList <Category> tempCatList = new ArrayList<>();
        tempCatList.add(tempCat);
        film.setCategoryArr(tempCatList);

        films.add(film);
        System.out.println("Filminiz kaydedildi!");

    }

    private static void addCategory() {
        input.nextLine();
        System.out.println("Eklemek istediğiniz kategoriyi giriniz");
        String categoryName = input.nextLine();

        categoryList.add(categoryName);
        System.out.println("Kategori ekleme işlemi başarılı !\n");
    }


    private static void clientMode() {
        System.out.println("Filmleri Görmek İçin Kategori Seçiniz.");
        for (int i=0;i<categoryList.size();i++){
            System.out.println((i+1)+"-"+categoryList.get(i));
        }
        int userChoice = input.nextInt();

        System.out.println(categoryList.get(userChoice-1)+" kategorisindeki filmler :");

        int count = 0;

        for (Film fd : films){
            for (Category c : fd.getCategoryArr()){
                if (c.getName().equals(categoryList.get(userChoice-1))){
                    System.out.println(fd);
                    count++;
                }
            }
        }

        System.out.println(categoryList.get(userChoice-1)+" kategorisinde "+count+" tane film vardır...");
    }
}
