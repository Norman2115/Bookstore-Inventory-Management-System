package bookstoreinventorymanagementsystem;

import java.awt.Color;

/**
 * A model class representing data for a slice of a pie chart. Each instance of
 * this class contains a name, a value, and a color. This class is used to
 * provide data to the PieChart component. This class is based on the tutorial
 * provided by Ra Ven on YouTube. Tutorial: https://youtu.be/keUbv26ReeE
 *
 * @author Liew Wen Yen
 * @author Tay Xuan Ye
 */
public class ModelPieChart {
    private String name;
    private double values;
    private Color color;

    public ModelPieChart() {
        
    }

    public ModelPieChart(String name, double values, Color color) {
        this.name = name;
        this.values = values;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
