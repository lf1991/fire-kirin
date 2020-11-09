package com.feilis.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName HdfsApi
 * @Description TODO
 * @Author lf199
 * @Date 2020/11/3 20:51
 * @Version V1.0
 */
public class HdfsApi {

    /**
     * 功能描述: <br>
     * 〈获取hdfs 文件系统〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void getFileSystem() throws IOException {
        // 获取Configuration对象
        Configuration configuration = new Configuration();
        // 设置Configuration对象，设置的目的是来指定要操作的文件系统
        configuration.set("fs.defaultFS", "hdfs://hadoop-master:8020");

        // 获取指定的文件系统，获取FileSystem就相当于获取了主节点中所有的元数据信息
        FileSystem fileSystem = FileSystem.get(configuration);
        System.out.println("fileSystem: " + fileSystem.toString());
    }

    /**
     * 功能描述: <br>
     * 〈获取hdfs 文件系统〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void getFileSystem1() throws IOException, URISyntaxException {
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        System.out.println(fileSystem);
    }

    /**
     * 功能描述: <br>
     * 〈获取hdfs 文件系统〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void getFileSystem3() throws IOException, URISyntaxException {
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://hadoop-master:8020");
        FileSystem fileSystem = FileSystem.newInstance(configuration);
        System.out.println("fileSystem: " + fileSystem.toString());
    }

    /**
     * 功能描述: <br>
     * 〈获取hdfs 文件系统〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void getFileSystem4() throws IOException, URISyntaxException {
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://hadoop-master:8020"), new Configuration());
        System.out.println(fileSystem);
    }

    /**
     * 功能描述: <br>
     * 〈获取hdfs 文件列表〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void listFile() throws Exception {
        // 1. 获取FileSystem
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        // 2. 获取指定目录下的所有信息，第一个参数指定遍历的路径，第二个参数表示是否要
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/"), true);
        // 3. 遍历迭代器
        while (iterator.hasNext()) {
            // 获取每一个文件的详细信息
            LocatedFileStatus fileStatus = iterator.next();
            // 获取每一个文件的存储路径
            System.out.println(fileStatus.getPath() + "---" + fileStatus.getPath().getName());
            // 获取文件的block存储信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            // 打印每一个文件的block数
            System.out.println(blockLocations.length);
            // 打印每一个block副本的储存位置
            for (BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.print(host + " <-> ");
                }
                System.out.println();
            }
        }

    }

    /**
     * 功能描述: <br>
     * 〈下载hdfs文件〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void downLoadFileTest() throws URISyntaxException, IOException {
        // 1. 获取FileSystem对象
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        // 2. 获取Hdfs文件输入流
        FSDataInputStream inputStream = fileSystem.open(new Path("/lifei/a.txt"));
        // 3. 获取本地文件的输出流
        FileOutputStream outputStream = new FileOutputStream(new File("E://hadoop//a.out"));
        // 4. 实现文件的复制
        IOUtils.copy(inputStream, outputStream);
        // 5. 关闭流
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        fileSystem.close();
    }

    /**
     * 功能描述: <br>
     * 〈下载hdfs文件〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void downLoadFileTest2() throws URISyntaxException, IOException {
        // 1. 获取FileSystem对象
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        // 2. 调用方法直接实现文件的下载
        fileSystem.copyToLocalFile(new Path("/lifei/a.txt"), new Path("E://hadoop//a.out"));
        fileSystem.close();
    }

    @Test
    public void mkdirsTest() throws URISyntaxException, IOException {
        // 获取
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        // 创建文件夹
        fileSystem.mkdirs(new Path("/lifei/text/hello"));
        // 创建文件
        fileSystem.create(new Path("/a.txt"));
    }

    /**
     * 功能描述: <br>
     * 〈 hdfs文件系统创建文件夹〉
     *
     * @Param: []
     * @Return: void
     * @Author: lf199
     * @Date: 2020/11/3 20:52
     */
    @Test
    public void uploadFileTest() throws IOException, URISyntaxException {
        // 1. 获取FileSystem对象
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:8020"), new Configuration());
        // 2. 调用方法实现文件的上传
        fileSystem.copyFromLocalFile(new Path("E://hadoop//wordSort.txt"), new Path("/lifei/wordSort.txt"));
        fileSystem.close();
    }
}
