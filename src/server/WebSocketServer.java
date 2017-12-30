package server;

import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * Created by HD on 2017/12/29.
 */
public class WebSocketServer {
    public static final int PORT = 10000;

    public static void main(String[] args) {

        WebSocketIoHandler handler = new WebSocketIoHandler();

        NioSocketAcceptor acceptor = new NioSocketAcceptor();

        acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));
        acceptor.setHandler(handler);

        try {
            acceptor.bind(new InetSocketAddress("192.168.100.104",PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
