package com.elifintizam.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDto {
    private Long id;
    private String beanName;
    private String beanData;

    // start
    public void initialBeanMethod(){
        log.info("I am here before bean starts.");
        System.out.println("Working method before bean starts.");
    }


    //finish
    public void destroyBeanMethod(){
        log.info("I am here after bean finishes.");
        System.err.println("Working method after bean finishes.");
    }

}
