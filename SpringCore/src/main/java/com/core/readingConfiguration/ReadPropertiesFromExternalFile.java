package com.core.readingConfiguration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value= {"file:\\C:\\Users\\Deepa\\learning\\git_repositoris\\Spring_boot_core\\SpringCore\\src\\main\\resources\\ExternalProp.properties"
		,"file:\\C:\\Users\\Deepa\\learning\\git_repositoris\\Spring_boot_core\\SpringCore\\src\\main\\resources\\ExternalProp2.properties"
})
public class ReadPropertiesFromExternalFile {
	String name;
	String address;
	Map<String,String> key;
}
