package br.com.pedrodcp.nizybot.managers;

import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SelectionMenuManager extends ListenerAdapter {

    public void onSelectionMenu(SelectionMenuEvent e) {
        System.out.println(e.getMessage());
        System.out.println(e.getInteraction().getSelectionMenu());
    }

}
