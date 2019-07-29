package com.chao.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * 测试Apache Curator框架的基本用法
 * API文档：http://curator.apache.org/apidocs/index.html
 *
 * @author zifangsky
 */
public class TestApacheCurator {

	//会话超时时间
	private final int SESSION_TIMEOUT = 30 * 1000;

	//连接超时时间
	private final int CONNECTION_TIMEOUT = 3 * 1000;

	//ZooKeeper服务地址
//    private static final String SERVER = "192.168.1.159:2100,192.168.1.159:2101,192.168.1.159:2102";
	private static final String SERVER = "39.105.19.24:2182";

	//创建连接实例
	private CuratorFramework client = null;

	/**
	 * baseSleepTimeMs：初始的重试等待时间
	 * maxRetries：最多重试次数
	 */
	RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

	@Before
	public void init() {
		//创建 CuratorFrameworkImpl实例
		client = CuratorFrameworkFactory.newClient(SERVER, SESSION_TIMEOUT, CONNECTION_TIMEOUT, retryPolicy);

		//启动
		client.start();
	}

	/**
	 * 测试创建节点
	 *
	 * @throws Exception
	 */
	@Test
	public void testCreate() throws Exception {
		//创建永久节点
		client.create().forPath("/curator", "/curator data".getBytes());

		//创建永久有序节点
		client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/curator_sequential", "/curator_sequential data".getBytes());

		//创建临时节点
		client.create().withMode(CreateMode.EPHEMERAL)
				.forPath("/curator/ephemeral", "/curator/ephemeral data".getBytes());

		//创建临时有序节点
		client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
				.forPath("/curator/ephemeral_path1", "/curator/ephemeral_path1 data".getBytes());

		client.create().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
				.forPath("/curator/ephemeral_path2", "/curator/ephemeral_path2 data".getBytes());
	}

	/**
	 * 测试检查某个节点是否存在
	 *
	 * @throws Exception
	 */
	@Test
	public void testCheck() throws Exception {
		Stat stat1 = client.checkExists().forPath("/curator");
		Stat stat2 = client.checkExists().forPath("/curator2");

		System.out.println("'/curator'是否存在： " + (stat1 != null ? true : false));
		System.out.println("'/curator2'是否存在： " + (stat2 != null ? true : false));
	}


	/**
	 * 测试获取和设置节点数据
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetAndSet() throws Exception {
		//获取某个节点的所有子节点
		System.out.println(client.getChildren().forPath("/"));

		//获取某个节点数据
		System.out.println(new String(client.getData().forPath("/curator")));

		//设置某个节点数据
		client.setData().forPath("/curator", "/curator modified data".getBytes());
	}


	/**
	 * 测试异步设置节点数据
	 *
	 * @throws Exception
	 */
	@Test
	public void testSetDataAsync() throws Exception {
		//创建监听器
		CuratorListener listener = new CuratorListener() {

			@Override
			public void eventReceived(CuratorFramework client, CuratorEvent event)
					throws Exception {
				System.out.println(event.getPath());
			}
		};

		//添加监听器
		client.getCuratorListenable().addListener(listener);

		Thread.sleep(10000);

		//异步设置某个节点数据
		client.setData().inBackground().forPath("/curator", "/curator modified data with Async".getBytes());

		//为了防止单元测试结束从而看不到异步执行结果，因此暂停10秒
		Thread.sleep(10000);
	}


	/**
	 * 测试另一种异步执行获取通知的方式
	 *
	 * @throws Exception
	 */
	@Test
	public void testSetDataAsyncWithCallback() throws Exception {
		BackgroundCallback callback = new BackgroundCallback() {

			@Override
			public void processResult(CuratorFramework client, CuratorEvent event)
					throws Exception {
				System.out.println(event.getPath());
			}
		};

		//异步设置某个节点数据
		client.setData().inBackground(callback).forPath("/curator", "/curator modified data with Callback".getBytes());

		//为了防止单元测试结束从而看不到异步执行结果，因此暂停10秒
		Thread.sleep(10000);
	}


	/**
	 * 测试删除节点
	 *
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		//创建测试节点
		client.create().orSetData().creatingParentContainersIfNeeded()
				.forPath("/curator/del_key1", "/curator/del_key1 data".getBytes());

		client.create().orSetData().creatingParentContainersIfNeeded()
				.forPath("/curator/del_key2", "/curator/del_key2 data".getBytes());

		client.create().forPath("/curator/del_key2/test_key", "test_key data".getBytes());


		//删除该节点
		client.delete().forPath("/curator/del_key1");

		//级联删除子节点
		client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/curator/del_key2");
	}


	/**
	 * 测试事务管理：碰到异常，事务会回滚
	 *
	 * @throws Exception
	 */
	@Test
	public void testTransaction() throws Exception {
		//定义几个基本操作
		CuratorOp createOp = client.transactionOp().create()
				.forPath("/curator/one_path", "some data".getBytes());

		CuratorOp setDataOp = client.transactionOp().setData()
				.forPath("/curator", "other data".getBytes());

//		CuratorOp deleteOp = client.transactionOp().delete()
//				.forPath("/curator");

		//事务执行结果
		List<CuratorTransactionResult> results = client.transaction()
				.forOperations(createOp, setDataOp);

		//遍历输出结果
		for (CuratorTransactionResult result : results) {
			System.out.println("执行结果是： " + result.getForPath() + "--" + result.getType());
		}
	}


	/**
	 * 测试命名空间
	 *
	 * @throws Exception
	 */
	@Test
	public void testNamespace() throws Exception {
		//创建带命名空间的连接实例
		CuratorFramework client2 = CuratorFrameworkFactory.builder()
				.namespace("mydemo/v1")
				.connectString(SERVER)
				.sessionTimeoutMs(SESSION_TIMEOUT)
				.connectionTimeoutMs(CONNECTION_TIMEOUT)
				.retryPolicy(retryPolicy)
				.build();
		//启动
		client2.start();

		client2.create().orSetData().creatingParentContainersIfNeeded()
				.forPath("/server1/method1", "some data".getBytes());

		client2.close();
	}

	@After
	public void close() {
		client.close();
	}
}