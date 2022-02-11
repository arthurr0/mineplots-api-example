package pl.minecodes.mineplots.example.listener;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.minecodes.mineplots.api.plot.ApiPlot;
import pl.minecodes.mineplots.api.plot.ApiPlotService;

public class BlockPlaceListener implements Listener {

    private final ApiPlotService apiPlotService;

    public BlockPlaceListener(ApiPlotService apiPlotService) {
        this.apiPlotService = apiPlotService;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block blockPlaced = event.getBlockPlaced();
        ApiPlot plot = this.apiPlotService.getPlot(blockPlaced.getLocation());

        if (plot == null) {
            player.sendMessage("There is no plot at this location.");
        } else {
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(plot.getOwner());
            player.sendMessage(String.format("There is a plot named %s owned by %s", plot.getName(), offlinePlayer.getName()));
        }
    }
}
