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
        numberOfBids = 0;
        highestBid = 0;
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
        if(sold == true){
            System.out.println("A festmény már elkelt");
        }else {
            if (highestBid == 0){
                highestBid = 100;
                numberOfBids++;
                lastBid = LocalDateTime.now();
            }else if(highestBid > 0){
                highestBid *= 1.10;
                numberOfBids++;
                lastBid = LocalDateTime.now();
            }
        }
    }

    public void bid(int amount){
        if(sold == true){
            System.out.println("A festmény már elkelt");
        }else {
            if(amount < 10 ||amount > 100){
                System.out.println("Túl nagy vagy túl kevés a licit érték");
            }else{
                if(amount > highestBid){
                    String convert = String.valueOf(amount);
                    highestBid = amount;
                    numberOfBids++;
                    lastBid = LocalDateTime.now();
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Festő: %s(%s)\n%b\nLegmagasabb licit: $%d(összesen: %d db)",painter,style,sold,highestBid,numberOfBids);
    }
}
