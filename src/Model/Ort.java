package Model;

public enum Ort {
    Thurgau("Thurgau"), Zürich("Zürich"), StGallen("St. Gallen");

    String notation;

    Ort(String notation) {
        this.notation = notation;
    }

    public String getNotation() { return notation; }
}
