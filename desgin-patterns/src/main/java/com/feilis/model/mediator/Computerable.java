package com.feilis.model.mediator;

/**
 * 抽象电脑类
 */
public abstract class Computerable {
    //持有一个调停者对象
    private Mediatable mediator;

    public Computerable(Mediatable mediator) {
        this.mediator = mediator;
    }

    public Mediatable getMediator() {
        return this.mediator;
    }
}
