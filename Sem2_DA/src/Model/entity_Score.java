/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.*;

/**
 *
 * @author ngnha
 */
public class entity_Score {
    public int ID;
    public String Name;
    public int Score;
    public LocalTime Times;
    public LocalDate Dates;

    public entity_Score(String Name, int Score, LocalTime Times, LocalDate Dates) {
        this.Name = Name;
        this.Score = Score;
        this.Times = Times;
        this.Dates = Dates;
    }

    public entity_Score(int ID, String Name, int Score, LocalTime Times, LocalDate Dates) {
        this.ID = ID;
        this.Name = Name;
        this.Score = Score;
        this.Times = Times;
        this.Dates = Dates;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public LocalTime getTimes() {
        return Times;
    }

    public void setTimes(LocalTime Times) {
        this.Times = Times;
    }

    public LocalDate getDates() {
        return Dates;
    }

    public void setDates(LocalDate Dates) {
        this.Dates = Dates;
    }

}
