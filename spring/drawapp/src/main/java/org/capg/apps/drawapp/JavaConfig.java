package org.capg.apps.drawapp;

import org.capg.apps.drawapp.beans.Square;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("org.capg.apps.drawapp")
@Configuration
public class JavaConfig {

    @Bean
    public Square square(){
        Square square=new Square(10);
        return square;
    }


}
