package hu.petrik.fest;

import java.time.LocalDateTime;

public class Festmeny {
    private String title;
    private String painter;
    private String style;
    private int numberOfBids;

    private int highestBid;
    private LocalDateTime lastBid;
    private boolean sold;

    public Festmeny(String title, String painter, String style) {
        this.title = title;
        this.painter = painter;
        this.style = style;
    }

    public String getPainter() {
        return painter;
    }

    public String getStyle() {
        return style;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public LocalDateTime getLastBid() {
        return lastBid;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void bid(){
        numberOfBids++;
        lastBid = LocalDateTime.now();
    }

    public void bid(int amount){
        if(amount > highestBid){
            highestBid = amount;
        }
        numberOfBids++;
        lastBid = LocalDateTime.now();
    }
}
