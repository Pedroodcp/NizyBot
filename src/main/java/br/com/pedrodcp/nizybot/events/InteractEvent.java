package br.com.pedrodcp.nizybot.events;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InteractEvent extends ListenerAdapter {

    public void onButtonClick(ButtonClickEvent e) {
        e.getMessage().reply(e.getButton().getId()).mentionRepliedUser(true).queue();
    }

    public void onSelectionMenu(SelectionMenuEvent e) {
        String keyValues = null;
        if (e.getValues().get(0).equals("help1")) {
            keyValues = "1 - Meu link de convite";
        } else {
            if (e.getValues().get(0).equals("help2")) {
                keyValues = "2 - Meu servidor de suporte";
            } else {
                if (e.getValues().get(0).equals("help3")) {
                    keyValues = "3 - Vote em mim!";
                }
            }
        }
        e.reply("Você selecionou o botão de ajuda: `" + keyValues + "`").mentionRepliedUser(false).queue();
    }

}