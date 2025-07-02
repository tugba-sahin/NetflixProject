import java.util.ArrayList;
import java.util.List;

public class Movie extends Material {
    private List<Person> actors;
    private Person director;

    public Movie(int id, String name, List<Integer> scores, int release_year, int price, Category category, String type, List<Person> actors, Person director) {
        super(id, name, scores, release_year, price, category, type);
        this.actors = (actors != null) ? new ArrayList<>(actors) : new ArrayList<>();
        this.director = director;
    }

    public void addActor(Person actor) {
        this.actors.add(actor);
    }

    // Getters
    public List<Person> getActors() {
        return actors;
    }

    public Person getDirector() {
        return director;
    }

    @Override
    public void showDetail() {
        System.out.println("--- Movie Detail ---");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Director: " + director.getFirstName() + " " + director.getLastName());
        StringBuilder actorNames = new StringBuilder();
        for (int i = 0; i < actors.size(); i++) {
            actorNames.append(actors.get(i).getFirstName()).append(" ").append(actors.get(i).getLastName());
            if (i < actors.size() - 1) {
                actorNames.append(", ");
            }
        }
        System.out.println("Actors: " + actorNames.toString());
        System.out.println("Release Year: " + getRelease_year());
        System.out.println("Price: " + getPrice() + " TL");
        System.out.println("Category: " + getCategory().getCategoryName());
        System.out.printf("Average Score: %.2f%n", getAvgScore());
        System.out.println("Scores: " + getScores());
        System.out.println("--------------------");
    }
}