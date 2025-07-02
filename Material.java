import java.util.ArrayList;
import java.util.List;

public abstract class Material {
    private int id;
    private String name;
    private List<Integer> scores;
    private int release_year;
    private int price;
    private Category category;
    private String type; // "movie" or "book"

    public Material(int id, String name, List<Integer> scores, int release_year, int price, Category category, String type) {
        this.id = id;
        this.name = name;
        this.scores = (scores != null) ? new ArrayList<>(scores) : new ArrayList<>();
        this.release_year = release_year;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    public void addScore(int score) {
        this.scores.add(score);
    }

    public double getAvgScore() {
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }

    public abstract void showDetail();

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getRelease_year() {
        return release_year;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }
}

/* KİTAP VE FİLMİN ORTAK ÖZELLİKLERİNİ TUTAR .
İD ,İSİM ,YIL ,FİYAT ,KATEGORİ ,SKORLAR
SHOWDETAİL() METODU SOYUT ,YANİ ALT SINIF KENDİNE GÖRE YAZICAK .
ORTLAMA SKORU HESAPLAR  : GETAVGSCORE()
 */