package br.com.pedrodcp.nizybot.registers;

import br.com.pedrodcp.nizybot.console.Colors;

import static br.com.pedrodcp.nizybot.NizyBot.*;

public class CommandsRegister {

    public static void loadCommands() {
        jda.upsertCommand("botinfo", "Comando de informações do bot.").queue();
        System.out.println("");
        System.out.println(Colors.BLUE + "[NizyBot - Logs] Comandos carregados com sucesso.");
    }

}
