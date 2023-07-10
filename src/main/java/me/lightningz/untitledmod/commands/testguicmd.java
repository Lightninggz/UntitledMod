package me.lightningz.untitledmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import me.lightningz.untitledmod.gui.ExampleGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;

public class testguicmd {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("amogus")
                .executes(context -> {
                    return openGui();
                }));
    }

    private static int openGui() {
        try {
            Minecraft.getInstance().setScreen(new ExampleGUI("test"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
}
