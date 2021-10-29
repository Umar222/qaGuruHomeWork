package ru.zombies;

import ru.Holidays;

public class ZombieLand {


    public static void main(String[] args) {
        ZombieFarm zombieFarm = new ZombieFarm();
        Holidays holidays = new Holidays();
        zombieFarm.childZombieSay();
        zombieFarm.yongZombieSay();
        zombieFarm.oldZombieSay();
        holidays.holidays("Halloween");
    }
}
