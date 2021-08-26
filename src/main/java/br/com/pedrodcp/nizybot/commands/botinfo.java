package br.com.pedrodcp.nizybot.commands;

import br.com.pedrodcp.nizybot.managers.TimeManager;
import br.com.pedrodcp.nizybot.store.Emojis;
import net.dv8tion.jda.api.EmbedBuilder;

import static br.com.pedrodcp.nizybot.NizyBot.*;
import static br.com.pedrodcp.nizybot.managers.CommandManager.*;

public class botinfo {

    public static void botInfoCommand() {
        int mb = 1024 * 1024;
        Runtime instance = Runtime.getRuntime();
        TimeManager.getTime(System.currentTimeMillis() - time);
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setAuthor("Nizy - Informações do BOT");
        embedBuilder.setThumbnail("https://cdn.discordapp.com/avatars/831738611270942720/b0f77891f99c330cbe0861d538b9dbe7.webp?size=2048");
        embedBuilder.addField(Emojis.PROCESSOR + " Processador", "```Intel(R) Xeon(R) CPU E5-2620 v4 @ 3.0GHz```", false);
        embedBuilder.addField(Emojis.PING + " Ping", "```" + jda.getGatewayPing() + "ms```", true);
        embedBuilder.addField(Emojis.MEMORY + " Memória", "```" + (instance.totalMemory() - instance.freeMemory()) / mb + "/" + (instance.maxMemory() / mb) + " MB```", true);
        embedBuilder.addField(Emojis.CPU + " Sistema", "```Linux```", true);
        embedBuilder.addField(Emojis.CLOCK + " Tempo de Funcionamento", "```" + TimeManager.getTime(System.currentTimeMillis() - time) + "```", false);
        embedBuilder.addField(Emojis.SERVERS + " Servidores", "```" + jda.getGuilds().size() + "```", true);
        embedBuilder.addField(Emojis.PEOPLE + " Usuários", "```" + jda.getUsers().size() + "```", true);
        embedBuilder.addField(Emojis.WORLD + " Prefixo Global", "```n!```", true);
        embedBuilder.addField(Emojis.DEVELOPER_BADGE + " Desenvolvedor", "```Pedro Delgado#1601```", true);
        embedBuilder.addField(Emojis.JAVA + " Linguagem", "```Java```", true);
        embedBuilder.addField(Emojis.BOOK + " Shards", "```[ " + jda.getShardInfo().getShardTotal() + " ]```", true);
        embedBuilder.addField(Emojis.INFO + " Comandos Executados - (Última Atualização)", "```" + commands + "```", false);
        event.replyEmbeds(embedBuilder.build()).setEphemeral(false).mentionRepliedUser(true).queue();
    }

}
