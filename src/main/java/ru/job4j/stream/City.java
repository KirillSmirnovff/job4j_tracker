package ru.job4j.stream;

public class City {
    private String name;
    private String country;
    private long population;
    private int area;
    private boolean airport;
    private boolean metro;
    private boolean seaport;

    @Override
    public String toString() {
        return "City{"
                + "name='" + name + '\''
                + ", country='" + country + '\''
                + ", population=" + population
                + ", area=" + area + " sq.km."
                + ", airport=" + airport
                + ", metro=" + metro
                + ", seaport=" + seaport
                + '}';
    }

    static class Builder {
        private String name;
        private String country;
        private long population;
        private int area;
        private boolean airport;
        private boolean metro;
        private boolean seaport;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildCountry(String country) {
            this.country = country;
            return this;
        }

        Builder buildPopulation(long population) {
            this.population = population;
            return this;
        }

        Builder buildArea(int area) {
            this.area = area;
            return this;
        }

        Builder buildAirport(boolean airport) {
            this.airport = airport;
            return this;
        }

        Builder buildMetro(boolean metro) {
            this.metro = metro;
            return this;
        }

        Builder buildSeaport(boolean seaport) {
            this.seaport = seaport;
            return this;
        }

        City build() {
            City city = new City();
            city.name = name;
            city.country = country;
            city.population = population;
            city.area = area;
            city.airport = airport;
            city.metro = metro;
            city.seaport = seaport;
            return city;
        }
    }

    public static void main(String[] args) {
        City city = new Builder().buildName("City")
                .buildCountry("Country")
                .buildArea(10000)
                .buildPopulation(100000)
                .buildAirport(false)
                .buildMetro(false)
                .buildSeaport(true)
                .build();

        System.out.println(city);
    }
}
