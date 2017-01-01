package com.pulkit.fitnetwork.trigger;

/**
 * Created by Shibu on 11/27/16.
 */


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.lang.*;

public class Trigger {

    @Autowired
    PreviousTriggers previousTriggers;

    @PostConstruct
    public void Triggers() {

        System.out.println("RUNNNING TRIGGERS ============================>");
        previousTriggers.generatePreviousTriggers();

//        TriggerSystem ts = new TriggerSystem();
//        Thread t = new Thread(ts);
//        t.start();
    }

}
