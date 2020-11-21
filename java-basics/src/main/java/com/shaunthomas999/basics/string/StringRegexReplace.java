package com.shaunthomas999.basics.string;

public class StringRegexReplace {

    public static void main(String[] args) {
        String exampleText = "<p><b>AMSTERDAM</b> (AFN) - Banken hebben moeite met het vinden van geschikt personeel. Daarbij speelt vooral het imago van de financiële sector de werving van werknemers parten. Dat maakt detacheerder van financieel werknemers FBD Bankmensen op uit een enquête.</p><p><b>Something here</b></p><p>Vooral vrouwen staan niet te springen om een baan in de financiële wereld. Veel van hen hebben het idee dat er een machocultuur heerst bij banken. Daarnaast bestaat volgens FBD Bankmensen het beeld dat het op de bankkantoren puur om geld gaat, wat voor veel mensen onaantrekkelijk werkklimaat schept.</p><p>Meer dan een derde van de 1045 ondervraagde Nederlanders zou een baan bij een bank aan zich voorbij laten gaan, ook als ze daar meer kunnen verdienen. Van de vrouwen zegt zelfs 41 procent de huidige baan niet in te ruilen voor een werkplek bij een bank.</p>";

        String result = exampleText.replaceAll("<p>\\s*<b>(.+?)</b>\\s*</p>", "<h1>$1</h1>");

        System.out.println(result);
    }
}
