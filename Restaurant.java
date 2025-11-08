public class Restaurant {
    private String name;
    private Integer rating;

    public Restaurant(String s, Integer n) {
        name = s;
        rating = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer n) {
        rating = n;
    }

    public String toString() {
        return name + "\t" + rating;
    }

    public boolean equals(Restaurant o) {
        if (name.equalsIgnoreCase(o.name) && rating.equals(o.rating)) {
            return true;
        } else {
            return false;
        }
    }
}
