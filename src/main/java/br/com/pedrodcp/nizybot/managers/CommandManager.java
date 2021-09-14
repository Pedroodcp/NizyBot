package br.com.pedrodcp.nizybot.managers;

import br.com.pedrodcp.nizybot.store.Emojis;
import br.com.pedrodcp.nizybot.store.Reactions;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

import static br.com.pedrodcp.nizybot.NizyBot.*;

public class CommandManager extends ListenerAdapter {

    public static String[] args;
    public static SlashCommandEvent event;

    public void onMessageReceived(MessageReceivedEvent e) {
        args = e.getMessage().getContentRaw().split(" ");
        if (e.getMessage().isMentioned(e.getGuild().getSelfMember())) {
            e.getMessage().addReaction(Reactions.OK).queue();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setAuthor("Nizy - Central de Ajuda");
            embedBuilder.setThumbnail("https://cdn.discordapp.com/avatars/831738611270942720/b0f77891f99c330cbe0861d538b9dbe7.webp?size=2048");
            embedBuilder.setDescription("Utilize **/comandos** ou **/ajuda** para saber todos os meus comandos e como usá-los também! :)\n\n* Você também pode interagir com o menu abaixo para que eu saiba como posso ajudá-lo!");
            e.getMessage().replyEmbeds(embedBuilder.build()).mentionRepliedUser(true).setActionRow(SelectionMenu.create("HelpMenu").addOption("Meu link de convite", "help1").addOption("Meu servidor de suporte", "help2").addOption("Vote em mim!", "help3").setPlaceholder("Como posso ajudá-lo?").build()).queue();
        }
    }

    public void onSlashCommand(SlashCommandEvent e) {
        event = e;
        if (e.getName().equals("botinfo")) {
            try {
                if (commands == 0) {
                    commands = 1;
                } else {
                    commands = commands + 1;
                }
                br.com.pedrodcp.nizybot.commands.botinfo.botInfoCommand();
            } catch (Exception exception) {
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setDescription(Emojis.NO + " Não foi possível executar o comando 'botinfo'.");
                e.replyEmbeds(embedBuilder.build()).setEphemeral(false).mentionRepliedUser(true).queue();
            }
        } else {
            if (e.getName().equals("userinfo")) {
                try {
                    if (commands == 0) {
                        commands = 1;
                    } else {
                        commands = commands + 1;
                    }
                    br.com.pedrodcp.nizybot.commands.userinfo.userInfoCommand();
                } catch (Exception exception) {
                    EmbedBuilder embedBuilder = new EmbedBuilder();
                    embedBuilder.setDescription(Emojis.NO + " Não foi possível executar o comando 'userinfo'.");
                    e.replyEmbeds(embedBuilder.build()).setEphemeral(false).mentionRepliedUser(true).queue();
                }
            }
        }
    }

}
