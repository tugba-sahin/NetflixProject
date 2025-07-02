import java.util.ArrayList;
import java.util.List;

public class Netflix {
    private List<Material> materials;
    private User credential;
    private boolean isLogin; // Default value is false

    public Netflix() {
        this.materials = new ArrayList<>();
        this.isLogin = false;
    }

    public Netflix(List<Material> materials) {
        this.materials = (materials != null) ? new ArrayList<>(materials) : new ArrayList<>();
        this.isLogin = false;
    }

    public void login(User user) {
        // Example hardcoded credentials
        if ("testUser".equals(user.getUserName()) && "123456".equals(user.getPassword())) {
            this.isLogin = true;
            this.credential = user;
            System.out.println("Login successful for " + user.getUserName());
        } else {
            this.isLogin = false;
            this.credential = null;
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) {
            materials.add(m1);
            System.out.println("Movie '" + m1.getName() + "' added successfully.");
        } else {
            System.out.println("Please log in to add movies.");
        }
    }

    public void addBook(Book b1) {
        if (isLogin) {
            materials.add(b1);
            System.out.println("Book '" + b1.getName() + "' added successfully.");
        } else {
            System.out.println("Please log in to add books.");
        }
    }

    public void addMaterial(Material m2) {
        if (isLogin) {
            materials.add(m2);
            System.out.println("Material '" + m2.getName() + "' added successfully.");
        } else {
            System.out.println("Please log in to add materials.");
        }
    }

    // N1-Tüm material nesneleri arasında en yüksek ortalama skora sahip nesnenin bilgilerini ekranda gösteren fonksiyonu oluşturun.
    public void getHighestAvgScoreMaterial() {
        if (materials.isEmpty()) {
            System.out.println("No materials available.");
            return;
        }

        Material bestMaterial = null;
        double maxAvgScore = -1.0;

        for (Material material : materials) {
            double avgScore = material.getAvgScore();
            if (avgScore > maxAvgScore) {
                maxAvgScore = avgScore;
                bestMaterial = material;
            }
        }

        System.out.println("\n--- Highest Average Score Material ---");
        if (bestMaterial != null) {
            bestMaterial.showDetail();
        } else {
            System.out.println("Could not find a material with an average score.");
        }
    }

    // N2-En düşük ortalama skorlu filmin bilgilerini ekranda gösteren fonksiyonu oluşturun.
    public void getLowestAvgScoreMovie() {
        List<Movie> movies = new ArrayList<>();
        for (Material material : materials) {
            if (material instanceof Movie) {
                movies.add((Movie) material);
            }
        }

        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        Movie worstMovie = null;
        double minAvgScore = Double.POSITIVE_INFINITY;

        for (Movie movie : movies) {
            double avgScore = movie.getAvgScore();
            if (avgScore < minAvgScore) {
                minAvgScore = avgScore;
                worstMovie = movie;
            }
        }

        System.out.println("\n--- Lowest Average Score Movie ---");
        if (worstMovie != null) {
            worstMovie.showDetail();
        } else {
            System.out.println("Could not find a movie with an average score.");
        }
    }

    // N3-Bir "category id" değerini parametre olarak alıp netflix'in o kategorideki en pahalı materyalin bilgilerini ekranda gösteren fonksiyonu oluşturun.
    public void getMostExpensiveMaterialInCategory(int categoryId) {
        List<Material> filteredMaterials = new ArrayList<>();
        for (Material material : materials) {
            if (material.getCategory().getId() == categoryId) {
                filteredMaterials.add(material);
            }
        }

        if (filteredMaterials.isEmpty()) {
            System.out.println("No materials found for category ID: " + categoryId + ".");
            return;
        }

        Material mostExpensiveMaterial = null;
        int maxPrice = -1;

        for (Material material : filteredMaterials) {
            if (material.getPrice() > maxPrice) {
                maxPrice = material.getPrice();
                mostExpensiveMaterial = material;
            }
        }

        System.out.println("\n--- Most Expensive Material in Category (ID: " + categoryId + ") ---");
        if (mostExpensiveMaterial != null) {
            mostExpensiveMaterial.showDetail();
        } else {
            System.out.println("Could not find any material in category ID: " + categoryId + ".");
        }
    }

    // N4-Bir kişinin id'sini parametre olarak alıp onun oynadığı tüm filmlerin bilgilerini ekranda gösteren fonksiyonu oluşturun.
    public void getMoviesByActor(int personId) {
        List<Movie> actorMovies = new ArrayList<>();
        for (Material material : materials) {
            if (material instanceof Movie) {
                Movie movie = (Movie) material;
                for (Person actor : movie.getActors()) {
                    if (actor.getId() == personId) {
                        actorMovies.add(movie);
                        break; // Found actor, move to next movie
                    }
                }
            }
        }

        if (actorMovies.isEmpty()) {
            System.out.println("No movies found for actor with ID: " + personId + ".");
            return;
        }

        System.out.println("\n--- Movies by Actor (ID: " + personId + ") ---");
        for (Movie movie : actorMovies) {
            movie.showDetail();
        }
    }
}