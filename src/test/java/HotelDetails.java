public class HotelDetails {

    String name;
    String stars;
    String averageRating;
    String reviewCount;
    String price;

    public HotelDetails(String name, String stars, String averageRating, String reviewCount, String price) {
        this.name = name;
        this.stars = stars;
        this.averageRating = averageRating;
        this.reviewCount = reviewCount;
        this.price = price;
    }

    public String normalizeStars(String stars) {
        return stars.replaceAll("[^0-9]", "").substring(0, 1); // Удаление всех символов, кроме цифр
    }

    public String normalizeAverageRating(String averageRating) {
        return averageRating.replace(",", ".").trim(); // Замена запятой на точку и удаление лишних пробелов
    }

    public String normalizeReviewCount(String reviewCount) {
        return reviewCount.replaceAll("[^0-9]", "").trim(); // Удаление символа и пробелов
    }

    //public String normalizePrice(String price) {
       // return price.replaceAll("[^0-9]", ""); // Оставляем только цифры
    //}
}
