package org.capg.apps.drawapp;

import org.capg.apps.drawapp.beans.Canvas;
import org.capg.apps.drawapp.beans.IShape;
import org.capg.apps.drawapp.beans.Square;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:app.properties")
@ComponentScan("org.capg.apps.drawapp")
@Configuration
public class JavaConfig {



}
