package KI304.Balitskyi.Lab6;

public class Book implements Comparable<Object> {
    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Object other) {
        if (other instanceof Book) {
            return Double.compare(this.price, ((Book) other).price);
        } else if (other instanceof Student) {
            return Double.compare(this.price, ((Student) other).getGrade());
        }
        return 0;
    }

    // решта методів залишаються незмінними
    @Override
    public String toString() {
        return title + " ($" + price + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Double.compare(price, other.price) == 0 && title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode() * 31 + Double.hashCode(price);
    }
}