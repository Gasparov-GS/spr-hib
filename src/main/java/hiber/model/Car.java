package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Column(name = "model")
    String model;

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series")
    int series;

    @OneToOne(mappedBy = "car")
    private User user;

    @Override
    public String toString() {
        return model;
    }
}
