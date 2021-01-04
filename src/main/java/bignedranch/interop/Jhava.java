package bignedranch.interop;

import bignerdranch.interop.Hero;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Jhava {

    private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    @NotNull
    public String utterGreeting() {
        return greeting;
    }

    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


    public void offerFood() {
        Hero.handOverFood("pizza");
    }

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation()); // is OK in case @file:JvmName("Hero") before package
//        System.out.println(HeroKt.makeProclamation()); //is OK in case no @file:JvmName("Hero") before package

    }
}