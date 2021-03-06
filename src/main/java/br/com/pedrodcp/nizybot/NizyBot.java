package br.com.pedrodcp.nizybot;

import br.com.pedrodcp.nizybot.console.Colors;
import br.com.pedrodcp.nizybot.events.InteractEvent;
import br.com.pedrodcp.nizybot.managers.CommandManager;
import br.com.pedrodcp.nizybot.events.onBotShutdown;
import br.com.pedrodcp.nizybot.managers.SelectionMenuManager;
import br.com.pedrodcp.nizybot.logs.Errors;
import br.com.pedrodcp.nizybot.models.database.ConnectionModel;
import br.com.pedrodcp.nizybot.models.database.MySQLConnection;
import br.com.pedrodcp.nizybot.registers.CommandsRegister;
import br.com.pedrodcp.nizybot.statements.Statements;
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
    public static ConnectionModel connectionModel;

    public static String ownerID = "userID";

    public static long time;
    public static int commands;

    public static void main(String[] args) {
        String token = "TOKEN";
        connectionModel = new MySQLConnection("localhost", 3306, "database", "root", "password");
        Statements.initialize();

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
            builder.addEventListeners(new CommandManager());
            builder.addEventListeners(new SelectionMenuManager());
            builder.addEventListeners(new InteractEvent());
            builder.setActivity(Activity.watching("@NizyBot - /ajuda"));
            jda = builder.build().awaitReady();
            CommandsRegister.loadCommands();
            System.out.println("");
            System.out.println(Colors.GREEN + "[NizyBot] Inst??ncias iniciadas com sucesso!");
            time = System.currentTimeMillis();
        } catch (LoginException | InterruptedException e) {
            Errors.checkError();
        }
    }

    public static JDA getJda() {
        return jda;
    }

    public static String getOwnerID() {
        return ownerID;
    }

    public static long getTime() {
        return time;
    }

    public static int getCommands() {
        return commands;
    }
}
