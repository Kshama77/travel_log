public class Travel {
    private int id;
    private String destination;
    private String date;
    private String notes;

    public Travel(int id, String destination, String date, String notes) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "Trip #" + id +
                " | Destination: " + destination +
                " | Date: " + date +
                " | Notes: " + notes;
    }
}
