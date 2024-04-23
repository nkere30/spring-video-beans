package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithPhantomVideoStudioConfig {
    @Bean
    @Scope("prototype")
    public Video videoPrototype() {
        return new Video("Cat & Curious", LocalDateTime.of(2001, 10, 18, 10, 0));
    }

    @Bean
    public Channel channel() {
        Channel channel = new Channel();
        long yearCounter = 0;
        for (int i = 1; i <= 8; i++) {
            Video video = videoPrototype();
            video = new Video(video.getName() + " " + i, video.getPubTime().plusYears(yearCounter * 2));
            channel.addVideo(video);
            yearCounter++;
        }
        return channel;
    }
}
