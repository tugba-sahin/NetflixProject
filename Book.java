import java.util.List;

public class Book extends Material {
    private Person writer;
    private int numberOfPages;

    public Book(int id, String name, List<Integer> scores, int release_year, int price, Category category, String type, Person writer, int numberOfPages) {
        super(id, name, scores, release_year, price, category, type);
        this.writer = writer;
        this.numberOfPages = numberOfPages;
    }

    public void setWriter(Person newWriter) {
        this.writer = newWriter;
    }

    // Getters
    public Person getWriter() {
        return writer;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public void showDetail() {
        System.out.println("--- Book Detail ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Writer: " + writer.getFirstName() + " " + writer.getLastName());
        System.out.println("Pages: " + numberOfPages);
        System.out.println("Release Year: " + getRelease_year());
        System.out.println("Price: " + getPrice() + " TL");
        System.out.println("Category: " + getCategory().getCategoryName());
        System.out.printf("Average Score: %.2f%n", getAvgScore());
        System.out.println("Scores: " + getScores());
        System.out.println("-------------------");
    }
}