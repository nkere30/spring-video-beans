package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithVideoStudioConfig {
    @Bean
    public VideoStudio videoStudio() {
        return new VideoStudio() {
            private int movieNumberCount = 1;
            private LocalDateTime releaseDate = LocalDateTime.of(2001, 10, 18, 10, 0);

            @Override
            public Video produce() {
                String movieName = "Cat & Curious " + movieNumberCount;
                Video video = new Video(movieName, releaseDate);
                releaseDate = releaseDate.plusYears(2);
                movieNumberCount++;
                return video;
            }
        };
    }

    @Bean
    public Channel channel(VideoStudio videoStudio) {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(videoStudio.produce());
        }
        return channel;
    }
}
