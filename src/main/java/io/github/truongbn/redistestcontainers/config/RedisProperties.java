package io.github.truongbn.redistestcontainers.config;

import java.time.Duration;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Validated
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "redis.config")
public class RedisProperties {
    private  Duration readTimeout;
    @NotEmpty
    private  List<String> nodes;
    private  int maxTotalPool;
    private  int maxIdlePool;
    private  int minIdlePool;
    private  Duration maxWait;
    public <T> GenericObjectPoolConfig<T> getPoolConfig() {
        GenericObjectPoolConfig<T> config = new GenericObjectPoolConfig<>();
        config.setMaxTotal(maxTotalPool);
        config.setMaxIdle(maxIdlePool);
        config.setMinIdle(minIdlePool);
        config.setMaxWait(maxWait);
        return config;
    }
}
