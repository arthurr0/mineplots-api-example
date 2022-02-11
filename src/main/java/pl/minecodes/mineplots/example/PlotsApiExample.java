package pl.minecodes.mineplots.example;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pl.minecodes.mineplots.api.plot.ApiPlotService;
import pl.minecodes.mineplots.example.listener.BlockPlaceListener;
import pl.minecodes.mineplots.example.listener.PrePlotEntryListener;

import java.util.Objects;

public final class PlotsApiExample extends JavaPlugin {

    private ApiPlotService apiPlotService;

    @Override
    public void onEnable() {
        this.setupPlotService();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockPlaceListener(apiPlotService), this);
        pluginManager.registerEvents(new PrePlotEntryListener(), this);
    }

    public void setupPlotService() {
        if (!Bukkit.getServer().getPluginManager().isPluginEnabled("minePlots")) {
            Bukkit.getLogger().severe("Disabled due to no minePlots dependency found!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        RegisteredServiceProvider<ApiPlotService> serviceProvider = Bukkit.getServicesManager().getRegistration(ApiPlotService.class);
        Objects.requireNonNull(serviceProvider, "Service provider is null!");

        apiPlotService = serviceProvider.getProvider();
    }

}
