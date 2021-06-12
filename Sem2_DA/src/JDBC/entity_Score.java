/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.time.*;

/**
 *
 * @author ngnha
 */
public class entity_Score {
    
//    public String Name;
    public int Score;
    public LocalTime Times;
    public LocalDate Dates;

    public entity_Score(int Score, LocalTime Times, LocalDate Dates) {
        this.Score = Score;
        this.Times = Times;
        this.Dates = Dates;
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
