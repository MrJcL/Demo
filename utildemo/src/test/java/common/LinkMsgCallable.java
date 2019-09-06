package common;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 异步发送link消息
 * @author JcL
 * 2019-04-10
 */
public class LinkMsgCallable {

    static ExecutorService e = Executors.newFixedThreadPool(50);

	/**
	 * 异步发送link消息
	 * @param loginIds	账号数组
	 * @param content	内容
	 * @return 成功个数
	 */
	public void send(String[] loginIds, String content){
        System.out.println(e);
		Callable<Integer> ca1 = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int count = 0;
				try {
                    for (String loginId : loginIds) {
                        System.out.println("test:"+loginId);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
				return count;
			}
		};
		FutureTask<Integer> ft1 = new FutureTask<Integer>(ca1);
//		new Thread(ft1).start();
        e.submit(ft1);
        e.shutdown();
	}

    public static void main(String[] args) throws InterruptedException {
        LinkMsgCallable linkMsgCallable = new LinkMsgCallable();
        linkMsgCallable.send(new String[]{"aa"}, "");
        Thread.sleep(4000);
        linkMsgCallable.send(new String[]{"bb"}, "");
    }
}
