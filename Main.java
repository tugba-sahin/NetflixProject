import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1-Birden çok Person nesnesi oluşturun.
        Person person1 = new Person(1, "Tom", "Hanks", 67);
        Person person2 = new Person(2, "Meryl", "Streep", 74);
        Person person3 = new Person(3, "Christopher", "Nolan", 53);
        Person person4 = new Person(4, "Stephen", "King", 76);
        Person person5 = new Person(5, "Quentin", "Tarantino", 61);
        Person person6 = new Person(6, "Leonardo", "DiCaprio", 49);
        Person person7 = new Person(7, "Kate", "Winslet", 48);
        Person person8 = new Person(8, "J.R.R.", "Tolkien", 81); // For Lord of the Rings

        // 2-Birden çok Category nesnesi oluşturun.
        Category category1 = new Category(101, "DRM", "Drama");
        Category category2 = new Category(102, "SCL", "Science Fiction");
        Category category3 = new Category(103, "THR", "Thriller");
        Category category4 = new Category(104, "FAN", "Fantasy");

        // 3-Birden çok Movie nesnesi oluşturun ve score'lar ekleyin.
        Movie movie1 = new Movie(1, "Inception", new ArrayList<>(Arrays.asList(9, 10, 8)), 2010, 75, category2, "movie",
                new ArrayList<>(Arrays.asList(person1, person6)), person3);

        Movie movie2 = new Movie(2, "Titanic", new ArrayList<>(Arrays.asList(7, 8, 9)), 1997, 60, category1, "movie",
                new ArrayList<>(Arrays.asList(person6, person7)), person5);

        Movie movie3 = new Movie(3, "The Shawshank Redemption", new ArrayList<>(Arrays.asList(10, 9, 10)), 1994, 80, category1, "movie",
                new ArrayList<>(Arrays.asList(person1)), person3); // person1 as an actor for example

        // 4-Birden çok Book nesnesi oluşturun ve score'lar ekleyin.
        Book book1 = new Book(4, "The Shining", new ArrayList<>(Arrays.asList(8, 7, 9)), 1977, 45, category3, "book", person4, 447);

        Book book2 = new Book(5, "It", new ArrayList<>(Arrays.asList(9, 9, 8)), 1986, 55, category3, "book", person4, 1138);

        Book book3 = new Book(6, "The Lord of the Rings", new ArrayList<>(Arrays.asList(10, 10, 10)), 1954, 120, category4, "book", person8, 1178);

        // 5-Bir User nesnesi tanımlayın
        User user1 = new User(10, "John", "Doe", "testUser", "123456");

        // 6-Bir netflix nesnesi oluşturun.
        Netflix netflix = new Netflix();

        // 7-Netflix için oturum açın
        netflix.login(user1);

        // 8-Netflix nesnesine 3 ve 4 maddelerinde oluştuduğunuz nesneleri ekleyin.
        System.out.println("\n--- Adding Materials to Netflix ---");
        netflix.addMovie(movie1);
        netflix.addMovie(movie2);
        netflix.addMovie(movie3);
        netflix.addBook(book1);
        netflix.addBook(book2);
        netflix.addBook(book3);

        // 9-Son olarak Netflix bölümünde bahsedilmiş olan N1-N2-N3-N4 fonksiyonlarını netflix nesnesi için çalıştırıp çıktılarını ayrı ayrı görüntülenmesini sağlayın.
        netflix.getHighestAvgScoreMaterial();
        netflix.getLowestAvgScoreMovie();
        netflix.getMostExpensiveMaterialInCategory(category3.getId()); // Thriller kategorisindeki en pahalı materyal
        netflix.getMoviesByActor(person6.getId()); // Leonardo DiCaprio'nun oynadığı filmler
        netflix.getMoviesByActor(person1.getId()); // Tom Hanks'in oynadığı filmler
    }
}


/* AMAÇ NEDİR ?

 BU PROJE ,NETFLİX BENZERİ BİR İÇERİK PLATFORMU :

 İÇERİK (MATERİAL) :KİTAP VEYA FİLM OLABİLİR .
 KULLANICI (USER) :SİSTEME GİRİŞ YAPAR .
 İÇERİKLER PUANLANIR ,FİLTRELENEBİLİR ,GÖSTERİLİR .
 */