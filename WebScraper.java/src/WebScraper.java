import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
        try {
            String url = "https://news.ycombinator.com/";

            Document doc = Jsoup.connect(url).get();

            Elements headlines = doc.select("span.titleline > a");

            for (int i = 0; i < Math.min(headlines.size(), 5); i++) {
                System.out.println((i + 1) + ". " + headlines.get(i).text());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
