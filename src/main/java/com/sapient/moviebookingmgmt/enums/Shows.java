package com.sapient.moviebookingmgmt.enums;

public enum Shows {
    MORNING(1),
    AFTERNOON(4),
    EVENING(7),
    NIGHT(10);

    private int showTime;

    Shows(int showTime) {
        this.showTime = showTime;
    }

    public String toString() {
        return Integer.toString(showTime);
    }
//    public int getShowTime() {
//        return showTime;
//    }
}
