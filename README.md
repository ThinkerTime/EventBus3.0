# EventBus3.0
EventBus3.0简单使用，没有理论只上代码
1、添加依赖包，在项目的build.gradle
compile 'de.greenrobot:eventbus:3.0.0-beta1'
2、注册EventBus
    2.1)在ouncreate()里注册
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mHello_tv = (TextView) findViewById(R.id.tv_hello);
    EventBus.getDefault().register(this);
}
2.2）在ondestory注销
@Override
protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
}
3、注册观察者方法
@Subscribe(threadMode = ThreadMode.MainThread)
public void helloEventBus(String message){
    mHello_tv.setText(message);

}

@Subscribe(threadMode = ThreadMode.MainThread)
public void likesEventBus(DataSynEvent event){
    mHello_tv.setText(""+event.count);
}

4、注册发布者方法
public void onSend(View view){

    String str="发送测试字符串";
    EventBus.getDefault().post(str);
}
public void onSendMain(View view){
    EventBus.getDefault().post(new DataSynEvent(10));
}

 5、消息实体
public class DataSynEvent {
    public DataSynEvent(int count) {
        this.count = count;
    }

    public int count;
}
6、threadMode共有4中
ThreadMode.MainThread//在ui线程执行
ThreadMode.BackgroundThread//在后台线程执行
ThreadMode.Async//强制在后台执行
ThreadMode.PostThread//默认方式, 在发送线程执行
