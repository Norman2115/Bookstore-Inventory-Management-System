/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

/**
 *
 * @author Liew Wen Yen
 */
public class ModelMonth {

    private int month;
    private String monthText;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthText() {
        return monthText;
    }

    public void setMonthText(String monthText) {
        this.monthText = monthText;
    }

    public ModelMonth(int month, String monthText) {
        this.month = month;
        this.monthText = monthText;
    }

    public ModelMonth() {
    }

    @Override
    public String toString() {
        return monthText;
    }

}
