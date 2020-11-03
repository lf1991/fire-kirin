package com.feilis.zookper;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

/**
 * @ClassName ZookperApi
 * @Description TODO zookper 代码操作
 * @Author lf199
 * @Date 2020/10/29 11:20
 * @Version V1.0
 * <p>
 * zookper操作步骤
 * step1: 定制连接重试策略
 * step2: 获取客户端对象
 * step3:开启客户端
 * step4:创建节点
 * step5:关闭客户端
 */
public class ZookperApi {

    @Test
    public void createNode() throws Exception {
        //step1: 定制连接重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 2);
        //step2:获取客户端
        String connectStr = "192.168.92.100:2181,192.168.92.101:2181,192.168.92.102:2181";
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectStr, 1000, 1000, retryPolicy);
        //step3:开启客户端
        client.start();
        //step4: 对应的操作
        //CreateMode.PERSISTENT:永久节点
        //CreateMode.PERSISTENT_SEQUENTIAL:永久顺序节点

        //CreateMode.EPHEMERAL:临时节点
        //CreateMode.EPHEMERAL_SEQUENTIAL:临时顺序节点
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/hello", "hello world".getBytes());
        //step5:关闭客户端
        Thread.sleep(10000);
        client.close();
    }
}
