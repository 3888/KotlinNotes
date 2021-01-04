package bignedranch.interop;

import bignerdranch.interop.Hero;
import bignerdranch.interop.Spellbook;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

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

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }

    public void apologize() {
        try {
            Hero.acceptApology();
            // is OK in case @Throws(IOException::class) in Hero.kt
            // is NOT ok without @Throws(IOException::class) in Hero.kt
            // Exception 'java.io.IOException' is never thrown in the corresponding try block
        } catch (IOException e) {
            System.out.println("Caught!");
        }
    }

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation()); // is OK in case @file:JvmName("Hero") before package
//        System.out.println(HeroKt.makeProclamation()); //is OK in case no @file:JvmName("Hero") before package

        Spellbook spellbook = new Spellbook();
//        List<String> spells = spellbook.getSpells(); // is OK without @JvmField
        List<String> spells = spellbook.spells; // is OK with @JvmField

        System.out.println("Spells:");
        for (String spell : spellbook.spells) {
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);
        Spellbook.getSpellbookGreeting();

        Function1<String, Unit> translator = Hero.getTranslator();

        System.out.println("translator to lowercase " + translator.invoke("TRUCE"));

    }
}