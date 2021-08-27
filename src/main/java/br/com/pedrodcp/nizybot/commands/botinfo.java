package br.com.pedrodcp.nizybot.commands;

import br.com.pedrodcp.nizybot.managers.TimeManager;
import br.com.pedrodcp.nizybot.store.EmojiCodes;
import net.dv8tion.jda.api.EmbedBuilder;

import static br.com.pedrodcp.nizybot.NizyBot.*;
import static br.com.pedrodcp.nizybot.managers.CommandManager.*;

public class botinfo {

    protected static String keyCommands;

    public static void botInfoCommand() {
        int mb = 1024 * 1024;
        Runtime instance = Runtime.getRuntime();
        TimeManager.getTime(System.currentTimeMillis() - time);
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("Nizy - Informações do BOT");
        embedBuilder.setThumbnail("https://cdn.discordapp.com/avatars/831738611270942720/b0f77891f99c330cbe0861d538b9dbe7.webp?size=2048");
        embedBuilder.addField(/* Emojis.PROCESSOR */ EmojiCodes.ROBOT + " Processador", "```Intel(R) Xeon(R) CPU E5-2620 v4 @ 3.0GHz```", false);
        embedBuilder.addField(/* Emojis.PING */ EmojiCodes.CONNECTION + " Ping", "```" + jda.getGatewayPing() + "ms```", true);
        embedBuilder.addField(/* Emojis.MEMORY */ EmojiCodes.BATTERY + " Memória", "```" + (instance.totalMemory() - instance.freeMemory()) / mb + "/" + (instance.maxMemory() / mb) + " MB```", true);
        embedBuilder.addField(/* Emojis.CPU */ EmojiCodes.NOTEBOOK + " Sistema", "```Linux```", true);
        embedBuilder.addField(/* Emojis.CLOCK */ EmojiCodes.CLOCK + " Tempo de Funcionamento", "```" + TimeManager.getTime(System.currentTimeMillis() - time) + "```", false);
        embedBuilder.addField(/* Emojis.SERVERS */ EmojiCodes.BOOK + " Servidores", "```" + jda.getGuilds().size() + "```", true);
        embedBuilder.addField(/* Emojis.PEOPLE */ EmojiCodes.PEOPLE + " Usuários", "```" + jda.getUsers().size() + "```", true);
        embedBuilder.addField(/* Emojis.WORLD */ EmojiCodes.SATELLITE + " Prefixo Global", "```/```", true);
        embedBuilder.addField(/* Emojis.DEVELOPER_BADGE */ EmojiCodes.TOOL + " Desenvolvedor", "```Pedro Delgado#1601```", true);
        embedBuilder.addField(/* Emojis.JAVA */ EmojiCodes.TOOL2 + " Linguagem", "```Java```", true);
        embedBuilder.addField(/* Emojis.BOOK */ EmojiCodes.INFO + " Shards", "```[ " + jda.getShardInfo().getShardTotal() + " ]```", true);
        if (commands == 1) {
            keyCommands = " comando";
        } else {
            keyCommands = " comandos";
        }
        embedBuilder.addField(/* Emojis.INFO */ EmojiCodes.TUBE + " Comandos Executados - (Última Atualização)", "```" + commands + keyCommands + "```", false);
        event.replyEmbeds(embedBuilder.build()).setEphemeral(false).mentionRepliedUser(true).queue();
    }

}
