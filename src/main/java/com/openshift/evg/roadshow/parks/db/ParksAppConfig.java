package com.openshift.evg.roadshow.parks.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.CustomConversions.StoreConversions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jmorales on 25/08/16.
 */
@Configuration
public class ParksAppConfig {

    @Bean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<>();
        converterList.add(new ParkReadConverter());
        StoreConversions storeConversions = StoreConversions.NONE; // Adjust as needed
        return new CustomConversions(storeConversions, converterList);
    }

}
