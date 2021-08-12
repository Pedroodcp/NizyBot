package br.com.pedrodcp.nizybot;

import br.com.pedrodcp.nizybot.console.Colors;
import br.com.pedrodcp.nizybot.methods.AutoMessages;
import br.com.pedrodcp.nizybot.events.onBotShutdown;
import br.com.pedrodcp.nizybot.methods.Errors;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class NizyBot {

    public static JDA jda;

    public static void main(String[] args) {
        String token = "ODMxNzM4NjExMjcwOTQyNzIw.YHZm8Q.-jvCWyvXm7Ic9C0aJAEhdRsaIGo";

        JDABuilder builder = JDABuilder.createDefault(token)
                .setAutoReconnect(true)
                .setStatus(OnlineStatus.ONLINE);
        try {
            builder.setChunkingFilter(ChunkingFilter.ALL);
            builder.setMemberCachePolicy(MemberCachePolicy.ALL);
            builder.enableIntents(GatewayIntent.DIRECT_MESSAGE_REACTIONS);
            builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
            builder.enableIntents(GatewayIntent.GUILD_MESSAGES);
            builder.addEventListeners(new onBotShutdown());
            builder.setActivity(Activity.watching("@NizyBot - n!ajuda"));
            jda = builder.build().awaitReady();
            System.out.println("");
            System.out.println(Colors.GREEN + "[NizyBot] Instâncias iniciadas com sucesso!");
            System.out.println("");
            AutoMessages.onBotInitialization();
        } catch (LoginException | InterruptedException e) {
            Errors.checkError();
        }
    }

    public static JDA getJda() {
        return jda;
    }
}