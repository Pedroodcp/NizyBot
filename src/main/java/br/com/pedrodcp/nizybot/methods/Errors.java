package br.com.pedrodcp.nizybot.methods;

import br.com.pedrodcp.nizybot.console.Colors;

import static br.com.pedrodcp.nizybot.NizyBot.*;

public class Errors {

    public static void checkError() {
        if (jda == null) {
            System.out.println("");
            System.out.println(Colors.RED + "[NizyBotError] Não foi possível iniciar o bot - (Token Error)");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println(Colors.RED + "[NizyBotError] Não foi possível iniciar o bot - (Unknown Error)");
            System.out.println("");
        }
    }

}
