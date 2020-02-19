package com.innoinc.logintestbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 트랜젝션 설정
 *
 * @author 박민성
 */
//Databaseconfig에 추가한 txmanger been을 추가한다
@Configuration
public class ChainedTxConfig {
    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(
    		PlatformTransactionManager postgresTxManager) {
        return new ChainedTransactionManager(
        		postgresTxManager);
    }
}
