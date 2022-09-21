package resources;

public enum APIResources {

    PlayerResource("waiting for resource");

    private final String resource;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
