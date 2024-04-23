package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.checkerframework.checker.units.qual.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithInjectedPrototypeVideoConfig {
    @Bean
    @Scope("prototype")
    public Video catFailureComplitaion() {
        return new Video("Cat Failure Compilation", LocalDateTime.now());
    }

    @Bean
    public Channel channel(Video catFailureComplitaion) {
        Channel channel = new Channel();
        channel.addVideo(catFailureComplitaion);
        return channel;
    }
}
