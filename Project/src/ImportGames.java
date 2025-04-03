import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Game {
    String title;
    int released;
    String developer;
    String publisher;
    List<String> genres;

    public Game(String title, int released, String developer, String publisher, List<String> genres) {
        this.title = title;
        this.released = released;
        this.developer = developer;
        this.publisher = publisher;
        this.genres = genres;
    }
}

public class ImportGames {
    public static void main(String[] args) {
        List<Game> games = loadGames("games.csv");
        generateGameGenres(games);
        generateSimulatorGames(games);
        generateGamePublishers(games);
    }

    // Load data into Game objects
    private static List<Game> loadGames(String fileName) {
        List<Game> games = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String title = values[0];

                // Handle "TBA" case
                int released;
                try {
                    released = values[1].equalsIgnoreCase("TBA") ? -1 : Integer.parseInt(values[1]);
                } catch (NumberFormatException e) {
                    released = -1; // Use -1 if parsing fails
                }

                String developer = values[2];
                String publisher = values[3];
                List<String> genres = Arrays.asList(values[4].replace("\"", "").split(", "));

                games.add(new Game(title, released, developer, publisher, genres));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

    // Generate game_genres.txt
    private static void generateGameGenres(List<Game> games) {
        Set<String> genres = new TreeSet<>();
        for (Game game : games) {
            genres.addAll(game.genres);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_genres.txt"))) {
            writer.write(String.join(", ", genres));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generate simulator_games.csv
    private static void generateSimulatorGames(List<Game> games) {
        List<Game> simulatorGames = games.stream()
                .filter(game -> game.genres.contains("Simulator") && game.released != -1)
                .sorted(Comparator.comparingInt(game -> game.released))
                .collect(Collectors.toList());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("simulator_games.csv"))) {
            writer.write("name,year\n");
            for (Game game : simulatorGames) {
                writer.write(game.title + "," + game.released + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generate game_publishers.csv
    private static void generateGamePublishers(List<Game> games) {
        Map<String, Long> publisherCount = games.stream()
                .collect(Collectors.groupingBy(game -> game.publisher, Collectors.counting()));
        List<Map.Entry<String, Long>> sortedPublishers = publisherCount.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toList());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("game_publishers.csv"))) {
            writer.write("publisher,number of published games\n");
            for (Map.Entry<String, Long> entry : sortedPublishers) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
