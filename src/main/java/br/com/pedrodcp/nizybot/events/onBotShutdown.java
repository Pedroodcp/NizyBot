package br.com.pedrodcp.nizybot.events;

import br.com.pedrodcp.nizybot.statements.Statements;
import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class onBotShutdown extends ListenerAdapter {

    public void onShutdown(ShutdownEvent e) {
        Statements.saveAccounts();
        System.out.println("");
        System.out.println(Color.RED + "[NizyBot] As instâncias do bot foram desligadas com sucesso.");
        System.out.println("");
    }

}
