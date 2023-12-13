package de.spacepotato.sagittarius.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.moandjiezana.toml.Toml;

import de.spacepotato.sagittarius.config.toml.ConnectConfig;
import de.spacepotato.sagittarius.config.toml.InternalConfig;
import de.spacepotato.sagittarius.config.toml.MessagesConfig;
import de.spacepotato.sagittarius.config.toml.NetworkConfig;
import de.spacepotato.sagittarius.config.toml.PlayerConfig;
import de.spacepotato.sagittarius.config.toml.WorldConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TomlConfigurationFile {

	public static TomlConfigurationFile loadConfig() {
		File configFile = new File("config.toml");
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				log.error("Failed to create config file! ", e);
			}
			try (InputStream in = TomlConfigurationFile.class.getResourceAsStream("/config.toml")) {
				Files.copy(in, configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				log.error("Failed to copy config file! ", e);
			}
        }
		
		return new Toml().read(configFile).to(TomlConfigurationFile.class);		
	}
	
	private NetworkConfig network;
	private PlayerConfig player;
	private InternalConfig internal;
	private WorldConfig world;
	private ConnectConfig connect;
	private MessagesConfig messages;
	
}
