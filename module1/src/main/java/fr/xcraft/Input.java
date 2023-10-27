package fr.xcraft;

public record Input(String name, String body) {

    @Override
    public String toString() {
        return "%s: %s".formatted(name, body);
    }
}
