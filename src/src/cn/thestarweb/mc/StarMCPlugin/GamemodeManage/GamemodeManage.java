package cn.thestarweb.mc.StarMCPlugin.GamemodeManage;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

public class GamemodeManage implements Listener{
	@EventHandler(priority=EventPriority.HIGH)
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent e){
        Player p = e.getPlayer();
        if(!checkPermission(p,e.getNewGameMode())){
			p.sendMessage("����Ȩ��"+p.getWorld().getName()+"ʹ��"+getModeName(p.getGameMode()));
			e.setCancelled(true);
		}
    }
	@EventHandler(priority=EventPriority.HIGH)
	public void onWorldChange(PlayerChangedWorldEvent e){
		Player p = e.getPlayer();
		if(!checkPermission(p,p.getGameMode())){
			p.sendMessage("����Ȩ��"+p.getWorld().getName()+"ʹ��"+getModeName(p.getGameMode())+"�Ѿ�Ϊ���л�Ϊ"+getModeName(GameMode.ADVENTURE));
			p.setGameMode(GameMode.ADVENTURE);
		}
	}
	@EventHandler()
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!checkPermission(p,p.getGameMode())){
			p.sendMessage("����Ȩ��"+p.getWorld().getName()+"ʹ��"+getModeName(p.getGameMode())+"�Ѿ�Ϊ���л�Ϊ"+getModeName(GameMode.ADVENTURE));
			p.setGameMode(GameMode.ADVENTURE);
		}
	}
	public boolean checkPermission(Player p,GameMode m){
		switch(m){
        case CREATIVE:
	        if(p.hasPermission("gamemode.creative")||p.hasPermission("gamemode.creative.world."+p.getWorld().getName())) {
	        	return true;
	        }
	        break;
        case SURVIVAL:
        	if(p.hasPermission("gamemode.survival")||p.hasPermission("gamemode.survival.world."+p.getWorld().getName())) {
	        	return true;
	        }
        	break;
        case SPECTATOR:
        	if(p.hasPermission("gamemode.spectator")||p.hasPermission("gamemode.spectator.world."+p.getWorld().getName())) {
	        	return true;
	        }
        	break;
		default:
			return true;
        }
		return false;
	}
	public String getModeName(GameMode m){
		switch(m){
        case SURVIVAL:
        	return "����";
        case CREATIVE:
        	return "����";
        case SPECTATOR:
        	return "�Թ�";
        case ADVENTURE:
        	return "ð��";
		default:
			return "";
        }
	}
}
