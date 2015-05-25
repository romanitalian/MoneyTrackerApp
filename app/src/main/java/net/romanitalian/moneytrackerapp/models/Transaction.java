package net.romanitalian.moneytrackerapp.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import net.romanitalian.moneytrackerapp.utils.Udate;

import java.util.Date;

@Table(name = "Transactions")
public class Transaction extends Model {
    @Column(name = "title")
    public String title;

    @Column(name = "sum")
    public int sum;

    @Column(name = "date")
    private Date date;

    public Transaction() {
    }

    public Transaction(String title, String sum) {
        this.title = title;
        this.sum = Integer.valueOf(sum);
        this.date = Udate.getDateNow();
    }

    public Transaction(String title, String sum, Date date) {
        this.title = title;
        this.sum = Integer.valueOf(sum);
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public boolean isValid() {
        return title.length() != 0 && sum > 0;
    }
}
