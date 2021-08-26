package br.com.pedrodcp.nizybot.commands;

import br.com.pedrodcp.nizybot.managers.TimeManager;

import java.util.concurrent.TimeUnit;

import static br.com.pedrodcp.nizybot.NizyBot.*;
import static br.com.pedrodcp.nizybot.managers.CommandManager.*;

public class userinfo {

    protected static long keyTimeJoined;
    protected static long keyGuildTimeCreated;
    protected static long keyUserTimeCreated;

    public static void userInfoCommand() {
        if (event.getMember().getId().equals(ownerID)) {
            keyTimeJoined = System.currentTimeMillis() - TimeUnit.MILLISECONDS.convert(jda.getGuildById(event.getGuild().getId()).getMemberById(event.getMember().getId()).getTimeJoined().toEpochSecond(), TimeUnit.SECONDS);
            keyGuildTimeCreated = System.currentTimeMillis() - TimeUnit.MILLISECONDS.convert(jda.getGuildById(event.getGuild().getId()).getTimeCreated().toEpochSecond(), TimeUnit.SECONDS);
            keyUserTimeCreated = System.currentTimeMillis() - TimeUnit.MILLISECONDS.convert(jda.getUserById(event.getMember().getId()).getTimeCreated().toEpochSecond(), TimeUnit.SECONDS);
            event.reply("Você entrou aqui há: " + TimeManager.getTime(keyTimeJoined) + "\nEste servidor foi criado há: " + TimeManager.getTime(keyGuildTimeCreated) + "\n\nCuriosidade 1: Você entrou no servidor há: " + TimeManager.getTime(keyGuildTimeCreated - keyTimeJoined) + " após sua criação.\nCuriosidade 2: Você criou sua conta há: " + TimeManager.getTime(keyUserTimeCreated)).mentionRepliedUser(true).setEphemeral(false).queue();
        }
    }

}
