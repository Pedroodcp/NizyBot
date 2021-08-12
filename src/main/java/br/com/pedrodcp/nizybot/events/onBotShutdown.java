package br.com.pedrodcp.nizybot.events;

import net.dv8tion.jda.api.events.ShutdownEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

import static br.com.pedrodcp.nizybot.NizyBot.*;

public class onBotShutdown extends ListenerAdapter {

    public void onShutdown(ShutdownEvent e) {
        System.out.println("");
        System.out.println(Color.YELLOW + "[NizyBot] As instâncias do bot foram finalizadas com sucesso.");
        System.out.println(Color.YELLOW + "[Informações] - " + e.getCode());
        System.out.println("");
        jda.shutdown();
    }

}
