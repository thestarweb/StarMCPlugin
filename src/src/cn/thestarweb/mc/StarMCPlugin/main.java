package cn.thestarweb.mc.StarMCPlugin;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import cn.thestarweb.mc.StarMCPlugin.GamemodeManage.GamemodeManage;

public class main extends JavaPlugin {
	public GamemodeManage g=null;
	@Override  
    public void onEnable(){  
        g=new GamemodeManage();
        Bukkit.getPluginManager().registerEvents(g,this);
    }

    @Override      
    public void onDisable(){  
        g=null;
    }

}
