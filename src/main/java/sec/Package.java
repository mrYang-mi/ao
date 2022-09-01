package sec;

public class Package {
    private Class name;
    private Integer unit;

    public Package() {
    }

    public Package(Class name, Integer unit) {
        this.name = name;
        this.unit = unit;
    }

    public Class getName() {
        return name;
    }

    public void setName(Class name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
