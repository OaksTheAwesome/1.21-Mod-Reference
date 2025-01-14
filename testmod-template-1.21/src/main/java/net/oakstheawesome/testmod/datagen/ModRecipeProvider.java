package net.oakstheawesome.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.oakstheawesome.testmod.ModBlocks;
import net.oakstheawesome.testmod.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> SUSPICIOUS_SUBSTANCE_SMELTABLES = List.of(ModItems.SUSPICIOUS_SUBSTANCE);

        offerSmelting(recipeExporter, SUSPICIOUS_SUBSTANCE_SMELTABLES, RecipeCategory.MISC, ModItems.LIGHTNING_STICK, 0.25f, 200, "suspicious_substance");
        offerBlasting(recipeExporter, SUSPICIOUS_SUBSTANCE_SMELTABLES, RecipeCategory.MISC, ModItems.LIGHTNING_STICK, 0.25f, 100, "suspicious_substance");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GUIDITE_SWORD)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.SUSPICIOUS_SUBSTANCE)
                .criterion(hasItem(ModItems.SUSPICIOUS_SUBSTANCE), conditionsFromItem(ModItems.SUSPICIOUS_SUBSTANCE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CONDENSED_OAK_LOG)
                .pattern("LL")
                .pattern("LL")
                .input('L', Items.OAK_LOG)
                .criterion(hasItem(Items.OAK_LOG), conditionsFromItem(Items.OAK_LOG))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.OAK_LOG, 4)
                .input(ModBlocks.CONDENSED_OAK_LOG)
                .criterion(hasItem(ModBlocks.CONDENSED_OAK_LOG), conditionsFromItem(ModBlocks.CONDENSED_OAK_LOG))
                .offerTo(recipeExporter);

    }
}
