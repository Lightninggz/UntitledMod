package me.lightningz.untitledmod.gui;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;;

public class ExampleGUI extends Screen {

    private static final ResourceLocation gui_bg = new ResourceLocation("untitledmod:sprite-0001.png");

    public ExampleGUI(Component title) {
        super(title);
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Background is typically rendered first
        this.renderBackground(graphics);

        // Render things here before widgets (background textures)
        int relX = (this.width - 431) / 2;
        int relY = (this.height - 202) / 2;
        graphics.blit(gui_bg, relX, relY, 0, 0, 403, 202);

        // Then the widgets if this is a direct child of the Screen
        super.render(graphics, mouseX, mouseY, partialTick);

        // Render things after widgets (tooltips)
    }

    @Override
    public void tick() {
        super.tick();

    }
    @Override
    public void onClose() {
        // Stop any handlers here

        // Call last in case it interferes with the override
        super.onClose();
    }

    @Override
    public void removed() {
        // Reset initial states here

        // Call last in case it interferes with the override
        super.removed()
        ;}
}
