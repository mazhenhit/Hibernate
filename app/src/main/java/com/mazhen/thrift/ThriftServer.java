package com.mazhen.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class ThriftServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startServer();
	}

	public static void startServer() {
		try {
			int port = Integer.parseInt("9090");
			TServerTransport serverTransport = new TServerSocket(port);
			service2.Processor<ThriftApiImpl> processor = new service2.Processor<ThriftApiImpl>(
					new ThriftApiImpl());
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(processor);
			tArgs.protocolFactory(new TBinaryProtocol.Factory());

			TServer server = new TSimpleServer(tArgs);

			System.out.println("Starting the thrift server at port " + port
					+ "...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
