package com.test.thread;

/**
 * ThreadLocal<T>线程的局部变量，这些变量不同于它们的普通对应物，
 * 因为访问某个变量（通过其 get 或 set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。(官方解释)
 * 
 * 对每个线程来说，相当于把同一个对象复制给了每一个线程，各个线程都有独立的对这个对象的使用权，互不干扰，就跟似有变量一样，
 * 类似于下边代码中的x；
 * 我觉得ThreadLocal的作用就是，将本线程作为key，将ThreadLocal的实例值作为value，保存在map中，对每个线程来说，用get方法就能获取到自己的
 * 那个对象，省去了参数传递的麻烦。Hibernate中的session是最好的例子。
 	private static final ThreadLocal threadSession = new ThreadLocal();

    public static Session getSession() throws InfrastructureException {
        Session s = (Session) threadSession.get();
        try {
            if (s == null) {
                s = getSessionFactory().openSession();
                threadSession.set(s);
            }
        } catch (HibernateException ex) {
            throw new InfrastructureException(ex);
        }
        return s;
    }
	如果不这么写，可能session就要从service层一步步传递到dao层。
 * @author 张超
 *
 * Mar 14, 2013
 */
public class ThreadLocalTest {

	private static final ThreadLocal<Integer> uniqueNum = new ThreadLocal<Integer>(){

		@Override
		protected Integer initialValue() {
			return 0;
		}
		
	};
	
	private static Integer getGenerateId(){
		uniqueNum.set(uniqueNum.get()+1);
		return uniqueNum.get();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			private int x=1;
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					System.out.println(this.getName()+":"+getGenerateId()+"__"+x++);
				}
			}
			
		};
		Thread t2 = new Thread(){
			private int x=1;
			@Override
			public void run() {
				for(int i=0;i<3;i++){
					System.out.println(this.getName()+":"+getGenerateId()+"__"+x++);
				}
			}
			
		};
		
		t1.start();
		t2.start();
		
	}

}
/*output:
Thread-0:1__1
Thread-1:1__1
Thread-0:2__2
Thread-1:2__2
Thread-0:3__3
Thread-1:3__3*///:~
