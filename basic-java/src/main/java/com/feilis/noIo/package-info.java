package com.feilis.noIo;

/*
 * 功能描述: <br>
 * 〈〉
 * @Param:
 * @Return:
 * @Author: lf199
 * @Date: 2021/6/26 23:45
 */

/**
 * 功能描述: < NIO的三大核心组件 elector  Channel Buffer>
 * 一:
 *   1.1.每个Channel对应一个BUffer
 *   1.2.Selector对应一个线程，一个线程对应多个Channel
 *   1.3.程序切换到那个Channel是由Channel事件决定的 （Event）
 *   1.4.Selector 会根据不同的事件在各个通道上切换
 *   1.5.Buffer就是一个内存块
 *   1.6.NIO本身是基于数据块传递的
 *   1.7.NIO数据的读取都是要通过Buffer读取或者写入的,Buffer可双向操作，需要flip切换
 *   1.8.BIO数据基于字节字符（输入流或者输出流 无法双向）
 *   1.9.Channel是非阻塞的双向,可以反应底层操作情况，比如linux系统操作通道
 *   1.10.Buffer位数据块，底层是一个数组
 *   1.11.NIO程序 <—————data—————> Buffer <—————Channel—————> 文件
 *
 *  二:Channel
 *   2.1 Stream是单向的 读写使用输入输出流
 *   2.2
 */