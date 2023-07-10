package Homework02;

import Homework02.model.Category;
import Homework02.model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmApp {

    static Scanner input = new Scanner(System.in);

    static List<Film> films = new ArrayList<>();

    static ArrayList<String> categoryList = new ArrayList<>();


    public static void main(String[] args) {


     //   Deneme yaparken kullanmak için bazı kategori verileri:
        categoryList.add("Korku");
        categoryList.add("Komedi");
        categoryList.add("Dram");


        //Giriş ekranı gösteriliyor

        System.out.println("Film programına hos geldiniz." +
                "\n Giriş için tuşlama yapınız(Admin için 1'e client için 2'ye basınız)");


        // kullanıcıdan alınan inputa göre program ilgili metottan devam edecek.
        int enter = input.nextInt();
        if (enter == 1) {
            adminMode();
        } else if (enter == 2) {
            clientMode();
        } else
            System.out.println("Yanlıs giriş yaptınız!");

    }

    private static void adminMode() {

        //Alınan inputa göre film ya da kategori ekleme ekranına gidecek.
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
            if(number == 0) {
                break;
            }
        }
        System.out.println("Client moda geçmek istiyorsanız 0'a basınız");
        int a = input.nextInt();
        if(a==0){
            clientMode();
            System.out.println("Başka sorgulama yapmak istiyorsanız 0'a basınız.");
            int i = input.nextInt();
            if(i == 0){
                clientMode();
            }
        }
    }

    private static void addFilm() {

        // Kullanıcıdan alınan veriler ile film oluşturuluyor.

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

        System.out.println("Kategori sayısını giriniz");
        int a = input.nextInt();

        System.out.println("Kategoriyi giriniz");
        List<Category> categoryArr = new ArrayList<>();

        for (int i=0;i<categoryList.size();i++){
            System.out.println((i+1)+"-"+categoryList.get(i));
        }
        int[] catNum = new int[a];
        for (int i = 0; i < a; i++) {
               catNum[i] = input.nextInt();
        }

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
        // Kullanıcıdan alınan veriler ile film objesi oluşurulur.
        Film film = new Film(name, year, director, imdb, time, categoryArr, platformList, sessions);

        // Kullanıcıdan alınan kategori bilgilerine göre kategori objesi oluşturularak filme o kategoriler tanımlanır.
        ArrayList <Category> tempCatList = new ArrayList<>();

        for (int i = 0; i < catNum.length; i++) {
            Category tempCat = new Category();
            tempCat.setName(categoryList.get(catNum[i]-1));
            tempCatList.add(tempCat);
        }
        film.setCategoryArr(tempCatList);
         // oluşturulan film, film listesine eklenir.
        films.add(film);
        System.out.println("Filminiz kaydedildi!");

    }

    private static void addCategory() {

        // Kullanıcıdan alınan input ile yeni kategori eklenir.
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

        // Girilen kategoriye ilişkin filmler foreach döngüsü ile görüntüleniyor.

        System.out.println(categoryList.get(userChoice-1)+" kategorisindeki filmler :");

        int count = 0;

        for (Film f : films){
            for (Category c : f.getCategoryArr()){
                if (c.getName().equals(categoryList.get(userChoice-1))){
                    System.out.println(f);
                    count++;
                }
            }
        }

        // tanımladığımız count değişkeni sayesinde döngünün dönme sayısına göre kategorideki film adedini tespit edip yazdırıyoruz.
        System.out.println(categoryList.get(userChoice-1)+" kategorisinde "+count+" tane film vardır.");
    }
}
